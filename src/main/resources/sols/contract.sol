pragma solidity ^0.4.2;


contract Stash {
    bytes32 public bankName;
    int public balance;

    event BalanceChanged(int amount, uint txID);

    function Stash(bytes32 _bankName, int _balance) {
	bankName = _bankName;
	balance = _balance;
    }

    function credit(int _crAmt, uint txnId)  {
	balance += _crAmt;
	BalanceChanged(_crAmt, txnId);
    }

    function debit(int _dAmt, uint txnId)  {
	/* if (_dAmt > balance) {throw;} */
	balance -= _dAmt;
	BalanceChanged(_dAmt, txnId);
    }

    function getBalance() constant returns (int) {
    	return balance;
    }
}

contract TransactionAgent {
    uint public txNum;
    mapping (bytes32 => address) public stashRegistry;
    
    address owner;
    modifier onlyowner() { if (msg.sender != owner) throw; _; }

    function TransactionAgent() {
	owner = msg.sender;
	txNum = 1;
    }

    function changeOwner(address newOwner) onlyowner {
	owner = newOwner;
    }

    function registerStash(bytes32 _bankName, address addr) onlyowner {
	stashRegistry[_bankName] = addr;
    }

    function transfer(bytes32 _src, bytes32 _dest, int amount) {
    	Stash src = Stash(stashRegistry[_src]);
	Stash dest = Stash(stashRegistry[_dest]);
	src.debit(amount, txNum);
	dest.credit(amount, txNum++);
    }

    function getStash(bytes32 _bankName) constant returns (int) {
	Stash stash = Stash(stashRegistry[_bankName]);
	return stash.getBalance();
    }

    function pledge(bytes32 _bankName, int amount) {
	Stash stash = Stash(stashRegistry[_bankName]);
	stash.credit(amount, txNum++);
    }

    function redeem(bytes32 _bankName, int amount) {
	Stash stash = Stash(stashRegistry[_bankName]);
	stash.credit(amount, txNum++);
    }
}


