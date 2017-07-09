package org.web3j.protocol.geth.methods.response;

import org.web3j.protocol.core.Response;

public class PersonalLockAccount extends Response<Boolean> {

    public boolean success() {
        return getResult();
    }
}
