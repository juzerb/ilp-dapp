web3.eth.defaultAccount = eth.accounts[0];

var ownedSource = 'pragma solidity ^0.4.2; contract owned { address owner; function owned() { owner = msg.sender; } function changeOwner(address newOwner) onlyowner { owner = newOwner; } modifier onlyowner() { if (msg.sender != owner) throw; _; } }';

var ownedCompiled = web3.eth.compile.solidity(ownedSource);
var ownedContract = web3.eth.contract(ownedCompiled.owned.info.abiDefinition);

var owned = ownedContract.new({from:web3.eth.accounts[0], data: ownedCompiled.owned.code, gas: 1000000}, function(e, contract){
  if(!e) {

    if(!contract.address) {
      console.log("Contract transaction send: TransactionHash: " + contract.transactionHash + " waiting to be mined...");
    } else {
      console.log("Contract mined! Address: " + contract.address);
      console.log(contract);
    }
  }
});
