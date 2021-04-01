package br.com.optimus.maintenance.webapp.service;

import br.com.optimus.maintenance.webapp.model.Mechanical;
import br.com.optimus.maintenance.webapp.repository.MechanicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MechanicalService {
    @Autowired
    private MechanicalRepository repository;

    public Mechanical save(Mechanical mechanical) {
        return repository.save(mechanical);
    }

    public Optional<Mechanical> getById(Integer id){
        return repository.findById(id);
    }

    public List<Mechanical> getAll(){
        return repository.findAll();
    }

    public void delete(Mechanical mechanical) {
        if (mechanical == null || mechanical.getId() == null) {
            throw new IllegalArgumentException("Mechanical can't be null");
        }
        this.repository.delete(mechanical);
    }

    public Mechanical update(Mechanical mechanical) {
        if (mechanical == null || mechanical.getId() == null) {
            throw new IllegalArgumentException("Mechanical id can't be null");
        }
        return repository.save(mechanical);
    }
}
