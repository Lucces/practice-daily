package com.sunshine.encrypt;

/**
 * Created by apple on 2018/1/5.
 */
import java.util.HashMap;
import java.util.Map;

public class CryptoFactory {
    private static Map<String, CryptoHandle> handleMaps = new HashMap();

    public CryptoFactory() {
    }

    public static CryptoHandle getCrypto(String name) {
        return !handleMaps.containsKey(name)?null:(CryptoHandle)handleMaps.get(name);
    }

    public static boolean createCrypto(String name, String key, String algorithm) {
        CryptoHandle h = new CryptoHandle();
        if(!h.initialize(key, algorithm)) {
            return false;
        } else {
            handleMaps.put(name, h);
            return true;
        }
    }
}
