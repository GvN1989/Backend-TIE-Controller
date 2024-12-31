package nl.novi.TIEwebapi.controllers;


import nl.novi.TIEwebapi.exceptions.RecordNotFoundException;
import nl.novi.TIEwebapi.models.Television;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class TelevisionsController {

    private final List<Television> televisionDatabase= new ArrayList<>();

    public TelevisionsController() {
        televisionDatabase.add(new Television(1L, "Samsung", "QLED 8K", 75, true));
        televisionDatabase.add(new Television(2L, "Sony", "Bravia OLED", 65, true));
        televisionDatabase.add(new Television(3L, "LG", "NanoCell 4K", 55, false));
        televisionDatabase.add(new Television(4L, "Panasonic", "LED HD", 40, false));
    }

    @GetMapping("/televisions")
    public ResponseEntity <List<Television>> getAllTelevisions(){
        if(televisionDatabase.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(televisionDatabase);
    }

    @GetMapping("/televisions/{id}")
    public ResponseEntity <Television> getTelevision(@PathVariable Long id) {
        System.out.println("Looking for television with ID:" + id);
        return televisionDatabase.stream()
                .filter(tv-> {
                    System.out.println("Checking television: " + tv.getId());
                    return Objects.equals(tv.getId(), id);
                })
                .findFirst()
                .map(ResponseEntity:: ok)
                .orElseThrow(() -> new RecordNotFoundException("Television with ID " + id + " not found"));
                }

    @PostMapping("/televisions")
        public ResponseEntity <String> createTelevision( @RequestBody Television television) {
        boolean idExists = televisionDatabase.stream()
                        .anyMatch(tv-> tv. getId().equals(television.getId()));

        if (idExists) {
            return ResponseEntity.badRequest().body("A television with the same ID already exists.");
        }

        televisionDatabase.add(television);
        return ResponseEntity.created(null).body("television has been added to list");
    }

    @PutMapping("/televisions/{id}")
        public ResponseEntity <String> updateTelevision(@PathVariable Long id, @RequestBody Television updatedTelevision){
        Television existingTelevision = televisionDatabase.stream()
                .filter(tv-> Objects.equals(tv.getId(), id))
                .findFirst()
                .orElseThrow(() -> new RecordNotFoundException("Television with ID " + id + " not found"));

        existingTelevision.setBrand(updatedTelevision.getBrand());
        existingTelevision.setModel(updatedTelevision.getModel());
        existingTelevision.setScreenSize(updatedTelevision.getScreenSize());
        existingTelevision.setSmartTv(updatedTelevision.isSmartTv());

        return ResponseEntity.ok("Television with ID " + id + " has been updated");
    }

    @DeleteMapping ("/televisions/{id}")
        public ResponseEntity <String> deleteTelevision (@PathVariable Long id) {
            Television existingTelevision = televisionDatabase.stream()
                    .filter(tv -> tv.getId().equals(id))
                    .findFirst()
                    .orElseThrow(() -> new RecordNotFoundException("Television with ID" + id + " not found"));

            televisionDatabase.remove(existingTelevision);
            return ResponseEntity.ok("Television with ID " + id + " has been deleted");
    }

}
