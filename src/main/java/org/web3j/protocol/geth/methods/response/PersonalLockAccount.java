package org.web3j.protocol.geth.methods.response;

import org.web3j.protocol.core.Response;

public class LockedAccount extends Response<Boolean> {

    public boolean success() {
        return getResult();
    }
}
