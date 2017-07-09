package org.web3j.protocol.geth;

import java.math.BigInteger;

import org.junit.Test;

import org.web3j.protocol.RequestTester;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.http.HttpService;

public class RequestTest extends RequestTester {

    private Geth web3j;

    @Override
    protected void initWeb3Client(HttpService httpService) {
        web3j = Geth.build(httpService);
    }

    @Test
    public void testPersonalImportRawKey() throws Exception {
        web3j.personalImportRawKey(
                "380881D28D9844547C310EA025FAF672F5EDD6E108708DA1B7482097F86830C9",
                "passphrase")
             .send();

        //CHECKSTYLE:OFF
        verifyResult("{\"jsonrpc\":\"2.0\",\"method\":\"personal_importRawKey\","
                + "\"params\":[\"380881D28D9844547C310EA025FAF672F5EDD6E108708DA1B7482097F86830C9\",\"passphrase\"],\"id\":1}");
        //CHECKSTYLE:ON
    }

    @Test
    public void testPersonalListAccounts() throws Exception {
        web3j.personalListAccounts().send();

        verifyResult("{\"jsonrpc\":\"2.0\",\"method\":\"personal_listAccounts\","
                + "\"params\":[],\"id\":1}");
    }

    @Test
    public void testPersonalEcRecover() throws Exception {
        //CHECKSTYLE:OFF
        web3j.personalEcRecover("0xdeadbeef","0xf1aabd691c887ee5c98af871239534f194a51fdeb801b1601d77c45afa74dae67ddd81aa5bb8a54b7974ef5be10b55a8535b040883501f76d14cb74e05e5635d1c").send();

        verifyResult("{\"jsonrpc\":\"2.0\",\"method\":\"personal_ecRecover\",\"params\":[\"0xdeadbeef\",\"0xf1aabd691c887ee5c98af871239534f194a51fdeb801b1601d77c45afa74dae67ddd81aa5bb8a54b7974ef5be10b55a8535b040883501f76d14cb74e05e5635d1c\"],\"id\":1}");
        //CHECKSTYLE:ON
    }

    @Test
    public void testPersonalLockAccount() throws Exception {
        web3j.personalLockAccount("0x5e97870f263700f46aa00d967821199b9bc5a120").send();

        verifyResult("{\"jsonrpc\":\"2.0\",\"method\":\"personal_lockAccount\","
                + "\"params\":[\"0x5e97870f263700f46aa00d967821199b9bc5a120\"],\"id\":1}");
    }

    @Test
    public void testPersonalUnlockAccount() throws Exception {
        web3j.personalUnlockAccount(
                "0xfc390d8a8ddb591b010fda52f4db4945742c3809", "hunter2", BigInteger.ONE).send();

        verifyResult("{\"jsonrpc\":\"2.0\",\"method\":\"personal_unlockAccount\","
                + "\"params\":[\"0xfc390d8a8ddb591b010fda52f4db4945742c3809\",\"hunter2\",1],"
                + "\"id\":1}");
    }

    @Test
    public void testPersonalUnlockAccountWithoutDuration() throws Exception {
        web3j.personalUnlockAccount(
                "0xfc390d8a8ddb591b010fda52f4db4945742c3809", "hunter2").send();

        verifyResult("{\"jsonrpc\":\"2.0\",\"method\":\"personal_unlockAccount\","
                + "\"params\":[\"0xfc390d8a8ddb591b010fda52f4db4945742c3809\",\"hunter2\",null],"
                + "\"id\":1}");
    }

    @Test
    public void testPersonalNewAccount() throws Exception {
        web3j.personalNewAccount("password").send();

        verifyResult("{\"jsonrpc\":\"2.0\",\"method\":\"personal_newAccount\","
                + "\"params\":[\"password\"],\"id\":1}");
    }

    @Test
    public void testPersonalSign() throws Exception {
        web3j.personalSign(
                "0xdeadbeaf",
                "0x9b2055d370f73ec7d8a03e965129118dc8f5bf83",
                "password")
            .send();

        verifyResult("{\"jsonrpc\":\"2.0\",\"method\":\"personal_sign\","
                + "\"params\":[\"0xdeadbeaf\",\"0x9b2055d370f73ec7d8a03e965129118dc8f5bf83\","
                + "\"password\"],\"id\":1}");

    }

    @Test
    public void testPersonalSendTransaction() throws Exception {
        web3j.personalSendTransaction(
                new Transaction(
                        "FROM",
                        BigInteger.ONE,
                        BigInteger.TEN,
                        BigInteger.ONE,
                        "TO",
                        BigInteger.ZERO,
                        "DATA"
                ),
                "password")
                .send();

        //CHECKSTYLE:OFF
        verifyResult("{\"jsonrpc\":\"2.0\",\"method\":\"personal_sendTransaction\",\"params\":[{\"from\":\"FROM\",\"to\":\"TO\",\"gas\":\"0x1\",\"gasPrice\":\"0xa\",\"value\":\"0x0\",\"data\":\"0xDATA\",\"nonce\":\"0x1\"},\"password\"],\"id\":1}");
        //CHECKSTYLE:ON
    }
}
