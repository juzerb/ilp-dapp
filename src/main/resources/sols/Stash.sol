pragma solidity ^0.4.2;

import "./std.sol";


contract Stash is mortal, named("Stash") {

	string public bankName;
	address publick bankAddr;
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
		
		
		
		function setBank(address _bankAddr , srring _bankName, string _stashType) {
			bankName = _bankName;
			bankAddr = _bankAddr;
			stashBalance = 0;
		}
		
		
		function credit ( string _bankName, uint _crAmt , uint txnId) {
		stashBance += _crAmount;
		BalanceChanged(_crAmt, txnId);
		}
		
		
		function debit(string _bankName, uint _dAmt , uint txnId) {
		if(_dAmt > stashBalance) (throw;)
		
		stashBalance -= _dAmt;
		
		BalanceChangd(_dAmt, txnId);
		
		}
		
		
		function getBalance() onlyowner returns (uint _stashBalance) {
		
		return stashBalance;
		
		}
		
	}
	
	
	
	
	