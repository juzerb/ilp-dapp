package com.jpmc.ilp.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.2.0.
 */
public class Std extends Contract {
    private static final String BINARY = "{\r\n"
            + "\t\"linkReferences\": {},\r\n"
            + "\t\"object\": \"6060604052341561000f57600080fd5b6101c08061001e6000396000f30060606040526004361061006d576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806341c0e1b514610072578063bb34534c14610087578063e1fa8e84146100ee578063e79a198f14610115578063f5c573821461012a575b600080fd5b341561007d57600080fd5b61008561017f565b005b341561009257600080fd5b6100ac600480803560001916906020019091905050610181565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34156100f957600080fd5b610113600480803560001916906020019091905050610188565b005b341561012057600080fd5b61012861018b565b005b341561013557600080fd5b610161600480803573ffffffffffffffffffffffffffffffffffffffff1690602001909190505061018d565b60405180826000191660001916815260200191505060405180910390f35b565b6000919050565b50565b565b60009190505600a165627a7a72305820de730132cdf32e7bc16e3d053e5d17c955c784c8e5eb294c9422e405396a300f0029\",\r\n"
            + "\t\"opcodes\": \"PUSH1 0x60 PUSH1 0x40 MSTORE CALLVALUE ISZERO PUSH2 0xF JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST PUSH2 0x1C0 DUP1 PUSH2 0x1E PUSH1 0x0 CODECOPY PUSH1 0x0 RETURN STOP PUSH1 0x60 PUSH1 0x40 MSTORE PUSH1 0x4 CALLDATASIZE LT PUSH2 0x6D JUMPI PUSH1 0x0 CALLDATALOAD PUSH29 0x100000000000000000000000000000000000000000000000000000000 SWAP1 DIV PUSH4 0xFFFFFFFF AND DUP1 PUSH4 0x41C0E1B5 EQ PUSH2 0x72 JUMPI DUP1 PUSH4 0xBB34534C EQ PUSH2 0x87 JUMPI DUP1 PUSH4 0xE1FA8E84 EQ PUSH2 0xEE JUMPI DUP1 PUSH4 0xE79A198F EQ PUSH2 0x115 JUMPI DUP1 PUSH4 0xF5C57382 EQ PUSH2 0x12A JUMPI JUMPDEST PUSH1 0x0 DUP1 REVERT JUMPDEST CALLVALUE ISZERO PUSH2 0x7D JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST PUSH2 0x85 PUSH2 0x17F JUMP JUMPDEST STOP JUMPDEST CALLVALUE ISZERO PUSH2 0x92 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST PUSH2 0xAC PUSH1 0x4 DUP1 DUP1 CALLDATALOAD PUSH1 0x0 NOT AND SWAP1 PUSH1 0x20 ADD SWAP1 SWAP2 SWAP1 POP POP PUSH2 0x181 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 DUP3 PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND DUP2 MSTORE PUSH1 0x20 ADD SWAP2 POP POP PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST CALLVALUE ISZERO PUSH2 0xF9 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST PUSH2 0x113 PUSH1 0x4 DUP1 DUP1 CALLDATALOAD PUSH1 0x0 NOT AND SWAP1 PUSH1 0x20 ADD SWAP1 SWAP2 SWAP1 POP POP PUSH2 0x188 JUMP JUMPDEST STOP JUMPDEST CALLVALUE ISZERO PUSH2 0x120 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST PUSH2 0x128 PUSH2 0x18B JUMP JUMPDEST STOP JUMPDEST CALLVALUE ISZERO PUSH2 0x135 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST PUSH2 0x161 PUSH1 0x4 DUP1 DUP1 CALLDATALOAD PUSH20 0xFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF AND SWAP1 PUSH1 0x20 ADD SWAP1 SWAP2 SWAP1 POP POP PUSH2 0x18D JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 DUP3 PUSH1 0x0 NOT AND PUSH1 0x0 NOT AND DUP2 MSTORE PUSH1 0x20 ADD SWAP2 POP POP PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST JUMP JUMPDEST PUSH1 0x0 SWAP2 SWAP1 POP JUMP JUMPDEST POP JUMP JUMPDEST JUMP JUMPDEST PUSH1 0x0 SWAP2 SWAP1 POP JUMP STOP LOG1 PUSH6 0x627A7A723058 KECCAK256 0xde PUSH20 0x132CDF32E7BC16E3D053E5D17C955C784C8E5EB 0x29 0x4c SWAP5 0x22 0xe4 SDIV CODECOPY PUSH11 0x300F002900000000000000 \",\r\n"
            + "\t\"sourceMap\": \"396:249:0:-;;;;;;;;;;;;;;;;;\"\r\n"
            + "}";

    protected Std(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Std(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<byte[]> nameOf(String addr) {
        Function function = new Function("nameOf", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(addr)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteCall<String> addressOf(byte[] name) {
        Function function = new Function("addressOf", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(name)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> kill() {
        Function function = new Function(
                "kill", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> register(byte[] name) {
        Function function = new Function(
                "register", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(name)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> unregister() {
        Function function = new Function(
                "unregister", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<Std> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Std.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Std> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Std.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static Std load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Std(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Std load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Std(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
