package com.anhdungpham.oauth2;

import com.anhdungpham.oauth2.impl.IApplicationClientsDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.anhdungpham.constants.SystemConstant.*;

@Repository("static_client_repository")
public class ApplicationClientsDAO implements IApplicationClientsDAO {

    private List<CustomClientDetails> staticClientInfo() {
        List<CustomClientDetails> clientList = List.of(
                new CustomClientDetails(
                        "client1", null, true, "client1", true,
                        SCOPE, GRANT_TYPE, REGISTERED_REDIRECT_URI, GRANTED_AUTHORITIES,
                        ACCESS_TOKEN_VALIDITY, REFRESH_TOKEN_VALIDITY, true, null
                )
        );
        return clientList;
    }

    @Override
    public Optional<CustomClientDetails> findByClientId(String clientId) {
        return staticClientInfo().stream().filter(client -> clientId.equals(client.getClientId())).findFirst();
    }
}
