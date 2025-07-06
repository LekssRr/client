package com.example.client.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class SigningService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String vinCodeAuto;
    @Column(name = "reason_description")
    private String reasonDiscription;

    private Date dateSigningService;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private boolean isActive;

    public SigningService(Client client, String reasonDiscription, Date dateSigningService, String vinCodeAuto, boolean isActive) {
        this.client = client;
        this.reasonDiscription = reasonDiscription;
        this.dateSigningService = dateSigningService;
        this.vinCodeAuto = vinCodeAuto;
        this.isActive = isActive;
    }

    public SigningService() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDateSigningService() {
        return dateSigningService;
    }

    public void setDateSigningService(Date dateSigningService) {
        this.dateSigningService = dateSigningService;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
