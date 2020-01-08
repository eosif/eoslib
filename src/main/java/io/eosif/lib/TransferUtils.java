package io.eosif.lib;

import io.eosif.lib.rpc.exception.ApiException;
import io.eosif.lib.rpc.vo.SignParam;
import io.eosif.lib.rpc.vo.transaction.Transaction;

/**
 * Created by Enzo Cotter on 2020/1/8.
 */
public class TransferUtils {
    public static void transfer(Rpc rpc, String fromAccount, String toAccount, String amount, String symbol, String memo,String privateKey) {
        SignParam params = rpc.getOfflineSignParams(60l);
        OfflineSign sign = new OfflineSign();
        String content = "";
        try {

            content = sign.transfer(params, privateKey, "eosio.token",
                    fromAccount, toAccount, String.format("%.4f "+symbol, Double.parseDouble(amount)), memo);
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


    public static void extransfer(Rpc rpc, String from, String to, String amount, String symbol, String memo, String privateKey) {
        SignParam params = rpc.getOfflineSignParams(60l);
        OfflineSign sign = new OfflineSign();
        String content = "";

        try {
            content = sign.extransfer(params, privateKey, "eosio.token",
                    from, to, String.format("%.4f %s", Double.parseDouble(amount), symbol), memo);
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
}
