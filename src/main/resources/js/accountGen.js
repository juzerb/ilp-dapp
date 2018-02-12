const argv = require('minimist')(process.argv.slice(2));
const Web3_extended = require('web3_extended');
const providerURL = "http://127.0.0.1";
const providerPort = "22000";

var options = {
    // host: '/home/ubuntu/quorum-examples/7nodes/qdata/dd'+argv.node+'/geth.ipc',
    host: 'httP://localhost:2200'+argv.node,
    // ipc: true,
    personal: true,
    admin: true,
    debug: true,
    eth: true
}

var web3 = Web3_extended.create(options);

function createHash(account) {
    var variable_index;
    if(argv.role === "blockmaker") variable_index = "5";
    else if(argv.role === "voter") variable_index = "3";
    var key = "000000000000000000000000"+account.replace("0x","")
	+"000000000000000000000000000000000000000000000000000000000000000"+variable_index;
    console.log(web3.sha3(key,{"encoding":"hex"}));
}


if (argv.addr) {
    createHash(argv.addr);
} else {
    web3.personal.newAccount("", (error, account) => {
	if (!error) {
	    console.log("Account created: " + account);
	    createHash(account);
	}
    });    
}

