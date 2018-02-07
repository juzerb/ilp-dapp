package com.jpmc.ilp.contracts;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.EventValues;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
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
public class Stash_sol_Stash extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b60405161071638038061071683398101604052808051820191906020018051919060200180519190602001805190910190506000848051610054929160200190610092565b5060018054600160a060020a031916600160a060020a03851617905560028290556003818051610088929160200190610092565b505050505061012d565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106100d357805160ff1916838001178555610100565b82800160010185558215610100579182015b828111156101005782518255916020019190600101906100e5565b5061010c929150610110565b5090565b61012a91905b8082111561010c5760008155600101610116565b90565b6105da8061013c6000396000f3006060604052600436106100825763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166305db541d811461008757806312065fe01461011157806327d3580114610136578063326401cf1461014957806359babde5146101855780639b26ef17146101df578063c62f8db21461028d575b600080fd5b341561009257600080fd5b61009a6102e5565b60405160208082528190810183818151815260200191508051906020019080838360005b838110156100d65780820151838201526020016100be565b50505050905090810190601f1680156101035780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561011c57600080fd5b610124610383565b60405190815260200160405180910390f35b341561014157600080fd5b61009a61038a565b341561015457600080fd5b61015c6103f5565b60405173ffffffffffffffffffffffffffffffffffffffff909116815260200160405180910390f35b341561019057600080fd5b6101dd60046024813581810190830135806020601f820181900481020160405190810160405281815292919060208401838380828437509496505084359460200135935061041192505050565b005b34156101ea57600080fd5b6101dd6004803573ffffffffffffffffffffffffffffffffffffffff169060446024803590810190830135806020601f8201819004810201604051908101604052818152929190602084018383808284378201915050505050509190803590602001908201803590602001908080601f01602080910402602001604051908101604052818152929190602084018383808284375094965061046895505050505050565b341561029857600080fd5b6101dd60046024813581810190830135806020601f82018190048102016040519081016040528181529291906020840183838082843750949650508435946020013593506104cf92505050565b60038054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561037b5780601f106103505761010080835404028352916020019161037b565b820191906000526020600020905b81548152906001019060200180831161035e57829003601f168201915b505050505081565b6002545b90565b60008054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561037b5780601f106103505761010080835404028352916020019161037b565b60015473ffffffffffffffffffffffffffffffffffffffff1681565b60025482111561042057600080fd5b6002805483900390557f098e541f764772513aa8ccd611cb4963758156bfc1712852cd585eece3ff0990828260405191825260208201526040908101905180910390a1505050565b600082805161047b929160200190610516565b506001805473ffffffffffffffffffffffffffffffffffffffff191673ffffffffffffffffffffffffffffffffffffffff8516179055600060025560038180516104c9929160200190610516565b50505050565b60028054830190557f098e541f764772513aa8ccd611cb4963758156bfc1712852cd585eece3ff0990828260405191825260208201526040908101905180910390a1505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061055757805160ff1916838001178555610584565b82800160010185558215610584579182015b82811115610584578251825591602001919060010190610569565b50610590929150610594565b5090565b61038791905b80821115610590576000815560010161059a5600a165627a7a723058206e23acbc5e4c1a46c7aabb1fbd560e0a21ae3f38a405eef0d9a722f19353790c0029";

    protected Stash_sol_Stash(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Stash_sol_Stash(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
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

    public RemoteCall<String> bankAddr() {
        Function function = new Function("bankAddr", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
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

    public RemoteCall<TransactionReceipt> setBank(String _bankAddr, String _bankName, String _stashType) {
        Function function = new Function(
                "setBank", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_bankAddr), 
                new org.web3j.abi.datatypes.Utf8String(_bankName), 
                new org.web3j.abi.datatypes.Utf8String(_stashType)), 
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

    public static RemoteCall<Stash_sol_Stash> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _bankName, String _bankAddr, BigInteger _stashBalance, String _stashType) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_bankName), 
                new org.web3j.abi.datatypes.Address(_bankAddr), 
                new org.web3j.abi.datatypes.generated.Uint256(_stashBalance), 
                new org.web3j.abi.datatypes.Utf8String(_stashType)));
        return deployRemoteCall(Stash_sol_Stash.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<Stash_sol_Stash> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _bankName, String _bankAddr, BigInteger _stashBalance, String _stashType) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_bankName), 
                new org.web3j.abi.datatypes.Address(_bankAddr), 
                new org.web3j.abi.datatypes.generated.Uint256(_stashBalance), 
                new org.web3j.abi.datatypes.Utf8String(_stashType)));
        return deployRemoteCall(Stash_sol_Stash.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static Stash_sol_Stash load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Stash_sol_Stash(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Stash_sol_Stash load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Stash_sol_Stash(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class BalanceChangedEventResponse {
        public BigInteger amount;

        public BigInteger txID;
    }
}
