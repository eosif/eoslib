# eoslib

eoslib 1.1.1 for java 

change writeName add writeUint64 support custom contract

# dependency
```
<dependency>
    <groupId>com.github.eosif</groupId>
    <artifactId>eos-lib</artifactId>
    <version>1.1.1</version>
</dependency>    
```


# use

## support getBlock

```
    public static void main(String[] args){
        Rpc rpc = new Rpc("http://127.0.0.1:8880");
        Block block=rpc.getBlock("123456");
    }

```

## support offline sign transfer
 
 ```
    public static void main(String[] args) {
        //transfer
        Rpc rpc = new Rpc("http://127.0.0.1:8880");
        String fromAccount = "asfesfdsfgws";
        String toAccount = "sceslfkscf";
        String amount = "0.01";
        String symbol = "EOS";
        String memo = "transfer";
        String privateKey = "......";
        TransferUtils.transfer(rpc, fromAccount, toAccount, amount, symbol, memo, privateKey);

    }
	
 ```
 
 ## supoprt offline extransfer
 
 ```
     public static void main(String[] args) {
         //transfer
        Rpc rpc = new Rpc("http://127.0.0.1:8880");
        String fromAccount = "asfesfdsfgws";
        String toAccount = "sceslfkscf";
        String amount = "0.01";
        String symbol = "EOS@eosio.token";
        String memo = "extransfer";
        String privateKey = "......";

        TransferUtils.extransfer(rpc, fromAccount, toAccount, amount, symbol, memo, privateKey);
	
    }
 ```


## voteproducer

 ```
 voteproducer(String pk,String voter,String proxy,List<String> producers)
 	
 ```


## transfer

```

 rpc.transfer(
 	"5KQwrPbwdL6PhXujxW37FSSQZ1JiwsST4cqQzDeyXtP79zkvFD3",
 	"eosio.token",
 	"eosio",
 	"eosio.token",
 	"12.2821 EOS",
 	"");

```
## createAccount

```

 rpc.createAccount(
 	"5KQwrPbwdL6PhXujxW37FSSQZ1JiwsST4cqQzDeyXtP79zkvFD3", 
 	"eosio",
 	"newaccount22",
 	"EOS8eAX54cJtAngV2V22WZhRCW7e4sTAZz1mC5U22vp8mAGuFdMXx",
 	"EOS8eAX54cJtAngV2V22WZhRCW7e4sTAZz1mC5U22vp8mAGuFdMXx", 
 	8192l, 
 	"1.0000 EOS",
 	"1.0000 EOS",
 	0l);
 	
```
## seedPrivate

```

Ecc.seedPrivate("test");

```


## seedPrivate

```

Ecc.seedPrivate("test");

```

## privateToPublic

```

Ecc.privateToPublic(privateKey);

```

## sign

```
Ecc.sign(pk, "test");

```

## data serializa

```
//transfer parse
String data = Ecc.parseTransferData(
	"fromaccount", 
	"toaccount", 
	"10.0020 SYS", 
	"memo"
);

//account parse
String data1 = Ecc.parseAccountData(
	"eosio",
	"espritbloc1.",
	"EOS8eAX54cJtAngV2V22WZhRCW7e4sTAZz1mC5U22vp8mAGuFdMXx",
	"EOS8FPooohZiiCAYXahWCQRxgXXzUbS2gNELAeYCUgGdDMbd2FHQT");

```


 
# License

eoslib is released under GNU/GPL Version 3
