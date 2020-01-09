package io.eosif.lib.rpc.vo.transaction.query;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.eosif.lib.rpc.vo.BaseVo;
import io.eosif.lib.rpc.vo.transaction.Receipt;

/**
 * Created by Enzo Cotter on 2020/1/9.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetTransactionTrx extends BaseVo {
    private Receipt receipt;

    private io.eosif.lib.rpc.vo.transaction.query.GetTransactionTrxTrx trx;

    public io.eosif.lib.rpc.vo.transaction.query.GetTransactionTrxTrx getTrx() {
        return trx;
    }

    public void setTrx(io.eosif.lib.rpc.vo.transaction.query.GetTransactionTrxTrx trx) {
        this.trx = trx;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }
}
