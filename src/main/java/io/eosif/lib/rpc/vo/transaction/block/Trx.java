package io.eosif.lib.rpc.vo.transaction.block;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Enzo Cotter on 2020/1/7.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Trx {

    String id;
    @JsonProperty("transaction")
    private InnerTransaction transaction;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
