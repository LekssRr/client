package com.example.client.dto.request;


public class GetClientRequestDto {

    private int clientId;

    private String firstName;

    private String middelName;

    private String lastName;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getMiddelName() {
        return middelName;
    }

    public void setMiddelName(String middelName) {
        this.middelName = middelName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public GetClientRequestDto(int clientId, String firstName, String middelName, String lastName) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.middelName = middelName;
        this.lastName = lastName;
    }
}
