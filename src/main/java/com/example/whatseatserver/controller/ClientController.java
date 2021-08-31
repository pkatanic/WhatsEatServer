package com.example.whatseatserver.controller;

import com.example.whatseatserver.model.Client;
import com.example.whatseatserver.service.UUIDClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ClientController {
    private final UUIDClientService clientService;

    @Autowired
    public ClientController(UUIDClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * Регистрация клиента. ПО слердством POST запроса с передачей в JSON полей:
     * name,login,password.
     * @param client
     * @return
     */
    @PostMapping(value = "/registration")
    public ResponseEntity<?> create(@RequestBody Client client) {
        clientService.create(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/clients")
    public ResponseEntity<List<Client>> read() {
        final List<Client> clients = clientService.readAll();

        return clients != null &&  !clients.isEmpty()
                ? new ResponseEntity<>(clients, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Поиск клиента по UUID идентификатору
     * @param id
     * @return
     */
    @GetMapping(value = "/client/{id}")
    public ResponseEntity<Client> read(@PathVariable(name = "id") UUID id) {
        final Client client = clientService.read(id);

        return client != null
                ? new ResponseEntity<>(client, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     *Обновление клиентов по UUID идентификатору
     * @param id
     * @param client
     * @return
     */
    @PutMapping(value = "/updateclient/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") UUID id, @RequestBody Client client) {
        final boolean updated = clientService.update(client, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Удаление клиента по UUID идентификатору.
     * @param id
     * @return
     */
    @DeleteMapping(value = "/deleteclients/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") UUID id) {
        final boolean deleted = clientService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
