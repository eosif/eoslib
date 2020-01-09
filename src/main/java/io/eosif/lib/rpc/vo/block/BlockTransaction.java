package io.eosif.lib.rpc.vo.block;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Enzo Cotter on 2020/1/7.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BlockTransaction {
    @JsonProperty("status")
    private String status;
    @JsonProperty("trx")
    private BlockTransactionTrx trx;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BlockTransactionTrx getTrx() {
        return trx;
    }

    public void setTrx(BlockTransactionTrx trx) {
        this.trx = trx;
    }
}
