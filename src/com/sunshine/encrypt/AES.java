package com.sunshine.encrypt;

/**
 * Created by apple on 2018/1/5.
 */

import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * This program generates a AES key, retrieves its raw bytes, and then
 * reinstantiates a AES key from the key bytes. The reinstantiated key is used
 * to initialize a AES cipher for encryption and decryption.
 */

public class AES {

    private static Logger logger = Logger.getLogger("errlog");

    private static final String AES = "AES";

    private static final String API_CRYPT_KEY = "API_CRYPT_KEY";

    private static final String NOTIFY_VUNION_KEY = "SPACE_EMAIL_KEY";

    private static HashMap<String, String> keyMap = new HashMap<String, String>();

    private static String getKey(String keyName) {

        //TODO 读取配置文件，根据keyName获取对应的key值
        return "test_aes_value";
    }

    private static String getValueByKey(Properties p, String keyName) {
        String keyValue = p.getProperty("AES_" + keyName);
        if (keyValue == null) {
            logger.error("error: AES_" + keyName + "=null");
            return null;
        } else {
            keyMap.put(keyName, keyValue);
            return keyValue;
        }
    }

    /**
     * API解密
     *
     * @param data
     * @return
     * @throws Exception
     */
    public final static String APIDecrypt(String data) {
        return paramDecrypt(data, API_CRYPT_KEY);
    }

    /**
     * API加密
     *
     * @param id
     * @return
     * @throws Exception
     */
    public final static String APIEncrypt(String id) {
        return paramEncrypt(id, API_CRYPT_KEY);
    }

    /**
     * API解密
     *
     * @param data
     * @return
     * @throws Exception
     */
    public final static String urlDecrypt(String data) {
        return paramDecrypt(data, NOTIFY_VUNION_KEY);
    }

    /**
     * API加密
     *
     * @param url
     * @return
     * @throws Exception
     */
    public final static String urlEncrypt(String url) {
        return paramEncrypt(url, NOTIFY_VUNION_KEY);
    }

    private final static String paramEncrypt(final String param, final String key){
        if (param == null) {
            return null;
        }

        boolean isTrue = CryptoFactory.createCrypto(AES, getKey(key), AES);
        if (!isTrue) {
            return null;
        }

        CryptoHandle cry = CryptoFactory.getCrypto(AES);
        return cry.encrypt(param);
    }


    private final static String paramDecrypt(final String data, final String key){
        if (data == null) {
            return null;
        }
        boolean isTrue = CryptoFactory.createCrypto(AES, getKey(key), AES);
        if (!isTrue) {
            return null;
        }
        CryptoHandle cry = CryptoFactory.getCrypto(AES);
        return cry.decrypt(data);
    }

    public static void main(String[] args) {

        CryptoFactory.createCrypto("a", "!video@cloud#3$%", "AES");
        CryptoHandle cry = CryptoFactory.getCrypto("a");
        String encryptStr = cry.encrypt("123");
        System.out.println(encryptStr);
        System.out.println(APIEncrypt("123"));
        System.out.println(cry.decrypt(encryptStr));
        System.out.println("video@emailspace".length());

    }
}

