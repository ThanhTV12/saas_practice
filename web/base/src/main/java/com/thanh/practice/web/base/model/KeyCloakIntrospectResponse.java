package com.thanh.practice.web.base.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class KeyCloakIntrospectResponse {
    @SerializedName("name")
    private String name;
    @SerializedName("given_name")
    private String givenGame;
    @SerializedName("family_name")
    private String familyName;
    @SerializedName("preferred_username")
    private String preferredUsername;
    @SerializedName("email")
    private String email;
    @SerializedName("email_verified")
    private Boolean emailVerified;
    @SerializedName("scope")
    private String scope;
    @SerializedName("username")
    private String username;
    @SerializedName("active")
    private Boolean active;
    @SerializedName("realm_access")
    private KeyCloakRealmAccess realmAccess;
}
