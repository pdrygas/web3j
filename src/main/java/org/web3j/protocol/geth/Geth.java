package org.web3j.protocol.geth;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jService;
import org.web3j.protocol.admin.Personal;
import org.web3j.protocol.admin.methods.response.PersonalEcRecover;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.geth.methods.response.PersonalImportRawKey;
import org.web3j.protocol.geth.methods.response.PersonalLockAccount;
import org.web3j.protocol.geth.methods.response.PersonalSign;

public interface Geth extends Web3j, Personal {

    static Geth build(Web3jService web3jService) {
        return new JsonRpc2_0Geth(web3jService);
    }


    // PERSONAL
    Request<?, PersonalImportRawKey> personalImportRawKey(
            String hexStringNoPrefix, String passphrase);

    Request<?, PersonalLockAccount> personalLockAccount(String address);

    Request<?, PersonalSign> personalSign(String message, String account, String password);

    Request<?, PersonalEcRecover> personalEcRecover(String hexMessage, String signedMessage);
}
