package io.eosif.lib;

import io.eosif.lib.rpc.exception.ApiException;
import io.eosif.lib.rpc.vo.SignParam;
import io.eosif.lib.rpc.vo.transaction.Transaction;


public class TransferTest {

    public static void main(String[] args) {
        Rpc rpc = new Rpc("http://127.0.0.1:8880");
        String fromAccount = "sdfaassdfew";
        String toAccount = "asdfads";
        String amount = "0.001";
        String privateKey = "5Hzr1sPAJMdsewddgfewSdb5Qm54sDgFVSGRFSUJqdCdHUFJnX1oY";
        String memo = "123456";
        SignParam params = rpc.getOfflineSignParams(3600l);
        OfflineSign sign = new OfflineSign();
        String content = "";
        try {
            content = sign.transfer(params, privateKey, "eosio.token",
                    fromAccount, toAccount, String.format("%.4f EOS", Double.parseDouble(amount)), memo);
            System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Transaction tx = rpc.pushTransaction(content);
            System.out.println(tx.getTransactionId());
        } catch (ApiException ex) {
            System.out.println(ex.getError());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    public static void main(String[] args){
//        String data = Ecc.parseTransferData("qweqweqweqwe", "xin111111111", "0.1000 DCCY", "789");
//        System.out.println(data);
//    }
}
