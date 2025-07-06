package com.example.client.dto.response;

import com.example.client.model.SigningService;

import java.util.List;

public class GetClientResponseDto {
    private String firstName;

    private String middelName;

    private String lastName;

    private String vinCodeAuto;
    private List<SigningService> signingServiceList;

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

    public String getVinCodeAuto() {
        return vinCodeAuto;
    }

    public void setVinCodeAuto(String vinCodeAuto) {
        this.vinCodeAuto = vinCodeAuto;
    }

    public List<SigningService> getSigningServiceList() {
        return signingServiceList;
    }

    public void setSigningServiceList(List<SigningService> signingServiceList) {
        this.signingServiceList = signingServiceList;
    }

    public GetClientResponseDto(String firstName, String middelName, String lastName, String vinCodeAuto, List<SigningService> signingServiceList) {
        this.firstName = firstName;
        this.middelName = middelName;
        this.lastName = lastName;
        this.vinCodeAuto = vinCodeAuto;
        this.signingServiceList = signingServiceList;
    }


}
