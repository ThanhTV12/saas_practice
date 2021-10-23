package com.thanh.practice.web.base.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class KeyCloakRealmAccess {
    @SerializedName("roles")
    private List<String> roles;

    public List<String> getRoles() {
        return roles;
    }
}
