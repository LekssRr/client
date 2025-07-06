package com.example.client.dto.request;

public class PostClientRequestDto {

    private String firstName;

    private String middelName;

    private String lastName;

    private String vinCodeAuto;

    public PostClientRequestDto(String firstName, String middelName, String lastName, String vinCodeAuto) {
        this.firstName = firstName;
        this.middelName = middelName;
        this.lastName = lastName;
        this.vinCodeAuto = vinCodeAuto;
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

    public String getMiddelName() {
        return middelName;
    }

    public void setMiddelName(String middelName) {
        this.middelName = middelName;
    }

    public String getVinCodeAuto() {
        return vinCodeAuto;
    }

    public void setVinCodeAuto(String vinCodeAuto) {
        this.vinCodeAuto = vinCodeAuto;
    }


}
