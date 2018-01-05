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
		TxnType trnasactionType;
		string originatingStashName;
		string destinationStashName;
		string originalCurrency;
		string destinationCurrency;
		uint transactionAmt;
		string transactionRemarks;
		TxnStatusType transactionStatus;
		bool     exists;
		
	}
	
	
	//Transactions structure or hashmap
	mapping(uint => Transaction) public transactions;
	mapping(string ==> uint)  publick pendingTransactions;
	
	
	uint trnasactionNum;
	Stash connectoStash;
	
	//Stash registry mapping
	mapping(string => Stash ) bankAccountStashRegistry;
	mapping(string => Stash ) suspenseAccountStashRegistry;
	
	
	//Modifier to check valid stash
	modifier stashExists (string stashName) { if (bankAccountStashRegistry[stashName] == address(0)) throw; _; }
	
	
	//modifier to check suspense stash
	
	modifier suspenseStashExists( string stashName) {  if(suspenseAccountStashRegistry[stashName[ == address(0)) throw; _; }
	
	//modififier to check if trnsaction exists
	modifier  trnsactionExists ( unint _trnsactionNum)  ( if (!transactions[_transactionNum].exists) throw; _; }
	
	//modififier to check if pending trnsaction exists
	modifier  pendingtrnsactionExists ( string _paymentId)  ( if (!transactions[_paymentId].exists) throw; _; }
	
	
	//Event for stash creation
	
	event StashCreatd( string _name ,address _bank);
	
	//Events for stash pledge request , approval , rejection and cancellation
	
	event InitIlpTransfer (uint  trnsactionId);
	event SupenseAccountCreditRequest ( uint transactionId );
	event confirmPaymentAtDestination ( uint trnsactionId);
	event confirmIlpPaymentResponse ( string _paymentId , uint trnsactionId);
	
	function TransactionAgent() {
		transactionNum = 0;
		
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
	Stash stash = new Stash (_bankName, _bankAddress, 9, StashType.SUSPENSE);
	//suspenseAccountStashRegistry[_bankName] = stash;
	
	
	StashCreated(_bankName, _bankAddress);
	}
	
	
	}
	
	// TODO: create a createConnectorStash function as well
	
	function getConnectorStash returns (Stash) {
	
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
	
	
	
	function createTransfer( Stash origStash, Stash destStash, uint _trnsactionAmt , string _remarks )
	returns (uint)
	{
	
	
		origStash.debit(origStash._bankName, _trnsactionAmt, ++transactionNum);
		
		destStash.credit(destStash._bankName, _transactionAnt, transactionNum);
		
		transactions[transactionNum] = Transaction ( { transactionType : TxnType.TRANSFER ,
									origStashName : origStash._bankName,
									destStashName : destStash._bankName,
									transactionAmt : _transactionAmt,
									transactionRemarks : _remarks,
									transactionStatus : TxnStatusType.ACCEPTED,
									exists : true }  ) ;
									
		return transactionNum;
	
	}
	
	
	function rejectTransfer ( uint _transactionNum, string _remarks) returns(uint) {
	
		Transaction tran = transactions[_transactionNum];
		
		Stash origstash = bankAccountStashRegistry[tran.origStashName];
		
		Stash destStash = bankAccountStashRegistry[tran.destStashName];	
	
		origStash.credit(origStash._bankName, tran.txnAmt, ++transactionNum);
		
		destStash.debit(destStash._bankName, tran.txnAmt, transactionNum);
		
		transactions[transactionNum] = Transaction ( { transactionType : TxnType.TRANSFER ,
									origStashName : tran.destStashName,
									destStashName : tran.origStashName,
									transactionAmt : tran.txnAmt,
									transactionRemarks : _remarks,
									transactionStatus : TxnStatusType.REJECTED,
									exists : true }  ) ;
									
		return transactionNum;
	
	}
	
	
	function initIlpTransfer( string _origBankName, uint _txnAmt , string _remarks,
	string _origAccountAddress , string _destAccountAddress , string sourceCurrency ,
	string destinationCurrency , String paymentId , string key1 , string key2) returns (uint) {
	
	
	Stash stash = getBankStash( _origBankName);
	
	if(stash.bankAddr() == address(0)) {throw;}
	
	Stash suspenseStash = getBanksSuspenseStash(_origBankName);
	
	if(stash.getBalance() < _txnAmount) {throw;}
	
	//call createTransfer
	transactionNum = createTransfer(stash, suspenseStash, _txnAmt, _remarks,
		_origAccountAddress , _destAccountAddress ,sourceCurrency ,	 destinationCurrency , 
		paymentId ,key1,key2);
		
		
	pendingTransactions[paymentId]=transactionNum;
	//raise an evnt and notify Ilp
	InitIlpTransfer(paymentId);
	
	return transactionNum;
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	