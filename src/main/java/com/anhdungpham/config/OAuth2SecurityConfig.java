package com.anhdungpham.config;

import com.anhdungpham.oauth2.CustomClientDetailsService;
import com.anhdungpham.security.CustomUserDetailsService;
import com.anhdungpham.utils.CustomTokenEnhancer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.util.List;

@Configuration
@EnableAuthorizationServer
@RequiredArgsConstructor
public class OAuth2SecurityConfig extends AuthorizationServerConfigurerAdapter {
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService customUserDetailsService;
    private final CustomClientDetailsService customClientDetailsService;

    @Value("${password}")
    private String password;

    @Value("${alias}")
    private String alias;

    @Value("${privateKey}")
    private String privateKey;

    @Value("${secretKey}")
    private String secretKey;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("isAuthenticated()")
                .checkTokenAccess("isAuthenticated()")
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(customClientDetailsService);
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();

        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(
                new ClassPathResource(privateKey), password.toCharArray()
        );
        jwtAccessTokenConverter.setKeyPair(keyStoreKeyFactory.getKeyPair(alias));
//        jwtAccessTokenConverter.setSigningKey(secretKey);
        return jwtAccessTokenConverter;
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        List<TokenEnhancer> tokenEnhancer = List.of(new CustomTokenEnhancer(), jwtAccessTokenConverter());
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();

        tokenEnhancerChain.setTokenEnhancers(tokenEnhancer);

        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(customUserDetailsService)
                .tokenEnhancer(tokenEnhancerChain)
                .tokenStore(tokenStore())
                .accessTokenConverter(jwtAccessTokenConverter());
    }
}
