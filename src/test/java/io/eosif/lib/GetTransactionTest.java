package io.eosif.lib;

import io.eosif.lib.Rpc;
import io.eosif.lib.rpc.vo.transaction.query.GetTransactionReq;
import io.eosif.lib.rpc.vo.transaction.query.GetTransactionResp;
import io.eosif.lib.rpc.vo.transaction.query.GetTransactionReq;
import io.eosif.lib.rpc.vo.transaction.query.GetTransactionResp;

/**
 * Created by Enzo Cotter on 2020/1/9.
 */
public class GetTransactionTest {
    public static void main(String[] args) {
        Rpc rpc = new Rpc("http://127.0.0.1:8888");
        GetTransactionReq req = new GetTransactionReq();
        req.setId("dsfasdfasfasdfasfwefwefeasdfasdfadsfasfasdfasdf");
        GetTransactionResp tx = rpc.getTransaction(req);
        System.out.println(tx);


    }
}
