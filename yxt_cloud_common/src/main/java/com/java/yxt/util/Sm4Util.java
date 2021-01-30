package com.java.yxt.util;


import org.apache.commons.codec.binary.Base64;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * SM4Utils
 *
 * @author zanglei
 * @version V1.0
 * @description SM4加解密（可逆算法）
 * @Package com.java.yxt.util
 * @date 2020/6/30
 */
public class Sm4Util {

    /**
     * convert HexString to byte[]
     *
     * @param hex
     * @return
     */

    public String secretKey = "";
    public String iv = "";
    public boolean hexString = false;
    
    private Pattern p = Pattern.compile("\\s*|\t|\r|\n");

    public Sm4Util() {
    }


    public String encryptDataEcb(String plainText) {
        try {
            Sm4Context ctx = new Sm4Context();
            ctx.isPadding = true;
            ctx.mode = Sm4.SM4_ENCRYPT;

            byte[] keyBytes;
            if (hexString) {
                keyBytes = Util.hexStringToBytes(secretKey);
            } else {
                //keyBytes = secretKey.getBytes();
                keyBytes = Util.hexStringToBytes(secretKey);
            }

            Sm4 sm4 = new Sm4();
            sm4.sm4_setkey_enc(ctx, keyBytes);
            byte[] encrypted = sm4.sm4_crypt_ecb(ctx, plainText.getBytes("UTF-8"));
            return Util.byteToHex(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String decryptDataECB(String cipherText) {
        try {
            byte[] encrypted = Util.hexToByte(cipherText);
            cipherText=Base64.encodeBase64String(encrypted);;
            //cipherText = new BASE64Encoder().encode(encrypted);
            if (cipherText != null && cipherText.trim().length() > 0) {
                Matcher m = p.matcher(cipherText);
                cipherText = m.replaceAll("");
            }

            Sm4Context ctx = new Sm4Context();
            ctx.isPadding = true;
            ctx.mode = Sm4.SM4_DECRYPT;

            byte[] keyBytes;
            if (hexString) {
                keyBytes = Util.hexStringToBytes(secretKey);
            } else {
                keyBytes = secretKey.getBytes();
            }

            Sm4 sm4 = new Sm4();
            sm4.sm4_setkey_dec(ctx, keyBytes);
            byte[] decrypted = sm4.sm4_crypt_ecb(ctx, Base64.decodeBase64(cipherText));
            //byte[] decrypted = sm4.sm4_crypt_ecb(ctx, new BASE64Decoder().decodeBuffer(cipherText));
            return new String(decrypted, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String encryptDataCBC(String plainText) {
        try {
            Sm4Context ctx = new Sm4Context();
            ctx.isPadding = true;
            ctx.mode = Sm4.SM4_ENCRYPT;

            byte[] keyBytes;
            byte[] ivBytes;
            if (hexString) {
                keyBytes = Util.hexStringToBytes(secretKey);
                ivBytes = Util.hexStringToBytes(iv);
            } else {
                keyBytes = secretKey.getBytes();
                ivBytes = iv.getBytes();
            }

            Sm4 sm4 = new Sm4();
            sm4.sm4_setkey_enc(ctx, keyBytes);
            byte[] encrypted = sm4.sm4_crypt_cbc(ctx, ivBytes, plainText.getBytes("UTF-8"));
            return Util.byteToHex(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String decryptDataCBC(String cipherText) {
        try {
            byte[] encrypted = Util.hexToByte(cipherText);
            cipherText=Base64.encodeBase64String(encrypted);;
            //cipherText = new BASE64Encoder().encode(encrypted);
            if (cipherText != null && cipherText.trim().length() > 0) {
                Matcher m = p.matcher(cipherText);
                cipherText = m.replaceAll("");
            }
            Sm4Context ctx = new Sm4Context();
            ctx.isPadding = true;
            ctx.mode = Sm4.SM4_DECRYPT;

            byte[] keyBytes;
            byte[] ivBytes;
            if (hexString) {
                keyBytes = Util.hexStringToBytes(secretKey);
                ivBytes = Util.hexStringToBytes(iv);
            } else {
                keyBytes = secretKey.getBytes();
                ivBytes = iv.getBytes();
            }

            Sm4 sm4 = new Sm4();
            sm4.sm4_setkey_dec(ctx, keyBytes);
            //byte[] decrypted = sm4.sm4_crypt_cbc(ctx, ivBytes, new BASE64Decoder().decodeBuffer(cipherText));
            byte[] decrypted = sm4.sm4_crypt_cbc(ctx, ivBytes, Base64.decodeBase64(cipherText));
            /*String text = new String(decrypted, "UTF-8");
            return text.substring(0,text.length()-1);*/
            return new String(decrypted, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws IOException {
        String plainText = "I Love You Every Dayasdfasdfasdfdas!EWOEUWOUEOWUEOWIUOWUOWUO拉风家啊大家发多少" +
                "啊的撒法发加大力度书法家啊迪斯科飞机啊案例的开放时间佛i啊饿哦发俄方阿斯蒂芬dsalkfsdlfkda;fsdfsddfdfasdfdsf" +
                "dddddddddddddddddddddddddddddddddddddddddddddddddddfdfdfdfdfdaeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee" +
                "ssssssssssssssssssssssssssssssssssssssssssssddddddddddddddddddddddddddddddddddddddddddddddddddd";
        //String s = Util.byteToHex(plainText.getBytes());
        System.out.println("原文" + plainText);
        Sm4Util sm4 = new Sm4Util();
        //sm4.secretKey = "JeF8U9wHFOMfs2Y8";
        sm4.secretKey = "64EC7C763AB7BF64E2D75FF83A319918";
        sm4.hexString = true;

        System.out.println("ECB模式加密");
        String cipherText = sm4.encryptDataEcb(plainText);
        System.out.println("密文: " + cipherText);
        System.out.println("");

        String plainText2 = sm4.decryptDataECB(cipherText);
        System.out.println("明文: " + plainText2);
        System.out.println("");

        System.out.println("CBC模式加密");
        sm4.iv = "31313131313131313131313131313131";
        String cipherText2 = sm4.encryptDataCBC(plainText);
        System.out.println("加密密文: " + cipherText2);
        System.out.println("");

        String plainText3 = sm4.decryptDataCBC(cipherText2);
        System.out.println("解密明文: " + plainText3);

    }
}
