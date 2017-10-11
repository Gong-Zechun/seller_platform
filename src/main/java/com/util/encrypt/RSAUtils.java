/**
 * 创建于: 2016-12-28 下午1:50:28<br>
 * 所属项目:Transn 年会选座系统
 * 文件名称:ProcessorThread.java
 * 作者:Allen Gong
 * 版权信息:Copyright (c) 2016~2016,  All Rights Reserved.
 */
package com.util.encrypt;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLDecoder;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

import javax.crypto.Cipher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;  
  
/**
 * 类功能描述:RSA 工具类。提供加密，解密，生成密钥对等方法。
 * 
 * @history 2012-12-21 Allen Gong 创建RSAUtils.java
 * 
 * @author Allen Gong
 * @version 1.0
* [1.0] 2016-12-28 Allen Gong add 添加RSA 工具类<br>
 */
public class RSAUtils {
	private static final Logger log = LoggerFactory.getLogger(RSAUtils.class);
    /**
     * Key存放文件
     */
    private static final String RSAKeyStore = "RSAKey/RSAKey.txt";  
    /** 
     * * 生成密钥对 * 
     * @return KeyPair * 
     * @throws EncryptException 
     */  
    public static KeyPair generateKeyPair() throws Exception {  
        try {  
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA",  
                    new org.bouncycastle.jce.provider.BouncyCastleProvider());  
            final int KEY_SIZE = 1024;// 没什么好说的了，这个值关系到块加密的大小，可以更改，但是不要太大，否则效率会低  
            keyPairGen.initialize(KEY_SIZE, new SecureRandom());  
            KeyPair keyPair = keyPairGen.generateKeyPair();  
              
            System.out.println(keyPair.getPrivate());  
            System.out.println(keyPair.getPublic());  
              
            saveKeyPair(keyPair);  
            return keyPair;  
        } catch (Exception e) {  
            throw new Exception(e.getMessage());  
        }  
    }  
  
    public static KeyPair getKeyPair() throws Exception { 
    	URL url = Thread.currentThread().getContextClassLoader().getResource(RSAKeyStore);
        FileInputStream fis = new FileInputStream(url.getPath());
        ObjectInputStream oos = new ObjectInputStream(fis);  
        KeyPair kp = (KeyPair) oos.readObject();  
        oos.close();  
        fis.close();  
        return kp;  
    }
  
    public static void saveKeyPair(KeyPair kp) throws Exception {  
    	URL url = Thread.currentThread().getContextClassLoader().getResource(RSAKeyStore);
    	String filePath = url.getPath();
        FileOutputStream fos = new FileOutputStream(filePath);  
        ObjectOutputStream oos = new ObjectOutputStream(fos);  
        // 生成密钥  
        oos.writeObject(kp);  
        oos.close();  
        fos.close();  
    }
  
    /** 
     * * 生成公钥 * 
     *  
     * @param modulus * 
     * @param publicExponent * 
     * @return RSAPublicKey * 
     * @throws Exception 
     */  
    public static RSAPublicKey generateRSAPublicKey(byte[] modulus,  
            byte[] publicExponent) throws Exception {  
        KeyFactory keyFac = null;  
        try {  
            keyFac = KeyFactory.getInstance("RSA",  
                    new org.bouncycastle.jce.provider.BouncyCastleProvider());  
        } catch (NoSuchAlgorithmException ex) {  
            throw new Exception(ex.getMessage());  
        }  
  
        RSAPublicKeySpec pubKeySpec = new RSAPublicKeySpec(new BigInteger(  
                modulus), new BigInteger(publicExponent));  
        try {  
            return (RSAPublicKey) keyFac.generatePublic(pubKeySpec);  
        } catch (InvalidKeySpecException ex) {  
            throw new Exception(ex.getMessage());  
        }  
    }  
  
    /** 
     * * 生成私钥 * 
     *  
     * @param modulus * 
     * @param privateExponent * 
     * @return RSAPrivateKey * 
     * @throws Exception 
     */  
    public static RSAPrivateKey generateRSAPrivateKey(byte[] modulus,  
            byte[] privateExponent) throws Exception {  
        KeyFactory keyFac = null;  
        try {  
            keyFac = KeyFactory.getInstance("RSA",  
                    new org.bouncycastle.jce.provider.BouncyCastleProvider());  
        } catch (NoSuchAlgorithmException ex) {  
            throw new Exception(ex.getMessage());  
        }  
  
        RSAPrivateKeySpec priKeySpec = new RSAPrivateKeySpec(new BigInteger(  
                modulus), new BigInteger(privateExponent));  
        try {  
            return (RSAPrivateKey) keyFac.generatePrivate(priKeySpec);  
        } catch (InvalidKeySpecException ex) {  
            throw new Exception(ex.getMessage());  
        }  
    }  
  
    /** 
     * * 加密 * 
     *  
     * @param key 
     *            加密的密钥 * 
     * @param data 
     *            待加密的明文数据 * 
     * @return 加密后的数据 * 
     * @throws Exception 
     */  
    public static byte[] encrypt(PublicKey pk, byte[] data) throws Exception {  
        try {  
            Cipher cipher = Cipher.getInstance("RSA",  
                    new org.bouncycastle.jce.provider.BouncyCastleProvider());  
            cipher.init(Cipher.ENCRYPT_MODE, pk);  
            int blockSize = cipher.getBlockSize();// 获得加密块大小，如：加密前数据为128个byte，而key_size=1024  
            // 加密块大小为127  
            // byte,加密后为128个byte;因此共有2个加密块，第一个127  
            // byte第二个为1个byte  
            int outputSize = cipher.getOutputSize(data.length);// 获得加密块加密后块大小  
            int leavedSize = data.length % blockSize;  
            int blocksSize = leavedSize != 0 ? data.length / blockSize + 1  
                    : data.length / blockSize;  
            byte[] raw = new byte[outputSize * blocksSize];  
            int i = 0;  
            while (data.length - i * blockSize > 0) {  
                if (data.length - i * blockSize > blockSize)  
                    cipher.doFinal(data, i * blockSize, blockSize, raw, i  
                            * outputSize);  
                else  
                    cipher.doFinal(data, i * blockSize, data.length - i  
                            * blockSize, raw, i * outputSize);  
                // 这里面doUpdate方法不可用，查看源代码后发现每次doUpdate后并没有什么实际动作除了把byte[]放到  
                // ByteArrayOutputStream中，而最后doFinal的时候才将所有的byte[]进行加密，可是到了此时加密块大小很可能已经超出了  
                // OutputSize所以只好用dofinal方法。  
  
                i++;  
            }  
            return raw;  
        } catch (Exception e) {  
            throw new Exception(e.getMessage());  
        }  
    }  
  
    /** 
     * * 解密 * 
     *  
     * @param key 
     *            解密的密钥 * 
     * @param raw 
     *            已经加密的数据 * 
     * @return 解密后的明文 * 
     * @throws Exception 
     */  
    @SuppressWarnings("static-access")
	public static byte[] decrypt(PrivateKey pk, byte[] raw) throws Exception {  
    	Cipher cipher = Cipher.getInstance("RSA",  
                    new org.bouncycastle.jce.provider.BouncyCastleProvider());  
    	cipher.init(cipher.DECRYPT_MODE, pk);  
    	int blockSize = cipher.getBlockSize();  
    	ByteArrayOutputStream bout = new ByteArrayOutputStream(64);  
    	int j = 0;  
  
    	while (raw.length - j * blockSize > 0) {  
    		bout.write(cipher.doFinal(raw, j * blockSize, blockSize));  
    		j++;  
    	}
    	return bout.toByteArray();  
    }
    
    /**
     * RSA解密
     * @param encrypt 密文
     * @return 明文
     * @throws Exception
     */
    public static String decrypt(String encrypt){
//    	byte[] en_result = new BigInteger(mingWen, 16).toByteArray();
    	String decryptStr = "";
    	try{
	    	byte[] en_result = hexStringToBytes(encrypt);
	    	byte[] de_result = RSAUtils.decrypt(RSAUtils.getKeyPair().getPrivate(), en_result);  
	        StringBuffer sb = new StringBuffer();
	        sb.append(new String(de_result));
	        encrypt = sb.reverse().toString();
	        decryptStr = URLDecoder.decode(encrypt,"UTF-8");
    	}catch(Exception e) {
			log.error("后台解密失败, 密文为："+encrypt, e);
		}
        return decryptStr;
    }
    
    /**  
     * 16进制 To byte[]  
     * @param hexString  
     * @return byte[]  
     */  
    public static byte[] hexStringToBytes(String hexString) {  
        if (hexString == null || hexString.equals("")) {  
            return null;  
        }  
        hexString = hexString.toUpperCase();  
        int length = hexString.length() / 2;  
        char[] hexChars = hexString.toCharArray();  
        byte[] d = new byte[length];  
        for (int i = 0; i < length; i++) {  
            int pos = i * 2;  
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));  
        }  
        return d;  
    }  
    /**  
     * Convert char to byte  
     * @param c char  
     * @return byte  
     */  
     private static byte charToByte(char c) {  
        return (byte) "0123456789ABCDEF".indexOf(c);  
    }  
  
    /** 
     * @param args * 
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {  
        RSAPublicKey rsap = (RSAPublicKey) RSAUtils.generateKeyPair().getPublic(); 
        System.out.println(rsap);
        String test = "hello world";  
        byte[] en_test = encrypt(getKeyPair().getPublic(), test.getBytes());  
        byte[] de_test = decrypt(getKeyPair().getPrivate(), en_test);  
        System.out.println(new String(de_test));  
    }  
}  