package org.web3j.protocol.admin;

import java.math.BigInteger;

import org.web3j.protocol.admin.methods.response.NewAccountIdentifier;
import org.web3j.protocol.admin.methods.response.PersonalListAccounts;
import org.web3j.protocol.admin.methods.response.PersonalUnlockAccount;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthSendTransaction;

public interface Personal {
    Request<?, PersonalListAccounts> personalListAccounts();

    Request<?, NewAccountIdentifier> personalNewAccount(String password);

    Request<?, PersonalUnlockAccount> personalUnlockAccount(
            String address, String passphrase);

    Request<?, PersonalUnlockAccount> personalUnlockAccount(
            String address, String passphrase, BigInteger duration);

    Request<?, EthSendTransaction> personalSendTransaction(
            Transaction transaction, String passphrase);
}
