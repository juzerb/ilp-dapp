pragma solidity ^0.4.2;

import "./std.sol";


contract Stash   {

	string public bankName;
	address public bankAddr;
	uint stashBalance;
	string public stashType;
	
	
	
	enum StashType {
	POSITIONAL,
	SUSPENSE,
	CONNECTOR
	}
	
	
	//Events
	event BalanceChanged(uint amount, uint txID);
	
	//Modifier to check if the caller is owner ( transaction agent)
	// modifier isOwner(address addr) { if (addr!= owner) throw; _; }
	
	
	
	function Stash(string _bankName, address _bankAddr , uint _stashBalance , string _stashType) {
		bankName = _bankName;
		bankAddr = _bankAddr;
		stashBalance = _stashBalance;
		stashType = _stashType;
		
		}
		
		
		
	function setBank(address _bankAddr , string _bankName, string _stashType) {
			bankName = _bankName;
			bankAddr = _bankAddr;
			stashBalance = 0;
			stashType = _stashType;
		}
		
		
	function credit ( string _bankName, uint _crAmt , uint txnId) {
		stashBalance += _crAmt;
		BalanceChanged(_crAmt, txnId);
		}
		
		
	function debit(string _bankName, uint _dAmt , uint txnId) {
		if(_dAmt > stashBalance) {throw;}
		
		stashBalance -= _dAmt;
		
		BalanceChanged(_dAmt, txnId);
		
		}
		
		
	function getBalance()  returns (uint _stashBalance) {
		
		return stashBalance;
		
		}
		
	}