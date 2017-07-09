package org.web3j.protocol.geth;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.web3j.protocol.Web3jService;
import org.web3j.protocol.admin.methods.response.NewAccountIdentifier;
import org.web3j.protocol.admin.methods.response.PersonalEcRecover;
import org.web3j.protocol.admin.methods.response.PersonalListAccounts;
import org.web3j.protocol.admin.methods.response.PersonalUnlockAccount;
import org.web3j.protocol.core.JsonRpc2_0Web3j;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.geth.methods.response.PersonalImportRawKey;
import org.web3j.protocol.geth.methods.response.PersonalLockAccount;
import org.web3j.protocol.geth.methods.response.PersonalSign;

public class JsonRpc2_0Geth extends JsonRpc2_0Web3j implements Geth {
    public JsonRpc2_0Geth(Web3jService web3jService) {
        super(web3jService);
    }

    @Override
    public Request<?, PersonalImportRawKey> personalImportRawKey(
            String hexStringNoPrefix, String passphrase) {
        return new Request<>(
                "personal_importRawKey",
                Arrays.asList(hexStringNoPrefix, passphrase),
                ID,
                web3jService,
                PersonalImportRawKey.class);
    }

    @Override
    public Request<?, PersonalListAccounts> personalListAccounts() {
        return new Request<>(
                "personal_listAccounts",
                Collections.emptyList(),
                ID,
                web3jService,
                PersonalListAccounts.class);
    }

    @Override
    public Request<?, PersonalEcRecover> personalEcRecover(
            String hexMessage, String signedMessage) {

        return new Request<>(
                "personal_ecRecover",
                Arrays.asList(hexMessage, signedMessage),
                ID,
                web3jService,
                PersonalEcRecover.class);
    }

    @Override
    public Request<?, PersonalLockAccount> personalLockAccount(String address) {
        return new Request<>(
                "personal_lockAccount",
                Arrays.asList(address),
                ID,
                web3jService,
                PersonalLockAccount.class);
    }

    @Override
    public Request<?, PersonalUnlockAccount> personalUnlockAccount(
            String address, String passphrase, BigInteger duration) {

        List<Object> attributes = new ArrayList<>(3);
        attributes.add(address);
        attributes.add(passphrase);

        if (duration != null) {
            attributes.add(duration.longValue());
        } else {
            attributes.add(null);
        }

        return new Request<>(
                "personal_unlockAccount",
                attributes,
                ID,
                web3jService,
                PersonalUnlockAccount.class);
    }

    @Override
    public Request<?, PersonalUnlockAccount> personalUnlockAccount(
            String address, String passphrase) {

        return personalUnlockAccount(address, passphrase, null);
    }

    @Override
    public Request<?, NewAccountIdentifier> personalNewAccount(String password) {
        return new Request<>(
                "personal_newAccount",
                Arrays.asList(password),
                ID,
                web3jService,
                NewAccountIdentifier.class);
    }

    @Override
    public Request<?, EthSendTransaction> personalSendTransaction(
            Transaction transaction, String passphrase) {

        return new Request<>(
                "personal_sendTransaction",
                Arrays.asList(transaction, passphrase),
                ID,
                web3jService,
                EthSendTransaction.class);
    }

    @Override
    public Request<?, PersonalSign> personalSign(String message, String account, String password) {
        return new Request<>(
                "personal_sign",
                Arrays.asList(message, account, password),
                ID,
                web3jService,
                PersonalSign.class);
    }
}
