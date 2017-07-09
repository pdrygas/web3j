package org.web3j.protocol.parity;

import java.util.Map;

import org.web3j.crypto.WalletFile;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jService;
import org.web3j.protocol.admin.Personal;
import org.web3j.protocol.admin.methods.response.NewAccountIdentifier;
import org.web3j.protocol.admin.methods.response.PersonalEcRecover;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.VoidResponse;
import org.web3j.protocol.parity.methods.response.PersonalAccountsInfo;
import org.web3j.protocol.parity.methods.response.PersonalRejectRequest;
import org.web3j.protocol.parity.methods.response.PersonalRequestsToConfirm;
import org.web3j.protocol.parity.methods.response.PersonalSign;
import org.web3j.protocol.parity.methods.response.PersonalSignerEnabled;

/**
 * JSON-RPC Request object building factory for Parity.
 */
public interface Parity extends Web3j, Personal {
    static Parity build(Web3jService web3jService) {
        return new JsonRpc2_0Parity(web3jService);
    }

    Request<?, PersonalSignerEnabled> personalSignerEnabled();

    Request<?, PersonalSign> personalSign(String hexMessage, String accountId, String password);

    Request<?, NewAccountIdentifier> personalNewAccountFromPhrase(String phrase, String password);

    Request<?, NewAccountIdentifier> personalNewAccountFromWallet(
            WalletFile walletFile, String password);

    Request<?, org.web3j.protocol.core.methods.response.EthSendTransaction>
            personalSignAndSendTransaction(
            Transaction transaction, String password);

    Request<?, VoidResponse> personalSetAccountName(
            String accountId, String newAccountName);

    Request<?, VoidResponse> personalSetAccountMeta(String accountId, Map<String, Object> metadata);

    Request<?, PersonalAccountsInfo> personalAccountsInfo();

    Request<?, PersonalRequestsToConfirm> personalRequestsToConfirm();

    Request<?, org.web3j.protocol.core.methods.response.EthSendTransaction> personalConfirmRequest(
            String requestId, Transaction transaction, String password);

    Request<?, PersonalRejectRequest> personalRejectRequest(String requestId);

    Request<?, PersonalEcRecover> personalEcRecover(String hexMessage, String signedMessage);
}
