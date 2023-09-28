package org.encheres.utils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Encrypt {
    public static Result encrypt(String input, String password) {

        // Utilisation d'une clé secrète pré-définie
        byte[] keyBytes = password.getBytes(StandardCharsets.UTF_8); // 16 bytes pour AES
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
        // Chiffrement
        try {
            Cipher encryptCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            encryptCipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] iv = encryptCipher.getIV(); // Initialisation Vector
            byte[] encryptedText = encryptCipher.doFinal(input.getBytes(StandardCharsets.UTF_8));
            return new Result.Builder()
                    .setEncryptedText(Base64.getEncoder().encodeToString(encryptedText))
                    .setOriginal(input)
                    .setIv(Base64.getEncoder().encodeToString(iv))
                    .build();
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException | NoSuchPaddingException |
                 NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }


    public interface Result {

        String encryptedText();

        String iv();

        String original();

        class Builder {
            private String encryptedText;
            private String iv;
            private String original;

            Builder() {

            }

            public Builder setIv(String iv) {
                this.iv = iv;
                return this;
            }

            public Builder setOriginal(String original) {
                this.original = original;
                return this;
            }

            public Builder setEncryptedText(String encryptedText) {
                this.encryptedText = encryptedText;
                return this;
            }

            public Result build() {
                return new Result() {
                    @Override
                    public String encryptedText() {
                        return encryptedText;
                    }

                    @Override
                    public String iv() {
                        return iv;
                    }

                    @Override
                    public String original() {
                        return original;
                    }
                };
            }
        }
    }
}
