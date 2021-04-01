package br.com.optimus.maintenance.webapp.controller;

import br.com.optimus.maintenance.webapp.dto.EquipmentDTO;
import br.com.optimus.maintenance.webapp.model.Equipment;
import br.com.optimus.maintenance.webapp.repository.EquipmentRepository;
import br.com.optimus.maintenance.webapp.repository.MaintenanceRepository;
import br.com.optimus.maintenance.webapp.repository.MechanicalPieceRepository;
import br.com.optimus.maintenance.webapp.repository.MechanicalRepository;
import br.com.optimus.maintenance.webapp.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/maintenance")
public class MaintenanceController {

//    @Autowired
//    private EquipmentRepository equipamentRepository;
//
//    @Autowired
//    private MechanicalRepository machanicalRepository;
//
//    @Autowired
//    private MaintenanceRepository maintenanceRepository;
//
//    @Autowired
//    private MechanicalPieceRepository mechanicalPieceRepository;

    @Autowired
    private EquipmentService equipmentService;

//    public MaintenanceController() {
//        equipmentService = new EquipmentService();
//    }

//    @GetMapping
//    public String haha() {
//        return "Hello World";
//    }

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public void create(@RequestBody EquipmentDTO equipmentDTO) {
//        Equipment equipment = new Equipment();
//        equipment.setDescription(equipmentDTO.getDescription());
//        equipamentRepository.save(equipment);
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody EquipmentDTO equipmentDTO) {
        Equipment equipment = new Equipment();
        equipment.setDescription(equipmentDTO.getDescription());
        equipmentService.save(equipment);
    }

//    @GetMapping("{id}")
//    public EquipmentDTO get(@PathVariable Integer id) {
//        Optional<Equipment> equipments = equipmentService.getById(id);
//        EquipmentDTO equipmentDTO = new EquipmentDTO();
//        equipmentDTO.setDescription(equipments.get().getDescription());
//        return equipmentDTO;
//    }

    @GetMapping
    public List<EquipmentDTO> getAll() {
        List<Equipment> equipments = equipmentService.getAll();
        List<EquipmentDTO> equipmentDTOList = new ArrayList<EquipmentDTO>();
        for (Equipment eq : equipments) {
            EquipmentDTO dto = new EquipmentDTO();
            dto.setDescription(eq.getDescription());
            equipmentDTOList.add(dto);
        }
        return equipmentDTOList;
    }

    @PutMapping("{id}")
    public EquipmentDTO update(@PathVariable Integer id, @RequestBody EquipmentDTO dto) {
        Equipment equipment = equipmentService.getById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        equipment.setDescription(dto.getDescription());

        equipment = equipmentService.update(equipment);
        EquipmentDTO equipmentDTO = new EquipmentDTO();
        equipmentDTO.setDescription(equipment.getDescription());

        return equipmentDTO;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        Equipment equipment = equipmentService.getById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        equipmentService.delete(equipment);
    }

}
