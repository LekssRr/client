package com.example.client.dto.response;

import java.util.Date;

public class GetSigningServiceResponseDto {

    private String reasonDiscription;

    private Date dateSigningService;

    public String getReasonDiscription() {
        return reasonDiscription;
    }

    public void setReasonDiscription(String reasonDiscription) {
        this.reasonDiscription = reasonDiscription;
    }

    public Date getDateSigningService() {
        return dateSigningService;
    }

    public void setDateSigningService(Date dateSigningService) {
        this.dateSigningService = dateSigningService;
    }

    public GetSigningServiceResponseDto(String reasonDiscription, Date dateSigningService) {
        this.reasonDiscription = reasonDiscription;
        this.dateSigningService = dateSigningService;
    }
}
