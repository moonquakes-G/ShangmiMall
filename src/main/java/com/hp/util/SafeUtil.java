package com.hp.util;

import org.springframework.util.Base64Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Curtain-call
 */
public class SafeUtil {

    //静态
    public static String md5(String txt){
        //加密工具
        MessageDigest md = null;
        String str = "";
        try {
            md = MessageDigest.getInstance("md5");
            //设置内容
            md.update(txt.getBytes());
            //加密
            byte[] digest = md.digest();
            //转换回字符串
            str = Base64Utils.encodeToString(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return str;
    }


    public static void main(String[] args) {
        String s = md5("1234");
        System.out.println(s);
    }
}
