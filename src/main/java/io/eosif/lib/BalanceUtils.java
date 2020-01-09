package io.eosif.lib;

import io.eosif.lib.rpc.exception.ApiException;
import io.eosif.lib.rpc.vo.SignParam;
import io.eosif.lib.rpc.vo.TableRows;
import io.eosif.lib.rpc.vo.TableRowsReq;
import io.eosif.lib.rpc.vo.transaction.Transaction;

import java.math.BigDecimal;
import java.util.Map;

public class BalanceUtils {

    public static BigDecimal queryEosBalance(Rpc rpc, String account, String symbol) {
        TableRowsReq req = new TableRowsReq();
        req.setCode("eosio.token");
        req.setScope(account);
        req.setTable("accounts");
        req.setJson(true);
        TableRows result = rpc.getTableRows(req);
        if (result.getRows() == null || result.getRows().size() == 0) {
            return BigDecimal.ZERO;
        }
        BigDecimal balanceResult = BigDecimal.ZERO;
        for (Map row : result.getRows()) {
            Map balance = (Map) row.get("balance");
            if (null == balance) {
                continue;
            }
            String quantity = (String) balance.get("quantity");
            if (null == quantity || "".equals(quantity)) {
                continue;
            }
            String qa[] = quantity.split(" ");
            if (null == qa || qa.length != 2) {
                continue;
            }
            if (qa[1].equals(symbol)) {
                balanceResult = new BigDecimal(qa[0]);
                break;
            }
        }
        return balanceResult;
    }
}
