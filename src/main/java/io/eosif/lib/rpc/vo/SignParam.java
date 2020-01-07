package io.eosif.lib.rpc.vo;

import java.util.Date;

/**
 * 
 *  @author espritblock http://eblock.io
 *
 */
public class SignParam {
	/**
	 */
	private Date headBlockTime;
	/**
	 */
	private String chainId;
	/**
	 */
	private Long lastIrreversibleBlockNum;
	/**
	 */
	private Long refBlockPrefix;
	/**
	 */
	private Long exp;

	public Date getHeadBlockTime() {
		return headBlockTime;
	}

	public void setHeadBlockTime(Date headBlockTime) {
		this.headBlockTime = headBlockTime;
	}

	public String getChainId() {
		return chainId;
	}

	public void setChainId(String chainId) {
		this.chainId = chainId;
	}

	public Long getLastIrreversibleBlockNum() {
		return lastIrreversibleBlockNum;
	}

	public void setLastIrreversibleBlockNum(Long lastIrreversibleBlockNum) {
		this.lastIrreversibleBlockNum = lastIrreversibleBlockNum;
	}

	public Long getRefBlockPrefix() {
		return refBlockPrefix;
	}

	public void setRefBlockPrefix(Long refBlockPrefix) {
		this.refBlockPrefix = refBlockPrefix;
	}

	public Long getExp() {
		return exp;
	}

	public void setExp(Long exp) {
		this.exp = exp;
	}

}
