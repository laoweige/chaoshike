package test.java.com.zhaopin.advertisement.web.authority;

import org.junit.Test;

import java.net.URLDecoder;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserCookieCheckTest {


    @Test
    public void should_decrypt_cookie() throws Exception {
        String enCryptedCookie = "7406c36d896b189b4a9c3ad2f7c775e182d05d1069442a29075c5ba66361ce13291c46c13d638ffa56fcdd16f81624ec";
        String encrypt = URLDecoder.decode(enCryptedCookie, "UTF-8");
        String decrypt = new EncryptionDecryption().decrypt(encrypt);
        String[] companyIdAndCompanyName = decrypt.split("\0");
        assertThat(companyIdAndCompanyName.length, is(2));
    }
}