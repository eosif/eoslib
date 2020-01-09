package io.eosif.lib.rpc.vo.transaction.query;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.eosif.lib.rpc.vo.BaseVo;

/**
 * Created by Enzo Cotter on 2020/1/9.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetTransactionResp extends BaseVo {
    private String id;
    private io.eosif.lib.rpc.vo.transaction.query.GetTransactionTrx trx;


    public io.eosif.lib.rpc.vo.transaction.query.GetTransactionTrx getTrx() {
        return trx;
    }

    public void setTrx(io.eosif.lib.rpc.vo.transaction.query.GetTransactionTrx trx) {
        this.trx = trx;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
