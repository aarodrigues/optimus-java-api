package br.com.optimus.maintenance.webapp.repository;

import br.com.optimus.maintenance.webapp.model.Equipment;
import br.com.optimus.maintenance.webapp.model.MechanicalPiece;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MechanicalPieceRepository extends JpaRepository<MechanicalPiece, Integer> {
}
