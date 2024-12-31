package nl.novi.TIEwebapi.controllers;


import nl.novi.TIEwebapi.exceptions.RecordNotFoundException;
import nl.novi.TIEwebapi.exceptions.TelevisionNameTooLongException;
import nl.novi.TIEwebapi.models.Television;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping (value="/bonus")
public class TelevisionsController {

    private static final List<String> televisionDatabase= new ArrayList<>();

/*    private final List<Television> televisionDatabase= new ArrayList<>();

    public TelevisionsController() {
        televisionDatabase.add(new Television(1L, "Samsung", "QLED 8K", 75, true));
        televisionDatabase.add(new Television(2L, "Sony", "Bravia OLED", 65, true));
        televisionDatabase.add(new Television(3L, "LG", "NanoCell 4K", 55, false));
        televisionDatabase.add(new Television(4L, "Panasonic", "LED HD", 40, false));
    }*/

    @GetMapping("/televisions")
    public ResponseEntity <Object> getAllTelevisions(){
        return ResponseEntity.ok(televisionDatabase);
    }

    @GetMapping("/televisions/{id}")
    public ResponseEntity <Object> getTelevision(@PathVariable ("id") int id)  {

        return ResponseEntity.ok (televisionDatabase.get(id));
    }

    @PostMapping("/televisions")
        public ResponseEntity <Object> addTelevision( @RequestBody String television) {
        if (television.length() > 20) {
            throw new TelevisionNameTooLongException("Televisienaam is te lang");
        } else {
            televisionDatabase.add(television);
            return ResponseEntity.created(null).body("television");
        }
    }

    @PutMapping("/televisions/{id}")
        public ResponseEntity<Object> updateTelevision(@PathVariable int id, @RequestBody String television) {
        if (televisionDatabase.isEmpty() || id > televisionDatabase.size()) {
            throw new RecordNotFoundException("Record met id: " + id + " niet gevonden in de database.");
        } else {
            televisionDatabase.set(id, television);
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping ("/televisions/{id}")
        public ResponseEntity <Object> deleteTelevision(@PathVariable int id) {
                televisionDatabase.set(id, null);

            return ResponseEntity.noContent().build();
    }

    }

