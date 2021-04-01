package br.com.optimus.maintenance.webapp.repository;

import br.com.optimus.maintenance.webapp.model.Equipment;
import br.com.optimus.maintenance.webapp.model.Mechanical;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MechanicalRepository extends JpaRepository<Mechanical, Integer> {
}
