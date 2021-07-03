package com.backend.cms.Model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sample")
public class sampleMod {

    public String id;
    public String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
