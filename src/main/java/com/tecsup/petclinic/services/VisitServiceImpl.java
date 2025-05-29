package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.entities.Visit;
import com.tecsup.petclinic.exception.PetNotFoundException;
import com.tecsup.petclinic.exception.VisitNotFoundException;
import com.tecsup.petclinic.repositories.VisitRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class VisitServiceImpl implements VisitService {

    VisitRepository visitRepository;

    public VisitServiceImpl(VisitRepository visitRepository) { this.visitRepository = visitRepository; }

    @Override
    public Visit create(Visit visit) {
        return visitRepository.save(visit);
    }

    @Override
    public Visit update(Visit visit) {
        return visitRepository.save(visit);
    }

    @Override
    public void delete(Integer id) throws VisitNotFoundException {
        Visit visit = findById(id);
        visitRepository.delete(visit);
    }

    @Override
    public Visit findById(Integer id) throws VisitNotFoundException {
        Optional<Visit> visit = visitRepository.findById(id);
        if ( !visit.isPresent())
            throw new VisitNotFoundException("Record not found...!");

        return visit.get();
    }

    @Override
    public List<Visit> findByDate(Date date) throws VisitNotFoundException {

        List<Visit> visits = visitRepository.findByDate(date);

        visits.stream().forEach(visit -> log.info("" + visit));

        return visits;
    }
}
