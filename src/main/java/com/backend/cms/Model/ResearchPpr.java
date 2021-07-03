package com.backend.cms.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "researchPpr")
public class ResearchPpr {

    @Id
    public String id;
    public String name;
    public String email;
    public String contact_no;
    public String title;
    public String pdf;
    public String status;

//    public ResearchPpr(String id,String name, String email,String contact_no, String title,
//                    String pdf, String status) {
//        super();
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.contact_no = contact_no;
//        this.title = title;
//        this.pdf = pdf;
//        this.status = status;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    @Override
//    public String toString() {
//        return "ResearchPaperID" + id + ", name=" + name + ", email=" + email + ",contact_no=" + contact_no +
//                ", title=" + title + ", pdf=" + pdf + ", status=" + status + "]";
//    }
}
