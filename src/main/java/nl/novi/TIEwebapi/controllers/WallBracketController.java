package nl.novi.TIEwebapi.controllers;

import nl.novi.TIEwebapi.dtos.RemoteControlDto;
import nl.novi.TIEwebapi.dtos.RemoteControlInputDto;
import nl.novi.TIEwebapi.dtos.WallBracketDto;
import nl.novi.TIEwebapi.dtos.WallBracketInputDto;
import nl.novi.TIEwebapi.mappers.RemoteControlMapper;
import nl.novi.TIEwebapi.mappers.WallBracketMapper;
import nl.novi.TIEwebapi.models.RemoteControl;
import nl.novi.TIEwebapi.models.WallBracket;
import nl.novi.TIEwebapi.services.WallBracketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/wallbrackets")
public class WallBracketController {

    private final WallBracketService wallBracketService;

    public WallBracketController(WallBracketService wallBracketService) {
        this.wallBracketService = wallBracketService;
    }

    @GetMapping
    public ResponseEntity<List<WallBracketDto>> getAllWallBrackets() {

        List<WallBracket> wallBrackets = wallBracketService.findAll();

        List<WallBracketDto> wallBracketDtos= wallBrackets.stream()
                .map(WallBracketMapper::toWallBracketDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(wallBracketDtos);

    };

    @GetMapping("/{id}")
    public ResponseEntity <WallBracketDto> getWallBracket(@PathVariable("id") Long id)  {
        WallBracket wallBracket = wallBracketService.findById(id);

        WallBracketDto dto = WallBracketMapper.toWallBracketDto(wallBracket);

        return ResponseEntity.ok (dto);
    }

    @PostMapping
    public ResponseEntity <WallBracketDto> addWallBracket(@RequestBody WallBracketInputDto inputDto) {

        WallBracket savedWallBracket = wallBracketService.saveWallBracket(inputDto);

        WallBracketDto savedWallBracketDto = WallBracketMapper.toWallBracketDto(savedWallBracket);

        return ResponseEntity.created(URI.create("/wallbracket/" + savedWallBracketDto.getId())).body(savedWallBracketDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deleteCiModule(@PathVariable ("id") Long id) {
        wallBracketService.deleteWallBracket(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<WallBracketDto> updateWallBracket(@PathVariable Long id, @RequestBody WallBracketInputDto inputDto) {

        WallBracket updatedWallBracket = wallBracketService.updateWallBracket(id, inputDto);

        WallBracketDto updatedWallBracketDto = WallBracketMapper.toWallBracketDto(updatedWallBracket);

        return ResponseEntity.ok().body(updatedWallBracketDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<WallBracketDto> updatePartialWallBracketCiModule(@PathVariable Long id, @RequestBody WallBracketInputDto inputDto){

        WallBracket updatedWallBracket = wallBracketService.updateWallBracket(id, inputDto);

        WallBracketDto updatedWallBracketDto = WallBracketMapper.toWallBracketDto(updatedWallBracket);

        return ResponseEntity.ok().body(updatedWallBracketDto);

    }


}
