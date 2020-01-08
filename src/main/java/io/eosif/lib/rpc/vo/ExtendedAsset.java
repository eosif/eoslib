package io.eosif.lib.rpc.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExtendedAsset {
    @JsonProperty("quantity")
    private String quantity;

    @JsonProperty("contract")
    private String contract;

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }
}
