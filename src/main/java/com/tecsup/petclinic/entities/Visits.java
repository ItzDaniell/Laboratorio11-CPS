package com.tecsup.petclinic.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity(name = "visits")
@Data
public class Visits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "pet_id")
    private int petId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "visitDate")
    private Date visitDate;

    private String description;

    public Visits() {
    }

    public Visits(int id, int petId, Date visitDate, String description) {
        this.id = id;
        this.petId = petId;
        this.visitDate = visitDate;
        this.description = description;
    }

    public Visits(int petId, Date visitDate, String description) {
        this.petId = petId;
        this.visitDate = visitDate;
        this.description = description;
    }
}
