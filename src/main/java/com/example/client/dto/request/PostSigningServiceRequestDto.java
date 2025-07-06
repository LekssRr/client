package com.example.client.dto.request;

import java.util.Date;

public class PostSigningServiceRequestDto {
    private int clientId;
    private String vinCodeAuto;
    private String reasonDiscription;
    private Date date;

    public String getVinCodeAuto() {
        return vinCodeAuto;
    }

    public void setVinCodeAuto(String vinCodeAuto) {
        this.vinCodeAuto = vinCodeAuto;
    }

    public String getReasonDiscription() {
        return reasonDiscription;
    }

    public void setReasonDiscription(String reasonDiscription) {
        this.reasonDiscription = reasonDiscription;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public PostSigningServiceRequestDto(int clientId, String vinCodeAuto, String reasonDiscription, Date date) {
        this.clientId = clientId;
        this.vinCodeAuto = vinCodeAuto;
        this.reasonDiscription = reasonDiscription;
        this.date = date;
    }
}
