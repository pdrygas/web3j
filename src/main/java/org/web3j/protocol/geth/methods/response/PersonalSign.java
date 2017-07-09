package org.web3j.protocol.geth.methods.response;

import org.web3j.protocol.core.Response;

public class Signed extends Response<String> {

    public String getSignature() {
        return getResult();
    }
}
