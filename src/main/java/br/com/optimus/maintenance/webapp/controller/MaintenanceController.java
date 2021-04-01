package br.com.optimus.maintenance.webapp.controller;

import br.com.optimus.maintenance.webapp.dto.EquipmentDTO;
import br.com.optimus.maintenance.webapp.dto.MaintenanceDTO;
import br.com.optimus.maintenance.webapp.model.Equipment;
import br.com.optimus.maintenance.webapp.model.Maintenance;
import br.com.optimus.maintenance.webapp.model.Mechanical;
import br.com.optimus.maintenance.webapp.service.EquipmentService;
import br.com.optimus.maintenance.webapp.service.MaintenanceService;
import br.com.optimus.maintenance.webapp.service.MechanicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/optimus/maintenance")
public class MaintenanceController {

    @Autowired
    private MaintenanceService maintenanceService;

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private MechanicalService mechanicalService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody MaintenanceDTO maintenanceDTO) {
        Maintenance maintenance = new Maintenance();
        Equipment equipment = equipmentService.getById(maintenanceDTO.getEquipmentId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Mechanical mechanical = mechanicalService.getById(maintenanceDTO.getMechanicalId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        maintenance.setEquipment(equipment);
        maintenance.setMechanical(mechanical);
        maintenance.setWorkHours(maintenanceDTO.getWorkHours());

        maintenanceService.save(maintenance);
    }

    @GetMapping("{id}")
    public MaintenanceDTO get(@PathVariable Integer id) {
        Optional<Maintenance> maintenance = maintenanceService.getById(id);
        MaintenanceDTO maintenanceDTO = new MaintenanceDTO();
        maintenanceDTO.setEquipmentId(maintenance.get().getEquipment().getId());
        maintenanceDTO.setMechanicalId(maintenance.get().getMechanical().getId());
        maintenanceDTO.setWorkHours(maintenance.get().getWorkHours());
        return maintenanceDTO;
    }

    @GetMapping
    public List<MaintenanceDTO> getAll() {
        List<Maintenance> maintenances = maintenanceService.getAll();
        List<MaintenanceDTO> maintenanceDTOList = new ArrayList<MaintenanceDTO>();
        for (Maintenance mt : maintenances) {
            MaintenanceDTO dto = new MaintenanceDTO();
            dto.setEquipmentId(mt.getEquipment().getId());
            dto.setMechanicalId(mt.getMechanical().getId());
            dto.setWorkHours(mt.getWorkHours());
            maintenanceDTOList.add(dto);
        }
        return maintenanceDTOList;
    }

    @PutMapping("{id}")
    public MaintenanceDTO update(@PathVariable Integer id, @RequestBody MaintenanceDTO dto) {
        Maintenance maintenance = maintenanceService.getById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Equipment equipment = equipmentService.getById(dto.getEquipmentId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Mechanical mechanical = mechanicalService.getById(dto.getMechanicalId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        maintenance.setEquipment(equipment);
        maintenance.setMechanical(mechanical);
        maintenance.setWorkHours(dto.getWorkHours());

        maintenance = maintenanceService.update(maintenance);
        MaintenanceDTO maintenanceDTO = new MaintenanceDTO();

        maintenanceDTO.setEquipmentId(maintenance.getEquipment().getId());
        maintenanceDTO.setMechanicalId(maintenance.getMechanical().getId());
        maintenanceDTO.setWorkHours(maintenance.getWorkHours());

        return maintenanceDTO;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        Maintenance maintenance = maintenanceService.getById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        maintenanceService.delete(maintenance);
    }
}
