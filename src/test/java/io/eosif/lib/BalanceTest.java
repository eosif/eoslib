package io.eosif.lib;

import java.math.BigDecimal;

/**
 * Created by Enzo Cotter on 2020/1/9.
 */
public class BalanceTest {
    public static void main(String[] args){
        Rpc rpc = new Rpc("http://127.0.0.1:8888");
        BigDecimal balance=BalanceUtils.queryEosBalance(rpc,"asdfghj","EOS");

        System.out.println(balance);
    }
}
