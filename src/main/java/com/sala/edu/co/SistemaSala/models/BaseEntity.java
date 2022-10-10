package com.sala.edu.co.SistemaSala.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {
    @Column(columnDefinition = "DATETIME", updatable = false, nullable = false)
    protected Date createdDate;

    @Column(columnDefinition = "DATETIME", updatable = false, nullable = false)
    protected Date updatedDate;

    @PrePersist
    protected void onCreate() {
        updatedDate = new Date();
        if (createdDate == null) {
            createdDate = new Date();
        }
    }
}
