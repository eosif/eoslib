package io.eosif.lib;

import io.eosif.lib.rpc.exception.ApiException;
import io.eosif.lib.rpc.vo.SignParam;
import io.eosif.lib.rpc.vo.transaction.Transaction;

/**
 * Created by Enzo Cotter on 2020/1/8.
 */
public class TransferUtils {
    public static Transaction transfer(Rpc rpc, String fromAccount, String toAccount, String amount, String symbol, String memo, String privateKey) {
        SignParam params = rpc.getOfflineSignParams(60l);
        OfflineSign sign = new OfflineSign();
        String content = "";
        try {

            content = sign.transfer(params, privateKey, "eosio.token",
                    fromAccount, toAccount, String.format("%.4f " + symbol, Double.parseDouble(amount)), memo);
            System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Transaction tx = null;
        try {
            tx = rpc.pushTransaction(content);
        } catch (ApiException ex) {
            System.out.println(ex.getError());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tx;
    }


    public static Transaction extransfer(Rpc rpc, String from, String to, String amount, String symbol, String memo, String privateKey) {
        SignParam params = rpc.getOfflineSignParams(60l);
        OfflineSign sign = new OfflineSign();
        String content = "";
        Transaction tx = null;
        try {
            content = sign.extransfer(params, privateKey, "eosio.token",
                    from, to, String.format("%.4f %s", Double.parseDouble(amount), symbol), memo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            tx = rpc.pushTransaction(content);
        } catch (ApiException ex) {
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tx;
    }
}
