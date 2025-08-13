package com.example.client.dto.request;

public class IsClientRequestDto {
    private String firstName;
    private String lastName;
    private String middleName;

    public IsClientRequestDto(String ferstName, String lastName, String middleName) {
        this.firstName = ferstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getMiddleName(){
        return middleName;
    }
}
