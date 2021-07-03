package com.backend.cms.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Workshops")
public class Workshop {

        @Id
        private String _id;
        private String userId;
        private String workshopTitle;
        private String date;
        private String time;
        private int mobileNo;
        private String email;
        private String proposal;
        private String fileLink;
        private String status;

    public Workshop(String _id, String userId, String workshopTitle, String date, String time, int mobileNo, String email, String proposal,
                    String fileLink, String status) {
        super();
        this._id = _id;
        this.userId = userId;
        this.workshopTitle = workshopTitle;
        this.date = date;
        this.time = time;
        this.mobileNo = mobileNo;
        this.email = email;
        this.proposal = proposal;
        this.fileLink = fileLink;
        this.status = status;
    }
    public Workshop() {
        super();
    }

    public String get_id() { return _id; }

    public void set_id(String _id) { this._id = _id; }

    public String getUserId() { return userId; }

    public void setUserId(String userid) { this.userId = userid; }

    public String getWorkshopTitle() { return workshopTitle; }

    public void setWorkshopTitle(String workshopTitle) { this.workshopTitle = workshopTitle; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public String getTime() { return time; }

    public void setTime(String time) { this.time = time; }

    public int getMobileNo() { return mobileNo; }

    public void setMobileNo(int mobileNo) { this.mobileNo = mobileNo; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getProposal() { return proposal; }

    public void setProposal(String proposal) { this.proposal = proposal; }

    public String getFileLink() { return fileLink; }

    public void setFileLink(String fileLink) { this.fileLink = fileLink; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Workshop [_id=" + _id + ", userId=" + userId + ", workshopTitle=" + workshopTitle + ", date=" + date + ",time=" + time + ", mobileNo="
                + mobileNo + ", email=" + email + ", proposal=" + proposal + ", fileLink=" + fileLink + ", status="
                + status + "]";
    }
}