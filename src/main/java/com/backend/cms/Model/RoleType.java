package com.backend.cms.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Type")
public class RoleType {

    @Id
    private String id;
    private String TypeName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String typeName) {
        TypeName = typeName;
    }

}
