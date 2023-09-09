package mm.com.cinematrix.util;

import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Component;

@Component
public class EncryptionUtil {

    public static String encrypt(String valueToEncrypt, String password, String salt) {
        TextEncryptor encryptor = Encryptors.text(password, salt);
        return encryptor.encrypt(valueToEncrypt);
    }

    public static String decrypt(String encryptedValue, String password, String salt) {
        TextEncryptor encryptor = Encryptors.text(password, salt);
        return encryptor.decrypt(encryptedValue);
    }
}
