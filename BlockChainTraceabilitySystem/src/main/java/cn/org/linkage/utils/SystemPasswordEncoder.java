package cn.org.linkage.utils;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
* @Description:    用于密码加密，使用MD5加密方式加密，但是这种方式现在已经不足够安全，建议使用BCRY加密方式
* @Author:         ACtangle
* @CreateDate:     2018/11/22 11:44
* @UpdateUser:     ACtangle
* @UpdateDate:     2018/11/22 11:44
* @UpdateRemark:   修改内容
* @Version:        1.0
*/

public class SystemPasswordEncoder implements PasswordEncoder{

    private final static String SALT = "linkage";   //加盐的值

    @Override
    public String encode(CharSequence charSequence) {
        /**
         *用于密码加密
                * @author ACtangle
                * @date 2018/11/22
                * @param [charSequence]
                * @return java.lang.String
                */
        Md5PasswordEncoder encoder = new Md5PasswordEncoder();
        return encoder.encodePassword(charSequence.toString(),SALT);
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        /**
         *密码验证
                * @author ACtangle
                * @date 2018/11/22
                * @param [charSequence, s]
                * @return boolean
                */
        Md5PasswordEncoder encoder = new Md5PasswordEncoder();
        return encoder.isPasswordValid(s,charSequence.toString(),SALT);
    }
}
