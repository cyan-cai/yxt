package com.java.yxt.util;

/**
 * SM4_Context
 *
 * @author zanglei
 * @version V1.0
 * @description
 * @Package com.java.yxt.util
 * @date 2020/6/30
 *
 */
public class Sm4Context {

    public int mode;

    public long[] sk;

    public boolean isPadding;

    public Sm4Context()
    {
        this.mode = 1;
        this.isPadding = true;
        this.sk = new long[32];
    }
}
