package io.eosif.lib.rpc.vo.transaction.block;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Enzo Cotter on 2020/1/7.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction {
    @JsonProperty("status")
    private String status;
    @JsonProperty("trx")
    private Trx trx;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Trx getTrx() {
        return trx;
    }

    public void setTrx(Trx trx) {
        this.trx = trx;
    }
}
