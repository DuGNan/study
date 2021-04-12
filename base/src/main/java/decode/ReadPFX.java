package decode;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Enumeration;

public class ReadPFX {

    public static void readFile(String keyStorePath , String password) throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException {
        // 实例化密钥库，默认JKS类型
        KeyStore ks = KeyStore.getInstance("PKCS12");
        // 获得密钥库文件流
        FileInputStream is = new FileInputStream(keyStorePath);
        // 加载密钥库
        ks.load(is, password.toCharArray());
        // 关闭密钥库文件流
        is.close();

        //私钥
        Enumeration aliases = ks.aliases();
        String keyAlias = null;
        if (aliases.hasMoreElements()){
            keyAlias = (String)aliases.nextElement();
            System.out.println("p12's alias----->"+keyAlias);
        }
        PrivateKey privateKey = (PrivateKey) ks.getKey(keyAlias, password.toCharArray());
        String privateKeyStr = Base64.encode(privateKey.getEncoded());
        System.out.println("私钥------------->" + privateKeyStr);

        //公钥
        Certificate certificate = ks.getCertificate(keyAlias);
        String publicKeyStr = Base64.encode(certificate.getPublicKey().getEncoded());
        System.out.println("公钥------------->"+publicKeyStr);
    }

    public static void main(String[] args) {
        try {
            readFile("D:\\test_rsa\\user-rsa.pfx", "123456");
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        }
    }
}