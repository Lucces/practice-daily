package com.sunshine.encrypt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by apple on 2018/1/5.
 */
class BinaryConvert {
    BinaryConvert() {
    }

    public static String byte2hex(byte[] b) {
        if(b == null) {
            return null;
        } else {
            StringBuilder hs = new StringBuilder();
            String stmp = "";

            for(int n = 0; n < b.length; ++n) {
                stmp = Integer.toHexString(b[n] & 255);
                if(stmp.length() == 1) {
                    hs.append("0" + stmp);
                } else {
                    hs.append(stmp);
                }
            }

            return hs.toString().toUpperCase();
        }
    }

    public static byte[] hex2byte(String str) {
        if(str == null) {
            return null;
        } else if(str.equals("")) {
            return new byte[0];
        } else {
            Pattern pattern = Pattern.compile("[0-9a-fA-F]+");
            Matcher match = pattern.matcher(str);
            if(!match.matches()) {
                return null;
            } else if(str.length() % 2 != 0) {
                return null;
            } else {
                byte[] b = str.getBytes();
                byte[] ret = new byte[b.length / 2];

                for(int n = 0; n < b.length; n += 2) {
                    String item = new String(b, n, 2);
                    ret[n / 2] = (byte)Integer.parseInt(item, 16);
                }

                return ret;
            }
        }
    }
}
