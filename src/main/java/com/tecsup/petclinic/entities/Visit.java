package com.tecsup.petclinic.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity(name = "visit")
@Data
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "pet_id")
    private int petId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "visitDate")
    private Date visitDate;

    private String description;

    public Visit() {
    }

    public Visit(int id, int petId, Date visitDate, String description) {
        this.id = id;
        this.petId = petId;
        this.visitDate = visitDate;
        this.description = description;
    }

    public Visit(int petId, Date visitDate, String description) {
        this.petId = petId;
        this.visitDate = visitDate;
        this.description = description;
    }
}
