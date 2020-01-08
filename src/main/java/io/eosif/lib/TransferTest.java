package io.eosif.lib;

import io.eosif.lib.rpc.exception.ApiException;
import io.eosif.lib.rpc.vo.SignParam;
import io.eosif.lib.rpc.vo.transaction.Transaction;


public class TransferTest {

    public static void main(String[] args) {
        //transfer
        Rpc rpc = new Rpc("http://127.0.0.1:8870");
        String fromAccount = "asfesfdsfgws";
        String toAccount = "sceslfkscf";
        String amount = "0.01";
        String symbol = "DCCY";
        String memo = "transfer";
        String privateKey = "5......";
        TransferUtils.transfer(rpc, fromAccount, toAccount, amount, symbol, memo, privateKey);

        //extransfer
        memo = "extransfer";
        symbol = "DCCY@eosio.token";
        TransferUtils.extransfer(rpc, fromAccount, toAccount, amount, symbol, memo, privateKey);

    }


}
