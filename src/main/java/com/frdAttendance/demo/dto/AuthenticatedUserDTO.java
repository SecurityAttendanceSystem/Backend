package com.frdAttendance.demo.dto;

import com.frdAttendance.demo.model.InternalUsers;

import java.util.Map;

public class AuthenticatedUserDTO {
    private Map<String, Object> tokenClaims;
    private InternalUsers localUser;

    // Constructors
    public AuthenticatedUserDTO(Map<String, Object> tokenClaims, InternalUsers localUser) {
        this.tokenClaims = tokenClaims;
        this.localUser = localUser;
    }

    // Getters and Setters
    public Map<String, Object> getTokenClaims() {
        return tokenClaims;
    }

    public void setTokenClaims(Map<String, Object> tokenClaims) {
        this.tokenClaims = tokenClaims;
    }

    public InternalUsers getLocalUser() {
        return localUser;
    }

    public void setLocalUser(InternalUsers localUser) {
        this.localUser = localUser;
    }
}

