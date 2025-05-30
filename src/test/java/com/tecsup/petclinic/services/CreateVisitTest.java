package com.tecsup.petclinic.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate; // Importación correcta
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.tecsup.petclinic.entities.Visit;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class CreateVisitTest {

    @Autowired
    private VisitService visitService;

    @Test
    public void testCreateVisit() {
        // Datos de prueba
        int petId = 1;
        LocalDate visitDate = LocalDate.now(); // Usando LocalDate
        String description = "nueva visita.";

        Visit newVisit = new Visit(petId, visitDate, description);

        // Crear la visita usando el servicio
        Visit createdVisit = visitService.create(newVisit);

        // Verificar
        assertNotNull(createdVisit.getId(), "no es nulo si se creo.");
        assertEquals(petId, createdVisit.getPetId(), "El ID de la mascota");
        // Compararaciones
        assertEquals(visitDate, createdVisit.getDate(), "La fecha de la visita debe coincidir."); // Comparando LocalDate
        assertEquals(description, createdVisit.getDescription(), "La descripción de la visita debe coincidir.");
        log.info("Visita creada exitosamente: {}", createdVisit);
    }
}