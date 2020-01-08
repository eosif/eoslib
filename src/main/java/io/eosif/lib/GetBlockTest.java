package io.eosif.lib;

import io.eosif.lib.rpc.vo.Block;

/**
 * Created by Enzo Cotter on 2020/1/8.
 */
public class GetBlockTest {
    public static void main(String[] args){
        Rpc rpc = new Rpc("http://127.0.0.1:8870");
        Block block=rpc.getBlock("123456");
        System.out.println();
    }
}
