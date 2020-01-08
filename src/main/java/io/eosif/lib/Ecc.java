package io.eosif.lib;

import io.eosif.lib.ecc.EccTool;
import io.eosif.lib.esc.Ese;
import io.eosif.lib.rpc.vo.transaction.push.TxSign;

import java.math.BigInteger;
import java.util.List;


public class Ecc {


	public static String seedPrivate(BigInteger priKey) {
		return EccTool.privateKeyFromSeed(priKey);
	}
	public static String seedPrivate(byte[] seed) {
		return EccTool.privateKeyFromSeed(seed);
	}


	public static String privateToPublic(String privateKey) {
		return EccTool.privateToPublic(privateKey);
	}

	public static String sign(String privateKey, String data) {
		return EccTool.sign(privateKey, data);
	}
	
	public static String signTransaction(String privateKey, TxSign sign) {
		return EccTool.signTransaction(privateKey, sign);
	}

	public static String parseTransferData(String from, String to, String quantity, String memo) {
		return Ese.parseTransferData(from, to, quantity, memo);
	}
	
	public static String parseVoteProducerData(String voter, String proxy, List<String> producers) {
		return Ese.parseVoteProducerData(voter, proxy, producers);
	}

	public static String parseAccountData(String creator, String name, String onwer, String active) {
		return Ese.parseAccountData(creator, name, onwer, active);
	}

	public static String parseBuyRamData(String payer, String receiver, Long bytes) {
		return Ese.parseBuyRamData(payer, receiver, bytes);
	}

	public static String parseBuyRamData(String from, String receiver, String stakeNetQuantity, String stakeCpuQuantity,
			int transfer) {
		return Ese.parseDelegateData(from, receiver, stakeNetQuantity, stakeCpuQuantity, transfer);
	}
	
	public static String parseCloseData(String owner, String symbol) {
		return Ese.parseCloseData(owner, symbol);
	}

	public static String parseExtransferData(String from, String to, String quantity, String memo) {
		return Ese.parseExtransferData(from, to, quantity, memo);
	}

}
