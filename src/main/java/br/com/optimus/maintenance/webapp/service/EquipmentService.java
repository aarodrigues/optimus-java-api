package br.com.optimus.maintenance.webapp.service;

import br.com.optimus.maintenance.webapp.dto.EquipmentDTO;
import br.com.optimus.maintenance.webapp.model.Equipment;
import br.com.optimus.maintenance.webapp.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {
    @Autowired
    private EquipmentRepository repository;

    public Equipment save(Equipment equipment) {
        return repository.save(equipment);
    }

    public Optional<Equipment> getById(Integer id){
        return repository.findById(id);
    }

    public List<Equipment> getAll(){
        return repository.findAll();
    }

    public void delete(Equipment equipment) {
        if (equipment == null || equipment.getId() == null) {
            throw new IllegalArgumentException("Equipment can't be null");
        }
        this.repository.delete(equipment);
    }

    public Equipment update(Equipment equipment) {
        if (equipment == null || equipment.getId() == null) {
            throw new IllegalArgumentException("Book id can't be null");
        }
        return repository.save(equipment);
    }

}
