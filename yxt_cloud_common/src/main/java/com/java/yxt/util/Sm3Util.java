package com.java.yxt.util;

import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;
import org.springframework.util.StringUtils;

import java.security.Security;
import java.util.Arrays;

/**
 * SM3Utils
 *
 * @author zanglei
 * @version V1.0
 * @description SM3算法工具类（不可逆算法）
 * @Package com.java.yxt.util
 * @date 2020/6/30
 *
 */

public class Sm3Util {

    public static final String KEY="";

    private static final String ENCODEING="UTF-8";

    static {

        Security.addProvider(new BouncyCastleProvider());
    }

    /**
     * sm3算法加密 (不提供密钥)
     * @param paramStr 待加密字符串
     * @return 16进制加密后字符串
     */
    public static String encrypt(String paramStr)throws Exception{
        if(StringUtils.isEmpty(paramStr)){
            return null;
        }

         String resultHexString="";
         //字符串转数组
         byte srcData[] = paramStr.getBytes(ENCODEING);
         //调用hash
         byte [] resultHash=hash(srcData);

        resultHexString = ByteUtils.toHexString(resultHash);
        return resultHexString;
    }

    /**
     * 生成对应的hash值
     * @param srcdata
     * @return
     */
    public static byte[] hash(byte[] srcdata){

        SM3Digest sm3Digest = new SM3Digest();
        sm3Digest.update(srcdata,0,srcdata.length);
        byte hash[]= new byte[sm3Digest.getDigestSize()];
        sm3Digest.doFinal(hash,0);

        return hash;
    }

    /**
     * 通过密钥加密
     * @param srcData 被加密数据
     * @return
     */
    public static byte[] hmac(byte[] srcData)throws Exception{
        if(StringUtils.isEmpty(srcData)){
            return null;
        }

        KeyParameter keyParameter = new KeyParameter(KEY.getBytes(ENCODEING));
        SM3Digest sm3Digest = new SM3Digest();
        HMac mac = new HMac(sm3Digest);
        mac.init(keyParameter);
        mac.update(srcData,0,srcData.length);
        byte[] result = new byte[mac.getMacSize()];
        mac.doFinal(result,0);
        return result;
    }

    /**
     * 校验原数据和加密数据是否一致
     * @param srcStr 源字符串
     * @param sm3HexString 16进制字符串
     * @return 校验结果
     */
    public static boolean verify(String srcStr,String sm3HexString) throws Exception{
        boolean flag = false;
        byte [] srcData = srcStr.getBytes(ENCODEING);
        byte [] sm3Hash = ByteUtils.fromHexString(sm3HexString);
        byte [] newHash = hash(srcData);

        if(Arrays.equals(newHash,sm3Hash)){
            flag = true;
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        String string = Sm3Util.encrypt("abcadfadfadf!#)E)*ELJDDladsfj;=收到啦附件是的发射点发大水asdfasdfasdfdasfd" +
                "sadfssssssssssssssssssssssssssssssssseeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeadsfasd");
        System.out.println(string);
    }

}
