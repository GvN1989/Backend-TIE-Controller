package nl.novi.TIEwebapi.controllers;


import nl.novi.TIEwebapi.dtos.SalesInfoDto;
import nl.novi.TIEwebapi.dtos.TelevisionDto;
import nl.novi.TIEwebapi.dtos.TelevisionInputDto;
import nl.novi.TIEwebapi.mappers.TelevisionMapper;
import nl.novi.TIEwebapi.models.Television;
import nl.novi.TIEwebapi.services.SalesInfoService;
import nl.novi.TIEwebapi.services.TelevisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/televisions")
public class TelevisionsController {

    private final TelevisionService televisionService;
    private final SalesInfoService salesInfoService;

    public TelevisionsController(TelevisionService televisionService, SalesInfoService salesInfoService) {
        this.televisionService = televisionService;
        this.salesInfoService = salesInfoService;
    }

    @GetMapping
    public ResponseEntity <List<TelevisionDto>> getAllTelevisions(@RequestParam(value="brand",required = false) String brand ){

        List<Television> televisions;

        if (brand == null){
            televisions = televisionService.findAll();
        } else {
            televisions=televisionService.findAllTelevisionsByBrandEqualsIgnoreCase(brand);
        }

        List<TelevisionDto> televisionsDtos= televisions.stream()
                .map(TelevisionMapper::toTelevisionDto)
                .collect(Collectors.toList());

    return ResponseEntity.ok(televisionsDtos);
    }

    @GetMapping("/salesInfo")
    public ResponseEntity<List<SalesInfoDto>> getAllSalesInfo(){
        List<SalesInfoDto> salesInfo= salesInfoService.getAllSalesInfo();

        return ResponseEntity.ok(salesInfo);

    }

    @GetMapping("/{id}")
    public ResponseEntity <TelevisionDto> getTelevision(@PathVariable ("id") Long id)  {
        Television television = televisionService.findById(id);

        TelevisionDto dto = TelevisionMapper.toTelevisionDto(television);

        return ResponseEntity.ok (dto);
    }

    @PostMapping
        public ResponseEntity <TelevisionDto> addTelevision(@RequestBody TelevisionInputDto inputDto) {

            Television savedTelevision = televisionService.saveTelevision(inputDto);

            TelevisionDto savedTelevisionDto = TelevisionMapper.toTelevisionDto(savedTelevision);

            return ResponseEntity.created(URI.create("/televisions/" + savedTelevisionDto.getId())).body(savedTelevisionDto);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity <Void> deleteTelevision(@PathVariable ("id") Long id) {
        televisionService.deleteTelevision(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
        public ResponseEntity<TelevisionDto> updateTelevision(@PathVariable Long id, @RequestBody TelevisionInputDto inputDto) {

        Television updatedTelevision = televisionService.updateTelevision(id, inputDto);

        TelevisionDto updatedTelevisionDto = TelevisionMapper.toTelevisionDto(updatedTelevision);

        return ResponseEntity.ok().body(updatedTelevisionDto);
        }

    @PatchMapping("/{id}")
        public ResponseEntity<TelevisionDto> updatePartialTelevision(@PathVariable Long id, @RequestBody TelevisionInputDto inputDto){

            Television updatedTelevision = televisionService.updatePartialTelevision(id,inputDto);
            TelevisionDto updatedTelevisionDto= TelevisionMapper.toTelevisionDto(updatedTelevision);

            return ResponseEntity.ok().body(updatedTelevisionDto);

        }

    }





