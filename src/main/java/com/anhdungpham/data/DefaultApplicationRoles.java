package com.anhdungpham.data;

import com.google.common.collect.Sets;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.anhdungpham.data.DefaultApplicationAuthorities.*;

@RequiredArgsConstructor
@Getter
public enum DefaultApplicationRoles {

    ROLE_ADMIN(Sets.newHashSet(ADMIN_READ, ADMIN_WRITE, USER_READ, USER_WRITE)),
    ROLE_MANAGER(Sets.newHashSet(ADMIN_READ, USER_READ)),
    ROLE_USER(Sets.newHashSet(USER_READ));

    private final Set<DefaultApplicationAuthorities> roles;

    public Set<SimpleGrantedAuthority> grantedAuthorities() {
        Set<SimpleGrantedAuthority> grantedAuthorities = roles.stream()
                .map(i -> new SimpleGrantedAuthority(i.getAuthority()))
                .collect(Collectors.toSet());
        grantedAuthorities.add(new SimpleGrantedAuthority(this.name()));
        return grantedAuthorities;
    }
}
