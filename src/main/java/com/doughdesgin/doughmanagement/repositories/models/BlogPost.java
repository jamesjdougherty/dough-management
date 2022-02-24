package com.doughdesgin.doughmanagement.repositories.models;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class BlogPost {
    int id;
    String post;
    Timestamp createdDate;
    Timestamp lastModifiedDate;

    public BlogPost(int id, String post, Timestamp createdDate, Timestamp lastModifiedDate) {
        this.id = id;
        this.post = post;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }
}
