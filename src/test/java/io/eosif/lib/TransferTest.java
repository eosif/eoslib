package io.eosif.lib;

import io.eosif.lib.Rpc;
import io.eosif.lib.TransferUtils;
import io.eosif.lib.rpc.exception.ApiException;
import io.eosif.lib.rpc.vo.SignParam;
import io.eosif.lib.rpc.vo.transaction.Transaction;


public class TransferTest {

    public static void main(String[] args) {
        //transfer
        Rpc rpc = new Rpc("http://127.0.0.1:8888");
        String fromAccount = "abcdefgh";
        String toAccount = "ijklmnopq";
        String amount = "0.01";
        String symbol = "EOS";
        String memo = "123456";
        String privateKey = ".....";
        TransferUtils.transfer(rpc, fromAccount, toAccount, amount, symbol, memo, privateKey);

        //extransfer
        memo = "123456";
        symbol = "EOS@eosio.token";
        TransferUtils.extransfer(rpc, fromAccount, toAccount, amount, symbol, memo, privateKey);

    }


}
