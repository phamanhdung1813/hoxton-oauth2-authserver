package com.anhdungpham.security;

import com.anhdungpham.security.impl.IUserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.anhdungpham.data.DefaultApplicationRoles.*;

@Repository("static_user_repository")
@RequiredArgsConstructor
public class UserDAO implements IUserDAO {
    private final PasswordEncoder passwordEncoder;

    private List<CustomUserDetails> staticUserData() {
        List<CustomUserDetails> customUserDetailsList = List.of(
                new CustomUserDetails("admin", passwordEncoder.encode("admin"),
                        ROLE_ADMIN.grantedAuthorities(), true, true,
                        true, true),

                new CustomUserDetails("manager", passwordEncoder.encode("manager"),
                        ROLE_MANAGER.grantedAuthorities(), true, true,
                        true, true),

                new CustomUserDetails("user", passwordEncoder.encode("user"),
                        ROLE_USER.grantedAuthorities(), true, true,
                        true, true)
        );
        return customUserDetailsList;
    }


    @Override
    public Optional<CustomUserDetails> findByUsername(String username) {
        return staticUserData().stream()
                .filter(user -> username.equals(user.getUsername())).findFirst();
    }
}
