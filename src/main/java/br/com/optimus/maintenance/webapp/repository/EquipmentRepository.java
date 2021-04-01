package br.com.optimus.maintenance.webapp.repository;

import br.com.optimus.maintenance.webapp.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository <Equipment, Integer> {
    Equipment findAllByDescription(String description);
}
