package io.eosif.lib.rpc.service;

import io.eosif.lib.rpc.vo.transaction.query.GetTransactionReq;
import io.eosif.lib.rpc.vo.transaction.query.GetTransactionResp;
import io.eosif.lib.rpc.vo.transaction.query.GetTransactionReq;
import io.eosif.lib.rpc.vo.Block;
import io.eosif.lib.rpc.vo.ChainInfo;
import io.eosif.lib.rpc.vo.TableRows;
import io.eosif.lib.rpc.vo.TableRowsReq;
import io.eosif.lib.rpc.vo.account.Account;
import io.eosif.lib.rpc.vo.transaction.Transaction;
import io.eosif.lib.rpc.vo.transaction.push.TxRequest;
import io.eosif.lib.rpc.vo.transaction.query.GetTransactionResp;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.Map;

/**
 * 
 * @author espritblock http://eblock.io
 *
 */
public interface RpcService {

	@GET("/v1/chain/get_info")
	Call<ChainInfo> getChainInfo();

	@POST("/v1/chain/get_block")
	Call<Block> getBlock(@Body Map<String, String> requestFields);

	@POST("/v1/chain/get_account")
	Call<Account> getAccount(@Body Map<String, String> requestFields);

	@POST("/v1/chain/push_transaction")
	Call<Transaction> pushTransaction(@Body TxRequest request);

	@POST("/v1/chain/get_table_rows")
	Call<TableRows> getTableRows(@Body TableRowsReq request);


	@POST("/v1/history/get_transaction")
	Call<GetTransactionResp> getTransaction(@Body GetTransactionReq request);

}
