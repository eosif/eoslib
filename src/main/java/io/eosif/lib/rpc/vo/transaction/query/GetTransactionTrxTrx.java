package io.eosif.lib.rpc.vo.transaction.query;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.eosif.lib.rpc.vo.BaseVo;
import io.eosif.lib.rpc.vo.transaction.push.TxAction;

import java.util.List;

/**
 * Created by Enzo Cotter on 2020/1/9.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetTransactionTrxTrx extends BaseVo {
    @JsonProperty("actions")
    private List<TxAction> actions;

    public List<TxAction> getActions() {
        return actions;
    }

    public void setActions(List<TxAction> actions) {
        this.actions = actions;
    }
}
