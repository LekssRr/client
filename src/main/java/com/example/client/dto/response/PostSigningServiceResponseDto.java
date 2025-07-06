package com.example.client.dto.response;

import java.util.Date;

public class PostSigningServiceResponseDto {

    private boolean is;

    private Date date;

    public PostSigningServiceResponseDto(boolean is, Date date) {
        this.is = is;
        this.date = date;
    }
    public boolean isIs() {
        return is;
    }

    public void setIs(boolean is) {
        this.is = is;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
