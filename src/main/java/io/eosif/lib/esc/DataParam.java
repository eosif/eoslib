package io.eosif.lib.esc;


import io.eosif.lib.rpc.vo.ExtendedAsset;
import io.eosif.lib.utils.ByteUtils;
import io.eosif.lib.utils.EException;

/**
 * DataParam
 * 
 * @author espritblock http://eblock.io
 *
 */
public class DataParam {
	private ExtendedAsset quality;

	public DataParam(String value, DataType type, Action action) {
		this.value = value;
		this.type = type;
		if (type == DataType.asset || type == DataType.symbol || type == DataType.extended_asset ) {
			if (action == action.transfer || action == action.delegate || action == action.close) {
				String vs[] = value.split(" ");
				if (vs.length < 2) {throw new EException("error", "quantity error");}
				String ammount = vs[0];
				String ams [] = ammount.split("[.]");
				int precision = 0;
				if(ams.length>1) {precision = ams[1].length();}
				String extAsset[] = vs[1].split("@");
				String account = "eosio.token";
				if (extAsset.length > 1) {account = extAsset[1];}
				this.value = vs[0] + " " + action.getCode().replace("${precision}",String.valueOf(precision)).replace("${quantity}", vs[1]).replace("${account}", account);
			} else if (action == action.extransfer) {
				String vs[] = value.split(" ");
				if (vs.length < 2) {throw new EException("error", "quantity error");}
				String ammount = vs[0];
				String ams [] = ammount.split("[.]");
				int precision = 0;
				if(ams.length>1) {precision = ams[1].length();}
				String extAsset[] = vs[1].split("@");
				if (extAsset.length < 2) {throw new EException("error", "quantity error");}
				this.quality = new ExtendedAsset();
				this.quality.setQuantity(vs[0] + " " + extAsset[0]);
				String contract = extAsset[1];
				if (contract.equals("eosio.token")) {
					contract = "eosio";
				}
				this.quality.setContract(contract);
				this.value = value;
			}else {
				this.value = value;
			}
		}
	}

	private String value;

	private DataType type;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public DataType getType() {
		return type;
	}

	public void setType(DataType type) {
		this.type = type;
	}

	public ExtendedAsset getQuality() {
		return quality;
	}

	public void setQuality(ExtendedAsset quality) {
		this.quality = quality;
	}

	public byte[] seria() {
		if (this.type == DataType.name) {
			return ByteUtils.writeName(this.value);
		} else if (this.type == DataType.asset) {
			return ByteUtils.writerAsset(this.value);
		} else if (this.type == DataType.extended_asset) {
			DataParam dp = new DataParam(this.quality.getQuantity(), DataType.asset, Action.transfer);
			dp.setValue(dp.getValue().replace("@eosio.token", ""));
			return ByteUtils.concat(dp.seria(), ByteUtils.writeName(this.quality.getContract()));
		}
		else if (this.type == DataType.symbol) {
			return ByteUtils.writerSymbol(this.value);
		} else if (this.type == DataType.unit32) {
			return ByteUtils.writerUnit32(this.value);
		} else if (this.type == DataType.unit16) {
			return ByteUtils.writerUnit16(this.value);
		} else if (this.type == DataType.key) {
			return ByteUtils.writerKey(this.value);
		} else if (this.type == DataType.varint32) {
			return ByteUtils.writerVarint32(this.value);
		} else if (this.type == DataType.unit64) {
			return ByteUtils.writeUint64(this.value);
		} else {
			return ByteUtils.writerString(this.value);
		}
	}
}

