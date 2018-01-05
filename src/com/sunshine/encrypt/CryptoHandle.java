package com.sunshine.encrypt;

/**
 * Created by apple on 2018/1/5.
 */
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.apache.log4j.Logger;

public class CryptoHandle {
    private static Logger logger = Logger.getLogger(CryptoHandle.class);
    private Cipher encryptCipher;
    private Cipher decryptCipher;

    public CryptoHandle() {
    }

    public boolean initialize(String key, String algorithm) {
        String alg = algorithm.toUpperCase();

        try {
            SecretKeySpec e = new SecretKeySpec(key.getBytes(), alg);
            this.encryptCipher = Cipher.getInstance(alg);
            this.decryptCipher = Cipher.getInstance(alg);
            this.encryptCipher.init(1, e);
            this.decryptCipher.init(2, e);
            return true;
        } catch (NoSuchAlgorithmException var5) {
            logger.error("Init error. ", var5);
        } catch (NoSuchPaddingException var6) {
            logger.error("Init error. ", var6);
        } catch (InvalidKeyException var7) {
            logger.error("Init error. ", var7);
        }

        return false;
    }

    public String encrypt(String data) {
        if(data == null) {
            return null;
        } else {
            try {
                byte[] e = this.encryptCipher.doFinal(data.getBytes());
                if(e == null) {
                    return null;
                }

                return BinaryConvert.byte2hex(e);
            } catch (IllegalBlockSizeException var3) {
                logger.error("encrypt error", var3);
            } catch (BadPaddingException var4) {
                logger.error("encrypt error", var4);
            }

            return null;
        }
    }

    public String decrypt(String data) {
        if(data == null) {
            return null;
        } else {
            try {
                byte[] e = BinaryConvert.hex2byte(data);
                if(e == null) {
                    return null;
                }

                byte[] finalData = this.decryptCipher.doFinal(e);
                if(finalData == null) {
                    return null;
                }

                return new String(finalData);
            } catch (IllegalBlockSizeException var4) {
                logger.error("decrypt error. ", var4);
            } catch (BadPaddingException var5) {
                logger.error("decrypt error. ", var5);
            } catch (IllegalArgumentException var6) {
                logger.error("decrypt error. ", var6);
            }

            return null;
        }
    }
}
