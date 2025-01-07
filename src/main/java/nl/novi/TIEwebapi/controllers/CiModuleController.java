package nl.novi.TIEwebapi.controllers;

import nl.novi.TIEwebapi.dtos.CiModuleDto;
import nl.novi.TIEwebapi.dtos.CiModuleInputDto;
import nl.novi.TIEwebapi.dtos.RemoteControlDto;
import nl.novi.TIEwebapi.dtos.RemoteControlInputDto;
import nl.novi.TIEwebapi.mappers.CiModuleMapper;
import nl.novi.TIEwebapi.mappers.RemoteControlMapper;
import nl.novi.TIEwebapi.models.CiModule;
import nl.novi.TIEwebapi.models.RemoteControl;
import nl.novi.TIEwebapi.services.CiModuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cimodule")

public class CiModuleController {

    private final CiModuleService ciModuleService;

    public CiModuleController(CiModuleService ciModuleService) {
        this.ciModuleService = ciModuleService;
    }

    @GetMapping
    public ResponseEntity <List<CiModuleDto>> getAllCiModules() {

        List<CiModule> ciModules = ciModuleService.findAll();

        List<CiModuleDto> ciModuleDtos= ciModules.stream()
                .map(CiModuleMapper::toCiModuleDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(ciModuleDtos);

    };

    @GetMapping("/{id}")
    public ResponseEntity <CiModuleDto> getCiModule(@PathVariable("id") Long id)  {
        CiModule ciModule = ciModuleService.findById(id);

        CiModuleDto dto = CiModuleMapper.toCiModuleDto(ciModule);

        return ResponseEntity.ok (dto);
    }

    @PostMapping
    public ResponseEntity <CiModuleDto> addCiModule(@RequestBody CiModuleInputDto inputDto) {

        CiModule savedCiModule = ciModuleService.saveCiModule(inputDto);

        CiModuleDto savedCiModuleDto = CiModuleMapper.toCiModuleDto(savedCiModule);

        return ResponseEntity.created(URI.create("/ci-module/" + savedCiModuleDto.getId())).body(savedCiModuleDto);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity <Void> deleteCiModule(@PathVariable ("id") Long id) {
        ciModuleService.deleteCiModule(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CiModuleDto> updateCiModule(@PathVariable Long id, @RequestBody CiModuleInputDto inputDto) {

        CiModule updatedCiModule = ciModuleService.updateCiModule(id, inputDto);

        CiModuleDto updatedCiModuleDto = CiModuleMapper.toCiModuleDto(updatedCiModule);

        return ResponseEntity.ok().body(updatedCiModuleDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CiModuleDto> updatePartialCiModule(@PathVariable Long id, @RequestBody CiModuleInputDto inputDto){

        CiModule updatedCiModule = ciModuleService.updatePartialCiModule(id, inputDto);
        CiModuleDto updatedCiModuleDto = CiModuleMapper.toCiModuleDto(updatedCiModule);

        return ResponseEntity.ok().body(updatedCiModuleDto);

    }


}
