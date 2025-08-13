package com.example.client.model;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.EntityGraph;

import java.util.List;

@Entity
@NamedEntityGraph(
        name = "signingServiceList",
        attributeNodes = @NamedAttributeNode("signingServiceList")
)
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String middleName;

    private String lastName;

    private String vinCodeAuto;

    @OneToMany(mappedBy = "client")
    private List<SigningService> signingServiceList;

    public List<SigningService> getSigningServiceList() {
        return signingServiceList;
    }
    public Client() {
    }

    public Client( String firstName, String middelName, String lastName, String vinCodeAuto, List<SigningService> signingServiceList) {
        this.firstName = firstName;
        this.middleName = middelName;
        this.lastName = lastName;
        this.vinCodeAuto = vinCodeAuto;
        this.signingServiceList = signingServiceList;
    }
    public void setSigningServiceList(List<SigningService> signingServiceList) {
        this.signingServiceList = signingServiceList;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middelName) {
        this.middleName = middelName;
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


}
