package io.eosif.lib.rpc.vo.transaction.push;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.eosif.lib.rpc.vo.BaseVo;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author espritblock http://eblock.io
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TxAction extends BaseVo {

	public TxAction() {

	}

	public TxAction(String actor, String account, String name, Object hexdata) {
		this.account = account;
		this.name = name;
		this.data = hexdata;
		this.authorization = new ArrayList<TxActionAuth>();
		this.authorization.add(new TxActionAuth(actor, "active"));
	}

	private String account;

	private String name;

	private List<TxActionAuth> authorization;

	private Object data;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TxActionAuth> getAuthorization() {
		return authorization;
	}

	public void setAuthorization(List<TxActionAuth> authorization) {
		this.authorization = authorization;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
