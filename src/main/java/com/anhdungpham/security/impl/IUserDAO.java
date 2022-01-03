package com.anhdungpham.security.impl;

import com.anhdungpham.security.CustomUserDetails;

import java.util.Optional;

public interface IUserDAO {
    Optional<CustomUserDetails> findByUsername(String username);
}
