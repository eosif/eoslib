package io.eosif.lib;

import io.eosif.lib.OfflineSign;
import io.eosif.lib.Rpc;
import io.eosif.lib.rpc.exception.ApiException;
import io.eosif.lib.rpc.vo.SignParam;
import io.eosif.lib.rpc.vo.transaction.Transaction;

/**
 * @author espritblock http://eblock.io
 */
public class OfflineTest {

    public static void main(String[] args) {
//		 testOfflineCreate();
        testOfflineTransfer();
    }


    public static void testOfflineTransfer() {
        Rpc rpc = new Rpc("http://127.0.0.1:8888");
        SignParam params = rpc.getOfflineSignParams(60l);
        OfflineSign sign = new OfflineSign();
        String content = "";
        try {
            content = sign.transfer(params, "....", "eosio.token",
                    "eeeeeeeeeeee", "555555555551", "372.0993 EOS", "test");
            System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Transaction tx = rpc.pushTransaction(content);
            System.out.println(tx.getTransactionId());
        } catch (ApiException ex) {
            System.out.println(ex.getError().getCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
