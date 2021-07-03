package com.backend.cms.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Payment")

public class Payment {
    @Id
    private String Id;
    private String username;
    private String nameOnTheCard;
    private String cardNumber;
    private String cvc;
    private String exDate;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getExDate() {
        return exDate;
    }

    public void setExDate(String exDate) {
        this.exDate = exDate;
    }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getNameOnTheCard() { return nameOnTheCard; }

    public void setNameOnTheCard(String nameOnTheCard) { this.nameOnTheCard = nameOnTheCard; }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }
}
