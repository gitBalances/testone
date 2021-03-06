package com.tansuo365.test1.util;

import com.tansuo365.test1.entity.MyLoginInstance;
import lombok.Data;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

//登录实例密码加密
@PropertySource(value="classpath:encrypt.properties")
@Component
public class PasswordEncrypt {

    @Value("${algorithm.name}")
    private String algorithmName;
    @Value("${algorithm.times}")
    private int algorithmTimes;

    /*通过传入实例加密实例的密码*/
    public boolean encryptPWD(MyLoginInstance instance) {
        // 如果在修改的时候没有设置密码，就表示不改动密码
        if (instance.getInstancePassword().length() != 0) {
            String salt = new SecureRandomNumberGenerator().nextBytes().toString();
//            int times = 2;
//            String algorithmName = "md5"; //md5轻易不可逆
            String encodedPassword = new SimpleHash(algorithmName, instance.getInstancePassword(), salt, algorithmTimes).toString();
            instance.setInstanceSalt(salt);
            instance.setInstancePassword(encodedPassword);
            return true;
        } else {
            instance.setInstancePassword(null);
            return false;
        }
    }

    /**
     *
     * @param password 传入密码
     * @return
     */
    public Map<String, Object> encryptPWDBySalt(String password) {
        Map resultMap = null;
        if (password.length() != 0) {
            String salt = new SecureRandomNumberGenerator().nextBytes().toString();
//            String algorithmName = "md5"; //md5轻易不可逆
            String encodedPassword = new SimpleHash(algorithmName, password, salt, algorithmTimes).toString();
            resultMap = new HashMap();
            resultMap.put("encryptPWD",encodedPassword);
            resultMap.put("salt",salt);
            return resultMap;
        }
        return resultMap;
    }

    /**
     * 传入登录实例及普通密码,与数据库中该登录实例的加密密码是否一致.(通过注册时的salt)
     * @param instance
     * @param plainPassword
     * @return
     */
    public boolean passwordComparison(MyLoginInstance instance,String plainPassword){
        String instanceSalt = instance.getInstanceSalt();
        String instancePassword = instance.getInstancePassword();
        String encryptPWD = new SimpleHash(algorithmName,plainPassword,instanceSalt,algorithmTimes).toString();
        if(instancePassword.equals(encryptPWD)){
            return true;
        }else{
            return false;
        }
    }

    /*二次加密*/
    public String encryptPwd(String pwd) {
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
