package br.com.optimus.maintenance.webapp.controller;

import br.com.optimus.maintenance.webapp.dto.MechanicalDTO;
import br.com.optimus.maintenance.webapp.model.Mechanical;
import br.com.optimus.maintenance.webapp.service.MechanicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/optimus/mechanical")
public class MechanicalController {

    @Autowired
    private MechanicalService mechanicalService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody MechanicalDTO mechanicalDTO) {
        Mechanical mechanical = new Mechanical();
        mechanical.setName(mechanicalDTO.getName());
        mechanicalService.save(mechanical);
    }

    @GetMapping("{id}")
    public MechanicalDTO get(@PathVariable Integer id) {
        Optional<Mechanical> mechanics = mechanicalService.getById(id);
        MechanicalDTO mechanicalDTO = new MechanicalDTO();
        mechanicalDTO.setName(mechanics.get().getName());
        return mechanicalDTO;
    }

    @GetMapping
    public List<MechanicalDTO> getAll() {
        List<Mechanical> mechanics = mechanicalService.getAll();
        List<MechanicalDTO> mechanicalDTOList = new ArrayList<MechanicalDTO>();
        for (Mechanical mc : mechanics) {
            MechanicalDTO dto = new MechanicalDTO();
            dto.setName(mc.getName());
            mechanicalDTOList.add(dto);
        }
        return mechanicalDTOList;
    }

    @PutMapping("{id}")
    public MechanicalDTO update(@PathVariable Integer id, @RequestBody MechanicalDTO dto) {
        Mechanical mechanical = mechanicalService.getById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mechanical.setName(dto.getName());

        mechanical = mechanicalService.update(mechanical);
        MechanicalDTO mechanicalDTO = new MechanicalDTO();
        mechanicalDTO.setName(mechanical.getName());

        return mechanicalDTO;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        Mechanical mechanical = mechanicalService.getById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mechanicalService.delete(mechanical);
    }
}
