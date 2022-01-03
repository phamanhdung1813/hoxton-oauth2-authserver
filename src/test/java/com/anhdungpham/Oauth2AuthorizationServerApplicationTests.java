package com.anhdungpham;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.SecureRandom;
import java.util.Base64;

@SpringBootTest
class Oauth2AuthorizationServerApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void secretKey() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] code = new byte[64];
        secureRandom.nextBytes(code);
        String secretKey = Base64.getUrlEncoder().withoutPadding().encodeToString(code);
        System.out.println(secretKey);
    }
}
