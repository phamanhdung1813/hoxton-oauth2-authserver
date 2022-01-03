package com.anhdungpham.oauth2;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

@RequiredArgsConstructor
public class CustomClientDetails implements ClientDetails {
    private final String clientId;
    private final Set<String> resourcesIds;
    private final boolean isSecretRequired;
    private final String clientSecret;
    private final boolean isScoped;
    private final Set<String> scope;
    private final Set<String> authorizedGrantTypes;
    private final Set<String> registeredRedirectUri;
    private final Collection<GrantedAuthority> authorities;
    private final Integer accessTokenValiditySeconds;
    private final Integer refreshTokenValiditySeconds;
    private final boolean isAutoApprove;
    private final Map<String, Object> additionalInformation;

    @Override
    public String getClientId() {
        return clientId;
    }

    @Override
    public Set<String> getResourceIds() {
        return resourcesIds;
    }

    @Override
    public boolean isSecretRequired() {
        return isSecretRequired;
    }

    @Override
    public String getClientSecret() {
        return clientSecret;
    }

    @Override
    public boolean isScoped() {
        return isScoped;
    }

    @Override
    public Set<String> getScope() {
        return scope;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return registeredRedirectUri;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return accessTokenValiditySeconds;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return refreshTokenValiditySeconds;
    }

    @Override
    public boolean isAutoApprove(String s) {
        return isAutoApprove;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return additionalInformation;
    }
}
