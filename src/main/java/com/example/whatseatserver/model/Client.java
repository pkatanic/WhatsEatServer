package com.example.whatseatserver.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Client {
    private UUID id;
    private String name;
    private String login;
    private String password;
}
