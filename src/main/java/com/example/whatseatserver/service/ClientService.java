package com.example.whatseatserver.service;

import com.example.whatseatserver.model.Client;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


@Service
public class ClientService implements UUIDClientService {

    private static final Map<UUID, Client> CLIENT_UUID_REPOSITORY_MAP = new ConcurrentHashMap<>();
    private static final AtomicInteger CLIENT_ID_HOLDER = new AtomicInteger();

    @Override
    public void create(Client client) {
        final UUID clientId = UUID.randomUUID();
        client.setId(clientId);
        CLIENT_UUID_REPOSITORY_MAP.put(clientId, client);
    }

    @Override
    public List<Client> readAll() {
        return new ArrayList<>(CLIENT_UUID_REPOSITORY_MAP.values());
    }

    @Override
    public Client read(UUID id) {
        return CLIENT_UUID_REPOSITORY_MAP.get(id);
    }

    @Override
    public boolean update(Client client, UUID id) {
        if (CLIENT_UUID_REPOSITORY_MAP.containsKey(id)) {
            client.setId(id);
            CLIENT_UUID_REPOSITORY_MAP.put(id, client);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(UUID id) {
        return CLIENT_UUID_REPOSITORY_MAP.remove(id) != null;
    }
}
