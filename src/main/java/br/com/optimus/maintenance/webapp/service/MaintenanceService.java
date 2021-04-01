package br.com.optimus.maintenance.webapp.service;

import br.com.optimus.maintenance.webapp.model.Maintenance;
import br.com.optimus.maintenance.webapp.repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceService {
    @Autowired
    private MaintenanceRepository repository;

    public Maintenance save(Maintenance maintenance) {
        return repository.save(maintenance);
    }

    public Optional<Maintenance> getById(Integer id){
        return repository.findById(id);
    }

    public List<Maintenance> getAll(){
        return repository.findAll();
    }

    public void delete(Maintenance equipment) {
        if (equipment == null || equipment.getId() == null) {
            throw new IllegalArgumentException("Maintenance can't be null");
        }
        this.repository.delete(equipment);
    }

    public Maintenance update(Maintenance maintenance) {
        if (maintenance == null || maintenance.getId() == null) {
            throw new IllegalArgumentException("Maintenance id can't be null");
        }
        return repository.save(maintenance);
    }
}
