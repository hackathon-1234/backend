package com.hackathon2.auth.data;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserInfo {
    private Integer id;
    private String username;
    private boolean isAdmin;
    private String email;

    //TODO: Остальные поля

    public UserInfo(Integer id, String username, boolean isAdmin, String email) {
        this.id = id;
        this.username = username;
        this.isAdmin = isAdmin;
        this.email = email;
    }
}
