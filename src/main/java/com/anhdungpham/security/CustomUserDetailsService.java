package com.anhdungpham.security;

import com.anhdungpham.security.impl.IUserDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final IUserDAO iUserDAO;

    public CustomUserDetailsService(@Qualifier("static_user_repository") IUserDAO iUserDAO) {
        this.iUserDAO = iUserDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return iUserDAO.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("NOT FOUND USERNAME %s ", username)));
    }
}
