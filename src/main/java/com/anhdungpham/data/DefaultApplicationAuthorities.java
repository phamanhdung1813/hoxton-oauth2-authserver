package com.anhdungpham.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DefaultApplicationAuthorities {
    ADMIN_READ("ADMIN:READ"),
    ADMIN_WRITE("ADMIN:WRITE"),
    USER_READ("USER:READ"),
    USER_WRITE("USER:WRITE");

    private final String authority;
}
