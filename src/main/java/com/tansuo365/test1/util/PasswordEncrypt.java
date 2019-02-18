package com.tansuo365.test1.util;

import com.tansuo365.test1.entity.MyLoginInstance;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

import java.security.Key;

//登录实例密码加密
public class PasswordEncrypt {

    /*通过传入实例加密实例的密码*/
    public static void encryptPWD(MyLoginInstance instance) {
        // 如果在修改的时候没有设置密码，就表示不改动密码
        if (instance.getInstancePassword().length() != 0) {
            String salt = new SecureRandomNumberGenerator().nextBytes().toString();
            int times = 2;
            String algorithmName = "md5"; //md5轻易不可逆
            String encodedPassword = new SimpleHash(algorithmName, instance.getInstancePassword(), salt, times).toString();
            instance.setInstanceSalt(salt);
            instance.setInstancePassword(encodedPassword);
        } else {
            instance.setInstancePassword(null);
        }
    }

    /*二次加密*/
    public static String encryptPwd(String pwd) {
        // AES算法实现：
        AesCipherService aesCipherService = new AesCipherService();
        aesCipherService.setKeySize(128); //设置key长度
        //生成key
        Key key = aesCipherService.generateNewKey();
        //加密
        String encrptText = aesCipherService.encrypt(pwd.getBytes(), key.getEncoded()).toHex();

        //解密
//        String text2 = new String(aesCipherService.decrypt(Hex.decode(encrptText), key.getEncoded()).getBytes());

        return encrptText;
    }

}
