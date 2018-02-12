package com.jpmc.ilp.simple.contracts;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.2.0.
 */
public class Ilpcontract_sol_Stash extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b60405161064138038061064183398101604052808051820191906020018051919060200180519091019050600083805161004d92916020019061006f565b506001829055600281805161006692916020019061006f565b5050505061010a565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106100b057805160ff19168380011785556100dd565b828001600101855582156100dd579182015b828111156100dd5782518255916020019190600101906100c2565b506100e99291506100ed565b5090565b61010791905b808211156100e957600081556001016100f3565b90565b610528806101196000396000f3006060604052600436106100775763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166305db541d811461007c57806312065fe01461010657806327d358011461012b578063455a588b1461013e57806359babde5146101d3578063c62f8db21461022b575b600080fd5b341561008757600080fd5b61008f610283565b60405160208082528190810183818151815260200191508051906020019080838360005b838110156100cb5780820151838201526020016100b3565b50505050905090810190601f1680156100f85780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561011157600080fd5b610119610321565b60405190815260200160405180910390f35b341561013657600080fd5b61008f610328565b341561014957600080fd5b6101d160046024813581810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052818152929190602084018383808284375094965061039395505050505050565b005b34156101de57600080fd5b6101d160046024813581810190830135806020601f82018190048102016040519081016040528181529291906020840183838082843750949650508435946020013593506103c692505050565b341561023657600080fd5b6101d160046024813581810190830135806020601f820181900481020160405190810160405281815292919060208401838380828437509496505084359460200135935061041d92505050565b60028054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156103195780601f106102ee57610100808354040283529160200191610319565b820191906000526020600020905b8154815290600101906020018083116102fc57829003601f168201915b505050505081565b6001545b90565b60008054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156103195780601f106102ee57610100808354040283529160200191610319565b60008280516103a6929160200190610464565b50620186a060015560028180516103c1929160200190610464565b505050565b6001548211156103d557600080fd5b6001805483900390557f098e541f764772513aa8ccd611cb4963758156bfc1712852cd585eece3ff0990828260405191825260208201526040908101905180910390a1505050565b60018054830190557f098e541f764772513aa8ccd611cb4963758156bfc1712852cd585eece3ff0990828260405191825260208201526040908101905180910390a1505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106104a557805160ff19168380011785556104d2565b828001600101855582156104d2579182015b828111156104d25782518255916020019190600101906104b7565b506104de9291506104e2565b5090565b61032591905b808211156104de57600081556001016104e85600a165627a7a72305820267e0d4ca85a97631ac83a26bc7d7f6f74683be38a141cc3c4bd864f88919d9b0029";

    protected Ilpcontract_sol_Stash(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Ilpcontract_sol_Stash(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<BalanceChangedEventResponse> getBalanceChangedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("BalanceChanged", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<BalanceChangedEventResponse> responses = new ArrayList<BalanceChangedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            BalanceChangedEventResponse typedResponse = new BalanceChangedEventResponse();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.txID = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<BalanceChangedEventResponse> balanceChangedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("BalanceChanged", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, BalanceChangedEventResponse>() {
            @Override
            public BalanceChangedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                BalanceChangedEventResponse typedResponse = new BalanceChangedEventResponse();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.txID = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public RemoteCall<String> stashType() {
        Function function = new Function("stashType", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> getBalance() {
        Function function = new Function(
                "getBalance", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> bankName() {
        Function function = new Function("bankName", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> setBank(String _bankName, String _stashType) {
        Function function = new Function(
                "setBank", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_bankName), 
                new org.web3j.abi.datatypes.Utf8String(_stashType)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> debit(String _bankName, BigInteger _dAmt, BigInteger txnId) {
        Function function = new Function(
                "debit", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_bankName), 
                new org.web3j.abi.datatypes.generated.Uint256(_dAmt), 
                new org.web3j.abi.datatypes.generated.Uint256(txnId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> credit(String _bankName, BigInteger _crAmt, BigInteger txnId) {
        Function function = new Function(
                "credit", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_bankName), 
                new org.web3j.abi.datatypes.generated.Uint256(_crAmt), 
                new org.web3j.abi.datatypes.generated.Uint256(txnId)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<Ilpcontract_sol_Stash> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _bankName, BigInteger _stashBalance, String _stashType) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_bankName), 
                new org.web3j.abi.datatypes.generated.Uint256(_stashBalance), 
                new org.web3j.abi.datatypes.Utf8String(_stashType)));
        return deployRemoteCall(Ilpcontract_sol_Stash.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<Ilpcontract_sol_Stash> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _bankName, BigInteger _stashBalance, String _stashType) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_bankName), 
                new org.web3j.abi.datatypes.generated.Uint256(_stashBalance), 
                new org.web3j.abi.datatypes.Utf8String(_stashType)));
        return deployRemoteCall(Ilpcontract_sol_Stash.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static Ilpcontract_sol_Stash load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Ilpcontract_sol_Stash(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Ilpcontract_sol_Stash load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Ilpcontract_sol_Stash(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class BalanceChangedEventResponse {
        public BigInteger amount;

        public BigInteger txID;
    }
}
