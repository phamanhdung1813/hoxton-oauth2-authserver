package com.anhdungpham.constants;

import org.springframework.security.core.GrantedAuthority;

import java.util.*;


public class SystemConstant {

    public static final Set<String> REGISTERED_REDIRECT_URI = Set.of("https://oidcdebugger.com/debug");

    public static final Integer ACCESS_TOKEN_VALIDITY = 3600;

    public static final Integer REFRESH_TOKEN_VALIDITY = 5400;

    public static final Set<String> SCOPE = Set.of("openid", "read", "write");

    public static final Set<String> GRANT_TYPE = Set.of("authorization_code", "refresh_token",
            "password", "client_credentials");

    public static final Collection<GrantedAuthority> GRANTED_AUTHORITIES = Set.of(SCOPE::toString);

}
