package io.eosif.lib.esc;

/**
 * Action
 * 
 * @author espritblock http://eblock.io
 *
 */
public enum Action {

	transfer("${precision},${quantity}@${account}"), account("account"), ram("ram"), delegate("${precision},${quantity}@eosio.token"), voteproducer("voteproducer"),
	close("${precision},${quantity}@eosio.token"),extransfer("${precision},${quantity}@${account}");

	private String code;

	private Action(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}