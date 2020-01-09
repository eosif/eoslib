package io.eosif.lib.rpc.vo.block;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Enzo Cotter on 2020/1/7.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BlockTransactionTrx {

    String id;
    @JsonProperty("transaction")
    private BlockTransactionTrxTransaction transaction;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BlockTransactionTrxTransaction getTransaction() {
        return transaction;
    }

    public void setTransaction(BlockTransactionTrxTransaction transaction) {
        this.transaction = transaction;
    }
}
