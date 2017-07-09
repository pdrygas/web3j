package org.web3j.protocol.geth.methods.response;

import org.web3j.protocol.core.Response;

public class PersonalSign extends Response<String> {

    public String getSignature() {
        return getResult();
    }
}
