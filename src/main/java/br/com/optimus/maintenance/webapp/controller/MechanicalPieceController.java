package br.com.optimus.maintenance.webapp.controller;

import br.com.optimus.maintenance.webapp.dto.MechanicalPieceDTO;
import br.com.optimus.maintenance.webapp.model.Equipment;
import br.com.optimus.maintenance.webapp.model.MechanicalPiece;
import br.com.optimus.maintenance.webapp.service.EquipmentService;
import br.com.optimus.maintenance.webapp.service.MechanicalPieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/optimus/piece")
public class MechanicalPieceController {

    @Autowired
    private MechanicalPieceService mechanicalPieceService;

    @Autowired
    private EquipmentService equipmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody MechanicalPieceDTO mechanicalPieceDTO) {
        MechanicalPiece mechanicalPiece = new MechanicalPiece();
        Equipment equipment = equipmentService.getById(mechanicalPieceDTO.getEquipmentId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mechanicalPiece.setName(mechanicalPieceDTO.getName());
        mechanicalPiece.setEquipment(equipment);
        mechanicalPieceService.save(mechanicalPiece);
    }

    @GetMapping("{id}")
    public MechanicalPieceDTO get(@PathVariable Integer id) {
        Optional<MechanicalPiece> mechanicalPiece = mechanicalPieceService.getById(id);
        MechanicalPieceDTO mechanicalPieceDTO = new MechanicalPieceDTO();
        mechanicalPieceDTO.setName(mechanicalPiece.get().getName());
        mechanicalPieceDTO.setEquipmentId(mechanicalPiece.get().getEquipment().getId());
        return mechanicalPieceDTO;
    }

    @GetMapping
    public List<MechanicalPieceDTO> getAll() {
        List<MechanicalPiece> mechanicalPieces = mechanicalPieceService.getAll();
        List<MechanicalPieceDTO> mechanicalPieceDTOList = new ArrayList<MechanicalPieceDTO>();
        for (MechanicalPiece mc : mechanicalPieces) {
            MechanicalPieceDTO dto = new MechanicalPieceDTO();
            dto.setName(mc.getName());
            dto.setEquipmentId(mc.getEquipment().getId());
            mechanicalPieceDTOList.add(dto);
        }
        return mechanicalPieceDTOList;
    }

    @PutMapping("{id}")
    public MechanicalPieceDTO update(@PathVariable Integer id, @RequestBody MechanicalPieceDTO dto) {
        MechanicalPiece mechanicalPiece = mechanicalPieceService.getById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mechanicalPiece.setName(dto.getName());

        mechanicalPiece = mechanicalPieceService.update(mechanicalPiece);
        MechanicalPieceDTO mechanicalPieceDTO = new MechanicalPieceDTO();
        mechanicalPieceDTO.setName(mechanicalPiece.getName());
        mechanicalPieceDTO.setEquipmentId(mechanicalPiece.getEquipment().getId());

        return mechanicalPieceDTO;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        MechanicalPiece mechanicalPiece = mechanicalPieceService.getById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mechanicalPieceService.delete(mechanicalPiece);
    }
}
