package com.anhdungpham.oauth2.impl;

import com.anhdungpham.oauth2.CustomClientDetails;

import java.util.Optional;

public interface IApplicationClientsDAO {
    Optional<CustomClientDetails> findByClientId(String clientId);
}
