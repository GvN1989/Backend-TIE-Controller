package nl.novi.TIEwebapi.controllers;


import nl.novi.TIEwebapi.exceptions.RecordNotFoundException;
import nl.novi.TIEwebapi.models.Television;
import nl.novi.TIEwebapi.repositories.TelevisionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TelevisionsController {

    private final TelevisionRepository televisionRepository;

    public TelevisionsController(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }


    @GetMapping("/televisions")
    public ResponseEntity <List<Television>> getAllTelevisions(@RequestParam(value="brand",required = false) String brand ){
        List<Television> televisions;

        if (brand == null){
            televisions = televisionRepository.findAll();
        } else {
            televisions=televisionRepository.findAllTelevisionsByBrandEqualsIgnoreCase(brand);
        }

    return ResponseEntity.ok(televisions);
    }

    @GetMapping("/televisions/{id}")
    public ResponseEntity <Television> getTelevision(@PathVariable ("id") Long id)  {

        Television television = televisionRepository.findById(id)
                .orElseThrow(()-> new RecordNotFoundException("No television found with id: " + id));
        return ResponseEntity.ok ().body(television);
    }

    @PostMapping("/televisions")
        public ResponseEntity <Television> addTelevision(@RequestBody Television television) {

            Television returnTelevision = televisionRepository.save(television);

            return ResponseEntity.created(null).body(returnTelevision);
    }

    @DeleteMapping ("/televisions/{id}")
    public ResponseEntity <Object> deleteTelevision(@PathVariable ("id") Long id) {
        televisionRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/televisions/{id}")
        public ResponseEntity<Television> updateTelevision(@PathVariable Long id, @RequestBody Television newTelevision) {

        Television television1 = televisionRepository.findById(id)
                .orElseThrow(()-> new RecordNotFoundException("No television found with id: " + id));

            television1.setAmbiLight(newTelevision.getAmbiLight());
            television1.setAvailableSize(newTelevision.getAvailableSize());
            television1.setBluetooth(newTelevision.getBluetooth());
            television1.setBrand(newTelevision.getBrand());
            television1.setHdr(newTelevision.getHdr());
            television1.setName(newTelevision.getName());
            television1.setOriginalStock(newTelevision.getOriginalStock());
            television1.setPrice(newTelevision.getPrice());
            television1.setRefreshRate(newTelevision.getRefreshRate());
            television1.setScreenQuality(newTelevision.getScreenQuality());
            television1.setScreenType(newTelevision.getScreenType());
            television1.setSmartTv(newTelevision.getSmartTv());
            television1.setSold(newTelevision.getSold());
            television1.setType(newTelevision.getType());
            television1.setVoiceControl(newTelevision.getVoiceControl());
            television1.setWifi(newTelevision.getWifi());

            Television updatedTelevision = televisionRepository.save(television1);

            return ResponseEntity.ok().body(updatedTelevision);
        }

        @PatchMapping("/televisions/{id}")
        public ResponseEntity<Television> updatePartialTelevision(@PathVariable Long id, @RequestBody Television newTelevision){

            Television television = televisionRepository.findById(id)
                    .orElseThrow(()-> new RecordNotFoundException("No television found with id: " + id));

            if (newTelevision.getAmbiLight() != null) television.setAmbiLight(newTelevision.getAmbiLight());
            if (newTelevision.getAvailableSize() != null) television.setAvailableSize(newTelevision.getAvailableSize());
            if (newTelevision.getBluetooth() != null) television.setBluetooth(newTelevision.getBluetooth());
            if (newTelevision.getBrand() != null) television.setBrand(newTelevision.getBrand());
            if (newTelevision.getHdr() != null) television.setHdr(newTelevision.getHdr());
            if (newTelevision.getName() != null) television.setName(newTelevision.getName());
            if (newTelevision.getOriginalStock() != null) television.setOriginalStock(newTelevision.getOriginalStock());
            if (newTelevision.getPrice() != null) television.setPrice(newTelevision.getPrice());
            if (newTelevision.getRefreshRate() != null) television.setRefreshRate(newTelevision.getRefreshRate());
            if (newTelevision.getScreenQuality() != null) television.setScreenQuality(newTelevision.getScreenQuality());
            if (newTelevision.getScreenType() != null) television.setScreenType(newTelevision.getScreenType());
            if (newTelevision.getSmartTv() != null) television.setSmartTv(newTelevision.getSmartTv());
            if (newTelevision.getSold() != null) television.setSold(newTelevision.getSold());
            if (newTelevision.getType() != null) television.setType(newTelevision.getType());
            if (newTelevision.getVoiceControl() != null) television.setVoiceControl(newTelevision.getVoiceControl());
            if (newTelevision.getWifi() != null) television.setWifi(newTelevision.getWifi());

            Television updatedTelevision = televisionRepository.save(television);

            return ResponseEntity.ok().body(updatedTelevision);

        }

    }





