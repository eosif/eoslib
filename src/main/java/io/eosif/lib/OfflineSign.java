package io.eosif.lib;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.eosif.lib.esc.Action;
import io.eosif.lib.esc.DataParam;
import io.eosif.lib.esc.DataType;
import io.eosif.lib.esc.Ese;
import io.eosif.lib.rpc.vo.SignParam;
import io.eosif.lib.rpc.vo.transaction.push.Tx;
import io.eosif.lib.rpc.vo.transaction.push.TxAction;
import io.eosif.lib.rpc.vo.transaction.push.TxRequest;
import io.eosif.lib.rpc.vo.transaction.push.TxSign;

import java.text.SimpleDateFormat;
import java.util.*;



/**
 * 
 * @author espritblock http://eblock.io
 *
 */
public class OfflineSign {

	SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

	public OfflineSign() {
		dateFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
	}

	/**
	 * 
	 * @param compression
	 * @param pushTransaction
	 * @param signatures
	 * @return
	 * @throws Exception
	 */
	public String pushTransaction(String compression, Tx pushTransaction, String[] signatures) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String mapJakcson = mapper.writeValueAsString(new TxRequest(compression, pushTransaction, signatures));
		return mapJakcson;
	}

	public String transfer(SignParam signParam, String pk, String contractAccount, String from, String to,
						   String quantity, String memo) throws Exception {
		Tx tx = new Tx();
		tx.setExpiration(signParam.getHeadBlockTime().getTime() / 1000 + signParam.getExp());
		tx.setRef_block_num(signParam.getLastIrreversibleBlockNum());

		tx.setRef_block_prefix(signParam.getRefBlockPrefix());
		tx.setNet_usage_words(0l);
		tx.setMax_cpu_usage_ms(0l);
		tx.setDelay_sec(0l);
		// actions
		List<TxAction> actions = new ArrayList<TxAction>();
		// data
		Map<String, Object> dataMap = new LinkedHashMap<String, Object>();
		dataMap.put("from", from);
		dataMap.put("to", to);
		dataMap.put("quantity", new DataParam(quantity, DataType.asset, Action.transfer).getValue());
		dataMap.put("memo", memo);
		// action
		TxAction action = new TxAction(from, contractAccount, "transfer", dataMap);
		actions.add(action);
		tx.setActions(actions);
		// sgin
		String sign = Ecc.signTransaction(pk, new TxSign(signParam.getChainId(), tx));
		// data parse
		String data = Ecc.parseTransferData(from, to, quantity, memo);
		// reset data
		action.setData(data);
		// reset expiration
		tx.setExpiration(dateFormatter.format(new Date(1000 * Long.parseLong(tx.getExpiration().toString()))));
		return pushTransaction("none", tx, new String[] { sign });
	}
	public String extransfer(SignParam signParam, String pk, String contractAccount, String from, String to,
							 String quantity, String memo) throws Exception {
		Tx tx = new Tx();
		tx.setExpiration(signParam.getHeadBlockTime().getTime() / 1000 + signParam.getExp());
		tx.setRef_block_num(signParam.getLastIrreversibleBlockNum());
		tx.setRef_block_prefix(signParam.getRefBlockPrefix());
		tx.setNet_usage_words(0l);
		tx.setMax_cpu_usage_ms(0l);
		tx.setDelay_sec(0l);
		// actions
		List<TxAction> actions = new ArrayList<>();
		// data
		Map<String, Object> dataMap = new LinkedHashMap<>();
		dataMap.put("from", from);
		dataMap.put("to", to);
		dataMap.put("quantity", new DataParam(quantity, DataType.asset, Action.extransfer).getValue());
		dataMap.put("memo", memo);
		// action
		System.out.println(dataMap);
		TxAction action = new TxAction(from, contractAccount, "extransfer", dataMap);
		actions.add(action);
		tx.setActions(actions);
		// sgin

		String sign = Ecc.signTransaction(pk, new TxSign(signParam.getChainId(), tx));
		// data parse
		String data = Ecc.parseExtransferData(from, to, quantity, memo);
		// reset data
		action.setData(data);
		// reset expiration
		tx.setExpiration(dateFormatter.format(new Date(1000 * Long.parseLong(tx.getExpiration().toString()))));
		return pushTransaction("none", tx, new String[] { sign });
	}
	public String createAccount(SignParam signParam, String pk, String creator, String newAccount, String owner,
			String active, Long buyRam) throws Exception {
		Tx tx = new Tx();
		tx.setExpiration(signParam.getHeadBlockTime().getTime() / 1000 + signParam.getExp());
		tx.setRef_block_num(signParam.getLastIrreversibleBlockNum());
		tx.setRef_block_prefix(signParam.getRefBlockPrefix());
		tx.setNet_usage_words(0l);
		tx.setMax_cpu_usage_ms(0l);
		tx.setDelay_sec(0l);
		// actions
		List<TxAction> actions = new ArrayList<TxAction>();
		tx.setActions(actions);
		// create
		Map<String, Object> createMap = new LinkedHashMap<>();
		createMap.put("creator", creator);
		createMap.put("name", newAccount);
		createMap.put("owner", owner);
		createMap.put("active", active);
		TxAction createAction = new TxAction(creator, "eosio", "newaccount", createMap);
		actions.add(createAction);
		// buyrap
		Map<String, Object> buyMap = new LinkedHashMap<String, Object>();
		buyMap.put("payer", creator);
		buyMap.put("receiver", newAccount);
		buyMap.put("bytes", buyRam);
		TxAction buyAction = new TxAction(creator, "eosio", "buyrambytes", buyMap);
		actions.add(buyAction);
		// sgin
		String sign = Ecc.signTransaction(pk, new TxSign(signParam.getChainId(), tx));
		// data parse
		String accountData = Ese.parseAccountData(creator, newAccount, owner, active);
		createAction.setData(accountData);
		// data parse
		String ramData = Ese.parseBuyRamData(creator, newAccount, buyRam);
		buyAction.setData(ramData);
		// reset expiration
		tx.setExpiration(dateFormatter.format(new Date(1000 * Long.parseLong(tx.getExpiration().toString()))));
		return pushTransaction("none", tx, new String[] { sign });
	}
}
