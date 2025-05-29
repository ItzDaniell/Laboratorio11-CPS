package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Visit;
import com.tecsup.petclinic.exception.VisitNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class VisitSearchTest {

    @Autowired
    VisitService visitService;

    @Test
    public void testFindById() throws VisitNotFoundException {
        Visit visit = visitService.findById(1);
        Assertions.assertNotNull(visit);
        System.out.println("Visit Found" + visit);
    }

    @Test
    public void testFindByDate() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2010-03-04");

        List<Visit> visits = visitService.findByDate(date);
        Assertions.assertFalse(visits.isEmpty(), "Debe encontrar visitas en la fecha " + date);

        visits.forEach(visit -> System.out.println("Visit: " + visit));
    }
}