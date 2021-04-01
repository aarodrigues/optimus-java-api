package br.com.optimus.maintenance.webapp.service;

import br.com.optimus.maintenance.webapp.model.MechanicalPiece;
import br.com.optimus.maintenance.webapp.repository.MechanicalPieceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MechanicalPieceService {
    @Autowired
    private MechanicalPieceRepository repository;

    public MechanicalPiece save(MechanicalPiece mechanicalPiece) {
        return repository.save(mechanicalPiece);
    }

    public Optional<MechanicalPiece> getById(Integer id){
        return repository.findById(id);
    }

    public List<MechanicalPiece> getAll(){
        return repository.findAll();
    }

    public void delete(MechanicalPiece mechanicalPiece) {
        if (mechanicalPiece == null || mechanicalPiece.getId() == null) {
            throw new IllegalArgumentException("MechanicalPiece can't be null");
        }
        this.repository.delete(mechanicalPiece);
    }

    public MechanicalPiece update(MechanicalPiece mechanicalPiece) {
        if (mechanicalPiece == null || mechanicalPiece.getId() == null) {
            throw new IllegalArgumentException("MechanicalPiece id can't be null");
        }
        return repository.save(mechanicalPiece);
    }
}
