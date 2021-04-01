package br.com.optimus.maintenance.webapp.repository;

import br.com.optimus.maintenance.webapp.model.Equipment;
import br.com.optimus.maintenance.webapp.model.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Integer> {
}
