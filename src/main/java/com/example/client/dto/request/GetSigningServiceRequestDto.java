package com.example.client.dto.request;

import java.util.Date;

public class GetSigningServiceRequestDto {

    private int clientId;

    private boolean isActive;

    public GetSigningServiceRequestDto(int clientId, String description, Date date, boolean isActive) {
        this.clientId = clientId;
        this.isActive = isActive;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

}
