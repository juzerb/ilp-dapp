pragma solidity ^0.4.2;

import "./std.sol";
import "./Stash.sol";


// import "permissionControlled.sol";

contract TransactionAgent is owned {

// 


	enum TxnStatusType {
		PROPOSED,
		PREPARAED,
		EXECUTED,
		REJECTED
		
		
		}
		
		
		
		//this is to indicate the type of trnasaction
		enum TxnType {
		PLEDGE,
		REDEEM,
		TRANSFER
		
		}
		
		
		
	enum LocStashType {
		POSITIONAL,
		SUSPENSE,
		CONNECTOR
		
	}
	
	//base transaction strucutre
	struct Transaction {
		TxnType transactionType;
		string origStashName;
		string destStashName;
		string originalCurrency;
		string destinationCurrency;
		uint transactionAmt;
		string transactionRemarks;
		TxnStatusType transactionStatus;
		bool     exists;
		
	}
	
	
	//Transactions structure or hashmap
	mapping (uint => Transaction) public transactions;
	mapping(uint => string)  public pendingTransactions;
	
	
	uint transactionNum;
	Stash connectorStash;
	string stashSuspense;
	string stashPositional;
	string stashConnector;
	string currency ;
	
	//Stash registry mapping
	mapping(string => Stash ) bankAccountStashRegistry;
	mapping(string => Stash ) suspenseAccountStashRegistry;
	
	
	//Modifier to check valid stash
	modifier stashExists (string stashName) { if (bankAccountStashRegistry[stashName] == address(0)) throw; _; }
	
	
	
	//modifier to check suspense stash
	
	modifier suspenseStashExists( string stashName) {  if(suspenseAccountStashRegistry[stashName] == address(0)) throw; _; }
	
	//modififier to check if trnsaction exists
	modifier  transactionExists ( uint _trnsactionNum)  { if (!transactions[_trnsactionNum].exists)  throw;  _; }
	
	//modififier to check if pending trnsaction exists
	modifier  pendingtransactionExists ( uint  _paymentId)  { if (!transactions[_paymentId].exists) throw; _; }
	
	
	//Event for stash creation
	
	event StashCreated( string _name ,address _bank);
	
	//Events for stash pledge request , approval , rejection and cancellation
	
	event InitIlpTransfer (uint  trnsactionId, string _paymentId);
	event SupenseAccountCreditRequest ( uint transactionId , string _paymentId );
	event confirmPaymentAtDestination ( uint trnsactionId, string _paymentId);
	event confirmIlpPaymentResponse ( uint trnsactionId,  string _paymentId );
	
	function TransactionAgent() {
		transactionNum = 0;
		stashSuspense="SUSPENSE";
		stashConnector="CONNECTOR";
		stashPositional="POSITIONAL";
		currency="USD";
		
		//create connector stash
		
	//connectorStash = new Stash ( _connectorName, _connectorAddress,9, StashType.CONNECTOR);
	
	
	}
	
	
	
	/*
	createBankStash
	*/
	function createBankStash ( string _bankName, address _bankAddress) {
	//check if stash already exists. if yes return
		if (bankAccountStashRegistry[_bankName] != address(0)) { throw ;}
	
	
	//create a wallet
	Stash stash=new Stash(_bankName, _bankAddress, 9, 'SUSPENSE');
	//suspenseAccountStashRegistry[_bankName] = stash;

	StashCreated(_bankName, _bankAddress);
	
	}
	
	
	
	
	// TODO: create a createConnectorStash function as well
	
	function getConnectorStash () returns (Stash) {
	
	return connectorStash;
	}
	
	
	
	function getBankStash(string _bankName) returns (Stash) {
	
		Stash stash = bankAccountStashRegistry[_bankName];
		if((stash.bankAddr() != address(0) )
			&& ( owner == msg.sender || stash.bankAddr() == msg.sender )) {
				return stash ;
		}
		else {
			throw ;
		}
		
	}
	
	
	function getBanksSuspenseStash(string _bankName) returns (Stash) {
	
		Stash stash = suspenseAccountStashRegistry[_bankName];
		if((stash.bankAddr() != address(0) )
			&& ( owner == msg.sender || stash.bankAddr() == msg.sender )) {
				return stash ;
		}
		else {
			throw ;
		}
		
	}
	
	
	function doesStashExist( string _bankName) returns (bool) {
	
		Stash stash = bankAccountStashRegistry[_bankName];
	
		if(stash.bankAddr() != address(0) ) { return true; }
		else { return false; }
	
	
	
	}
	
	function createSimpleTransfer( string _origBankName , string _origStashType , string _destBankName, string _destStashType, uint _transactionAmt , string _remarks,
	string sourceCurrency , string	 destinationCurrency , string	paymentId )
	returns (uint) {
	    
	    return createTransfer( _origBankName ,  _origStashType ,  _destBankName,  _destStashType,  _transactionAmt ,  _remarks,
 currency,currency ,paymentId);
	    
	    
	    
	}
	
	
	function createTransfer( string _origBankName , string _origStashType , string _destBankName, string _destStashType, uint _transactionAmt , string _remarks,
	string sourceCurrency , string	 destinationCurrency , 
	string	paymentId )
	returns (uint)
	{
	    
	    Stash origStash = getStash(_origBankName,_origStashType);
	    
	    Stash destStash = getStash(_destBankName,_destStashType);
	    
	     
	        
		origStash.debit(_origBankName, _transactionAmt, ++transactionNum);
		
		destStash.credit(_destBankName, _transactionAmt, transactionNum);
		
		transactions[transactionNum] = Transaction ( { transactionType : TxnType.TRANSFER ,
									origStashName : _origBankName,
									destStashName : _destBankName,
									originalCurrency :sourceCurrency,
									destinationCurrency:destinationCurrency,
									transactionAmt : _transactionAmt,
									transactionRemarks : _remarks,
									transactionStatus : TxnStatusType.PROPOSED,
									exists : true }  ) ;
									
		return transactionNum;
	
	
		
	}
	
	
	function getStash(string _bankName , string stashType) returns(Stash) {
	    //keccak256(portcheck) == keccak256("signed")
	    if (keccak256(stashType) == keccak256(stashPositional)) { return getBankStash(_bankName); }
	    
	    else {  
	        if (keccak256(stashType) == keccak256(stashSuspense)) {
	               return getBanksSuspenseStash(_bankName); }
	       else {
	           return getConnectorStash();
	       }
	}
	}
	
	
	function rejectTransfer( uint _transactionNum, string _remarks) returns(uint) {
	
	//	Transaction tran = transactions[_transactionNum];
		
	//	Stash origStash = bankAccountStashRegistry[tran.origStashName];
		
	//	Stash destStash = bankAccountStashRegistry[tran.destStashName];	
	
	//	origStash.credit(origStash.bankName, tran.transactionAmt, ++transactionNum);
		
	//	destStash.debit(destStash._bankName, tran.transactionAmt, transactionNum);
		
	//	transactions[transactionNum] = new Transaction ( { transactionType : TxnType.TRANSFER ,
	//								origStashName : tran.destStashName,
	//								destStashName : tran.origStashName,
	//								transactionAmt : tran.txnAmt,
    //									transactionRemarks : _remarks,
	//								transactionStatus : TxnStatusType.REJECTED,
	//								exists : true }  ) ;
									
		return transactionNum;
	
	}
	
	
	function initIlpTransfer( string _origBankName, uint _txnAmt , string _remarks,
	string _origAccountAddress , string _destAccountAddress , string sourceCurrency ,
	string destinationCurrency , string paymentId ) returns (uint) {
	
	
	Stash stash = getBankStash( _origBankName);
	
	if(stash.bankAddr() == address(0)) {throw;}
	
	Stash suspenseStash = getBanksSuspenseStash(_origBankName);
	
	if(stash.getBalance() < _txnAmt) { throw;}
	
	
	
	//call createTransfer
	transactionNum = createTransfer(_origBankName,stashPositional , _origBankName , stashSuspense,   _txnAmt, _remarks,
		 sourceCurrency ,	 destinationCurrency , paymentId );
		
		
	pendingTransactions[transactionNum]=paymentId;
	//raise an evnt and notify Ilp
	InitIlpTransfer(transactionNum,paymentId);
	
	return transactionNum;
	
	}
	
	
	
	/**
	 *  function processIlpPaymentTransferRequest
	 *
	 */
	function processIlpPaymentTransferRequest( string payids,string _destAccountAddress,uint _txnAmt , string _remarks, string sourCurr, string destCurr) 
	returns (uint) {
	    
	    Stash connectorStash = getConnectorStash();
	    if(connectorStash.bankAddr() == address(0)) {throw;}
	    
	    
	    
	    Stash stash = getBankStash(_destAccountAddress);
	    
	    
	  //  transactionNum = createTransfer(stashPositional,stashConnector,_destAccountAddress,stashSuspense, _txnAmt,_remarks,
		// sourCurr,destCurr , payids );
	    
	    SupenseAccountCreditRequest(transactionNum,payids);
	    
	    return transactionNum;
	    
	    
	    
	}
	
	
	
	/*
	* function confirmPaymentRequestAtDestination
	* 1. debit suspenseStash
	* 2. credit position stash of reciver bank
	
	*/
	function confirmPaymentRequestAtDestination(uint _payTransactionId,string paymentId )
	returns (uint)  {
	    
	 //  transactionExists(_payTransactionId);
	   
	   Transaction tran = transactions[_payTransactionId];
	   
	   string sourceCurrency = tran.originalCurrency;
	   string destinationCurrency = tran.destinationCurrency;
	    uint _txnAmt = tran.transactionAmt;
	    string _remarks = tran.transactionRemarks;
	    string destStashName = tran.destStashName;
	   // string tranaferStashName = tran.destStashName;

	   // get most details from transaction and create new transaction for recievr bank 
	   //transactionNum = createTransfer(destStashName,stashSuspense , tranaferStashName , stashPositional,_txnAmt,_remarks,
	//	 sourceCurrency ,destinationCurrency, paymentId);
		 
		 
		Stash origStash = getBanksSuspenseStash(destStashName);
	    
	    Stash destStash = getBankStash(destStashName);
		 
		 
		 
		origStash.debit(destStashName, _txnAmt, ++transactionNum);
		
		destStash.credit(destStashName, _txnAmt, transactionNum);
		
		transactions[transactionNum] = Transaction ( { transactionType : TxnType.TRANSFER ,
									origStashName : destStashName,
									destStashName : destStashName,
									originalCurrency :sourceCurrency,
									destinationCurrency:destinationCurrency,
									transactionAmt : _txnAmt,
									transactionRemarks : _remarks,
									transactionStatus : TxnStatusType.PREPARAED,
									exists : true }  ) ;
		 
		 
		 
	   
	   confirmPaymentAtDestination(transactionNum,paymentId);
	    
	    return transactionNum;
	}
	
	
	
	/*
	* function : procss IlpTransferResponse
	* get paymnt Id - validate this transaction 
	*/
	function processIlpPaymentTransferResponse(string _paytId, uint txnNum) 
	returns(uint) {
	    
	    //TODO : check status is SUCCESS
	    
	    //uint txnNum = pendingTransactions[_paymentId];
	    
	    Transaction tran = transactions[txnNum];
	    
	    //get all details from transaction 
	    
	    //get all txn details
	    //transactionNum = createTransfer();
	    string sourceCurrency = tran.originalCurrency;
	   string destinationCurrency = tran.destinationCurrency;
	    uint _txnAmt = tran.transactionAmt;
	    string _remarks = tran.transactionRemarks;
	    string destStashName = tran.destStashName;
	    
	    
// 	     transactionNum = createTransfer(tran.destStashName,stashSuspense, 
// 	     stashPositional , stashConnector,   _txnAmt, _remarks,tran.originalCurrency,
// 		 tran.destinationCurrency,_paytId );
		 
		 
		Stash origStash = getBanksSuspenseStash(destStashName);
	    
	    Stash destStash = getConnectorStash();
		 
		 
		 
		origStash.debit(destStashName, _txnAmt, ++transactionNum);
		
		destStash.credit(destStashName, _txnAmt, transactionNum);
		
		transactions[transactionNum] = Transaction ( { transactionType : TxnType.TRANSFER ,
									origStashName : destStashName,
									destStashName : stashConnector,
									originalCurrency :sourceCurrency,
									destinationCurrency:destinationCurrency,
									transactionAmt : _txnAmt,
									transactionRemarks : _remarks,
									transactionStatus : TxnStatusType.EXECUTED,
									exists : true }  ) ;
		 
		 
		 
	    
	    confirmIlpPaymentResponse(transactionNum,_paytId);
	    
	    return transactionNum;
	  // return transactionNum;
	    
	}
	
	
	}
	