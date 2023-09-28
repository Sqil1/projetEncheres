package org.encheres.utils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Decrypt {


    public static String decrypt(String input, String password, String iv) {
        try {
            byte[] keyBytes = password.getBytes(StandardCharsets.UTF_8); // 16 bytes pour AES
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
            Cipher decryptCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(Base64.getDecoder().decode(iv));
            decryptCipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
            byte[] decryptedTextBytes = decryptCipher.doFinal(Base64.getDecoder().decode(input));

            return new String(decryptedTextBytes, StandardCharsets.UTF_8);
        } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException | InvalidKeyException |
                 BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            throw new RuntimeException(e);
        }
    }

}
