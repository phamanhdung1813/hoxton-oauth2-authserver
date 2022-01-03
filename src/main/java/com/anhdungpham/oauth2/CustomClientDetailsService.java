package com.anhdungpham.oauth2;

import com.anhdungpham.oauth2.impl.IApplicationClientsDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

@Service
public class CustomClientDetailsService implements ClientDetailsService {
    private final IApplicationClientsDAO iApplicationClientsDAO;

    public CustomClientDetailsService(@Qualifier("static_client_repository")
                                              IApplicationClientsDAO iApplicationClientsDAO) {
        this.iApplicationClientsDAO = iApplicationClientsDAO;
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        return iApplicationClientsDAO.findByClientId(clientId)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("NOT FOUND %s id ", clientId)));
    }
}
