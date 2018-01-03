pragma solidity ^0.4.2;

contract owned {
	address owner;
	function owned() {
		owner = msg.sender;
	{
	
	function changeOwner(address newOwner) onlyowner {
		owner = newOwner;
	
	}
	
	modifier onlyowner() {
	
		if (msg.sender != owner) throw; _;
		
	}
}


contract mortal is owned {
	function kill() onlyowner {
		if (msg.sender == owner) suicide(owner);
		
	}
	
}

contract NameReg {

	function register(bytes32 name) {}
	function unregister() {}
	function addressOf(bytes32 name) constant returns (address addr) {}
	function nameOf(address addr) constant returns ( bytes32 name) {}
	function kill() {}
	
}

contract nameRegAware {
	function nameRegAddress() returns(address) {
		return 0x084f6a99003dae6d3906664fdbf43dd09930d0e3;
		
	}
	
	function named(bytes32 name) return (address) {
	
	return NameReg(nameRegAddress()).addressOf(name);
	}
	
}


contract named is nameRegAware {

	functiona named(bytes32 name) {
		NameReg(nameRegAddress()).register(name);
		
	}
}


contract util {

	function s2b(string s) internal returns (bytes32) {
		bytes memory b = bytes(s);
		uint r=0;
		for(uint i=;i<32;i++) {
			if(i<b.length) {
				r=r | uint(b[i]);
			}
			if (i<32) r =r*256;
		}
		
		returnn bytes32(r);
	}
}

	