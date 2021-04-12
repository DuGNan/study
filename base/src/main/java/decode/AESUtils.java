package decode;

/**
 * @Author 杜广楠
 * @Description
 * @Date 2021/4/11 23:06
 */
import java.security.*;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.Arrays;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESUtils {

    private String ALGO = "AES";
    private String ALGO_MODE = "AES/CBC/NoPadding";

    public String encrypt(String Data, String akey, String aiv) throws Exception {
        try {
            //因为要求IV为16byte，而此处aiv串为32位字符串，所以将32位字符串转为16byte
            byte[] iv = toByteArray(aiv);
            Cipher cipher = Cipher.getInstance(ALGO_MODE);
            int blockSize = cipher.getBlockSize();
            byte[] dataBytes = Data.getBytes();
            int plaintextLength = dataBytes.length;
            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }
            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
            SecretKeySpec keyspec = new SecretKeySpec(akey.getBytes("utf-8"), ALGO);
            IvParameterSpec ivspec = new IvParameterSpec(iv);
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(plaintext);
            String EncStr = (new BASE64Encoder()).encode(encrypted);//将cipher加密后的byte数组用base64加密生成字符串
            return EncStr ;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String decrypt(String encryptedData, String akey, String iv) throws Exception {
        try {
            byte[] encrypted1 = (new BASE64Decoder()).decodeBuffer(encryptedData);
//            byte[] iv = toByteArray(aiv);
            Cipher cipher = Cipher.getInstance(ALGO_MODE);
            SecretKeySpec keyspec = new SecretKeySpec(akey.getBytes("utf-8"), ALGO);
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original);
            return originalString.trim();//此处添加trim（）是为了去除多余的填充字符，就不用去填充了，具体有什么问题我还没有遇到，有强迫症的同学可以自己写一个PKCS7UnPadding函数
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    //此函数是将字符串每两个字符合并生成byte数组
    public static byte[] toByteArray(String hexString) {
        hexString = hexString.toLowerCase();
        final byte[] byteArray = new byte[hexString.length() >> 1];
        int index = 0;
        for (int i = 0; i < hexString.length(); i++) {
            if (index  > hexString.length() - 1)
                return byteArray;
            byte highDit = (byte) (Character.digit(hexString.charAt(index), 16) & 0xFF);
            byte lowDit = (byte) (Character.digit(hexString.charAt(index + 1), 16) & 0xFF);
            byteArray[i] = (byte) (highDit << 4 | lowDit);
            index += 2;
        }
        System.out.println(byteArray.length);
        return byteArray;
    }

    //此函数是pkcs7padding填充函数
    public static String pkcs7padding(String data) {
        int bs = 16;
        int padding = bs - (data.length() % bs);
        String padding_text = "";
        for (int i = 0; i < padding; i++) {
            padding_text += (char)padding;
        }
        return data+padding_text;
    }



    public static void main(String[] args) throws Exception {
        String enCodeKey = "nNB99O65+yYOSHSh/dQOWg9BBS6Hv0MIF9MOjD99yJQhXWCqg10qUFb\n" +
                "s+bBozGGuMvlkNcmsuhDFqiBrGzTI7cCbKhZyp0QcYeFt8I93oHn5WSIMQFb65KU4Vi4N\n" +
                "j5wEUDwPvVkRr3Z6jfScnpkO+n/WhKxTKGmv9yy/MSed93wV7v2VOizto2mOlvug03FOj\n" +
                "h5VcKwyZWhWBakqHXv8/UELBNJhVIiQR52KX2D9/+B5rZyBFfI1nhBzY8qFllWemDfR7o\n" +
                "6pOEH0w016VXkO4+EGxCUnFAPvOoSAWb/uNSXzr/FzCVKUqHvD4BE8yjARg1+naRljIVb\n" +
                "iNzh3NaU1OQ==";
        String privateKey = RSAUtils.getPrivateKey("D:\\test_rsa\\user-rsa.pfx", "123456");
        String key = RSAUtils.decipher(enCodeKey, privateKey);
        String iv = key.substring(0,16);

        System.out.println(iv);
        String code = "svqCqhjPlyGrVkJUCJgVxXXwou2E5qh0HypBjY6JpnEXJO2w0gRXRh9ETl2ScxvZJEId4rRFgfiOCxS+pE\n" +
                "aQoCNsMWV6r1Fjopfyc/7pAP+OK5z1AmcXfUVe6SCI8hVIstSYAKP8hl4w7CUj+VAe7W9\n" +
                "93R3Rb8rnLzrOdSm2YiosJXk2WqNdtBencuJGmMACyw2092xwyGaE9W5EP4Bedx6NWuI/\n" +
                "k/JfxyjrihxX8lQWgKD7g5l5UfG/4H7N2pHGXmQAM+l/mzYZCrCGY/HpRl+khMFYCsaXV\n" +
                "7q5gDiQyrrtTUAF2q5f7gNNs31LGmnxTsYdENm3u1DH00/S/zLhkAQaKxi+ipc/DQnujV\n" +
                "ngqgBJhDMOC6yRxkpswv1fF56r9gtzl6GDf75shDW0+ldorSJR/SOSIeu7sd2qutGLwgh\n" +
                "lW7W50Smre6f1yb1o5dv9rOkA3mExNiIgp0RmntF8exaLhMoruQrlbZZNESZdQN9O5Wpk\n" +
                "+27eHzPpZCjkJyuzVnIR9WMfAtv9BDTNMALVA9thAfJOhMoqDkNH3O2hlt6u2OrrF6dTM\n" +
                "YJ0PeR/epj9Ej3dfpwL+4QMhlO9pNggj+Ub4QgkuXc1Uqrpfmm6UPiqESU4yU0b68IjmB\n" +
                "hEnEhnnvQh8Yruwl+aNjP6of64+TPpHXkTR+jsejXI3uC4hWpP6zy5eMEBjpNmjLNL1MH\n" +
                "KXEm0HxvtfQVjvXkFZJOvMCODJ/06f6vII5gDJqUWjGx1QhBhCwRNEmzV/V6K1+UVI3PI\n" +
                "MzGT408bOsP8f6swUQO6IsobariJP3JXmplbraO08VjchzcKoR8LBK36IxmE7PYHFB2VM\n" +
                "q2rYacQspE5G+tUgNHrR1Q/ae6JsdpQau4U4eEwxE8Xw2aguzQN/o5wm8JGpYKSP5lOoC\n" +
                "b4+L+j1mH1wFpLrkiV855a3Dn2H94sPccffY2QSNJiJWnqvL0KmlK2P2Z1jcAT6Nh2dYG\n" +
                "h3HuSasXmLQ9hAQjlp/iZIhKWbQnhwvdNMH10XpUUhLaL4fmmP/fBAFjcVE2HEz5VuqeA\n" +
                "p3LRss1g0JnsvUDvbIbTLrOfQklFIcpk/9sKjRR7vY23kIwY99D1KpiaDTyblI6s9iLXx\n" +
                "E1POMmSSrvgEpdaAdcXScTnIx0ebmuJhFPwbKHPRnOLUwn9x4Unj1T/RnAIa13Nrc+siU\n" +
                "hSZavHLFNGRRbTspeVzcsbeFTC6RCufZBre9wfUMaxGZYxTOhI8CtLmc7rYQEapzrOaRs\n" +
                "trDA=\",";


        AESUtils aesUtils = new AESUtils();
        System.out.println(aesUtils.decrypt(code, key, iv));;
    }
}
