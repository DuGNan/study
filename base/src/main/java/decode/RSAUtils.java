package decode;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Enumeration;

/**
 * @Author 杜广楠
 * @Description
 * @Date 2021/4/11 22:43
 */
public class RSAUtils {

    public static final int KEY_SIZE = 2048;

    public static String getPublicKey(String keyPath, String password){
        StringBuilder publicKeyStr = new StringBuilder();
        try {
            KeyStore ks = KeyStore.getInstance("PKCS12");
            FileInputStream is = new FileInputStream(keyPath);
            ks.load(is, password.toCharArray());
            is.close();

            Enumeration aliases = ks.aliases();
            String keyAlias = null;
            if (aliases.hasMoreElements()){
                keyAlias = (String)aliases.nextElement();
            }

            //公钥
            Certificate certificate = ks.getCertificate(keyAlias);
            publicKeyStr.append(Base64.encode(certificate.getPublicKey().getEncoded()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        return publicKeyStr.toString();
    }

    public static String getPrivateKey(String keyPath, String password){
        StringBuilder privateKeyStr = new StringBuilder();
        try {
            KeyStore ks = KeyStore.getInstance("PKCS12");
            FileInputStream is = new FileInputStream(keyPath);
            ks.load(is, password.toCharArray());
            is.close();

            Enumeration aliases = ks.aliases();
            String keyAlias = null;
            if (aliases.hasMoreElements()){
                keyAlias = (String)aliases.nextElement();
            }

            //公钥
            PrivateKey privateKey = (PrivateKey) ks.getKey(keyAlias, password.toCharArray());
            privateKeyStr.append(Base64.encode(privateKey.getEncoded()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        }
        return privateKeyStr.toString();
    }


    /**
     * 使用私钥解密
     *
     * @param contentBase64    待加密内容,base64 编码
     * @param privateKeyBase64 私钥 base64 编码
     * @return
     * @segmentSize 分段大小
     */
    public static String decipher(String contentBase64, String privateKeyBase64) {
        return decipher(contentBase64, privateKeyBase64, KEY_SIZE / 8);
    }

    /**
     * 使用私钥解密（分段解密）
     *
     * @param contentBase64    待加密内容,base64 编码
     * @param privateKeyBase64 私钥 base64 编码
     * @return
     * @segmentSize 分段大小
     */
    public static String decipher(String contentBase64, String privateKeyBase64, int segmentSize) {
        try {
            PrivateKey privateKey = getPrivateKey(privateKeyBase64);
            return decipher(contentBase64, privateKey, segmentSize);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 分段大小
     *
     * @param cipher
     * @param srcBytes
     * @param segmentSize
     * @return
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws IOException
     */
    public static byte[] cipherDoFinal(Cipher cipher, byte[] srcBytes, int segmentSize)
            throws IllegalBlockSizeException, BadPaddingException, IOException {
        if (segmentSize <= 0){
            throw new RuntimeException("分段大小必须大于0");
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int inputLen = srcBytes.length;
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > segmentSize) {
                cache = cipher.doFinal(srcBytes, offSet, segmentSize);
            } else {
                cache = cipher.doFinal(srcBytes, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * segmentSize;
        }
        byte[] data = out.toByteArray();
        out.close();
        return data;
    }

    /**
     * 获取私钥对象
     *
     * @param privateKeyBase64
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public static PrivateKey getPrivateKey(String privateKeyBase64)
            throws NoSuchAlgorithmException, InvalidKeySpecException, Base64DecodingException {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec privatekcs8KeySpec =
                new PKCS8EncodedKeySpec(Base64.decode(privateKeyBase64));
        PrivateKey privateKey = keyFactory.generatePrivate(privatekcs8KeySpec);
        return privateKey;
    }



    /**
     * 分段解密
     *
     * @param contentBase64 密文
     * @param key           解密秘钥
     * @param segmentSize   分段大小（小于等于0不分段）
     * @return
     */
    public static String decipher(String contentBase64, java.security.Key key, int segmentSize) {
        try {
            // 用私钥解密
            byte[] srcBytes = Base64.decode(contentBase64);
            // Cipher负责完成加密或解密工作，基于RSA
            Cipher deCipher = Cipher.getInstance("RSA");
            // 根据公钥，对Cipher对象进行初始化
            deCipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decBytes = null;//deCipher.doFinal(srcBytes);
            if (segmentSize > 0){
                decBytes = cipherDoFinal(deCipher, srcBytes, segmentSize); //分段加密
            } else{
                decBytes = deCipher.doFinal(srcBytes);
            }

            String decrytStr = new String(decBytes);
            return decrytStr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void main(String[] args) throws Exception {
        String privateKey = getPrivateKey("D:\\test_rsa\\user-rsa.pfx", "123456");
        String publicKey = getPublicKey("D:\\test_rsa\\user-rsa.pfx", "123456");
        System.out.println("私钥为：" + privateKey);
        System.out.println("公钥为：" + publicKey);

        String text = "nNB99O65+yYOSHSh/dQOWg9BBS6Hv0MIF9MOjD99yJQhXWCqg10qUFb\n" +
                "s+bBozGGuMvlkNcmsuhDFqiBrGzTI7cCbKhZyp0QcYeFt8I93oHn5WSIMQFb65KU4Vi4N\n" +
                "j5wEUDwPvVkRr3Z6jfScnpkO+n/WhKxTKGmv9yy/MSed93wV7v2VOizto2mOlvug03FOj\n" +
                "h5VcKwyZWhWBakqHXv8/UELBNJhVIiQR52KX2D9/+B5rZyBFfI1nhBzY8qFllWemDfR7o\n" +
                "6pOEH0w016VXkO4+EGxCUnFAPvOoSAWb/uNSXzr/FzCVKUqHvD4BE8yjARg1+naRljIVb\n" +
                "iNzh3NaU1OQ==";
        String data = decipher(text, privateKey);
        System.out.println(data);
    }
}
