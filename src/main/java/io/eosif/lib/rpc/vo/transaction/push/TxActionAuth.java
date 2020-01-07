package io.eosif.lib.rpc.vo.transaction.push;


import io.eosif.lib.rpc.vo.BaseVo;

/**
 * 
 * @author espritblock http://eblock.io
 *
 */
public class TxActionAuth extends BaseVo {

	public TxActionAuth() {

	}

	public TxActionAuth(String actor, String permission) {
		this.actor = actor;
		this.permission = permission;
	}

	private String actor;

	private String permission;

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

}
