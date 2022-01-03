package com.anhdungpham.utils;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

public class CustomTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken,
                                     OAuth2Authentication oAuth2Authentication) {
        var defaultOAuth2AccessToken = new DefaultOAuth2AccessToken(oAuth2AccessToken);

        Map<String, Object> zoneEnhance = new HashMap<>();
        zoneEnhance.put("project_zone", ZoneId.of("America/Toronto").toString());
        zoneEnhance.put("author", "Anh Dung Pham");

        defaultOAuth2AccessToken.setAdditionalInformation(zoneEnhance);
        return defaultOAuth2AccessToken;
    }
}
