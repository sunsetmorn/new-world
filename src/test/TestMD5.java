package test;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestMD5 {
    public static void main(String[] args) throws Exception{
        String ss = "D7A3A27B2C4809DBC59914158D221385";
        String s2 = "971A2DDD636E0A264F68AD8943081CC2";
        String s3 = "";

        try {
            byte[] bytes = MessageDigest.getInstance("MD5").digest(s3.getBytes("UTF-8"));
            StringBuilder sign = new StringBuilder();
            for (byte b : bytes) {
                String hex = Integer.toHexString(b & 0xFF);
                if (hex.length() == 1) {
                    sign.append("0");
                }
                sign.append(hex.toUpperCase());
            }
            String s = sign.toString();
            System.out.println(s);
            System.out.println(new Date());
            System.out.println(new SimpleDateFormat("yyyyMMddHHmmss").parse("20230423113730"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
