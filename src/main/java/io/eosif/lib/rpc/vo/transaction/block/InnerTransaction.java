package io.eosif.lib.rpc.vo.transaction.block;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.eosif.lib.rpc.vo.transaction.push.TxAction;

import java.util.List;

/**
 * Created by Enzo Cotter on 2020/1/7.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InnerTransaction {
    @JsonProperty("actions")
    private List<TxAction> actions;

    public List<TxAction> getActions() {
        return actions;
    }

    public void setActions(List<TxAction> actions) {
        this.actions = actions;
    }
}
