package nl.novi.TIEwebapi.controllers;

import nl.novi.TIEwebapi.dtos.RemoteControlDto;
import nl.novi.TIEwebapi.dtos.RemoteControlInputDto;
import nl.novi.TIEwebapi.dtos.TelevisionDto;
import nl.novi.TIEwebapi.dtos.TelevisionInputDto;
import nl.novi.TIEwebapi.mappers.RemoteControlMapper;
import nl.novi.TIEwebapi.mappers.TelevisionMapper;
import nl.novi.TIEwebapi.models.RemoteControl;
import nl.novi.TIEwebapi.models.Television;
import nl.novi.TIEwebapi.services.RemoteControlService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/remotecontrol")

public class RemoteControlController {

    private final RemoteControlService remoteControlService;

    public RemoteControlController(RemoteControlService remoteControlService) {
        this.remoteControlService = remoteControlService;
    }

    @GetMapping
    public ResponseEntity<List<RemoteControlDto>> getAllRemoteControls() {

        List<RemoteControl> remoteControls = remoteControlService.findAll();

        List<RemoteControlDto> remoteControlDtos= remoteControls.stream()
                .map(RemoteControlMapper::toRemoteControlDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(remoteControlDtos);

    };

    @GetMapping("/{id}")
    public ResponseEntity <RemoteControlDto> getRemoteControl(@PathVariable("id") Long id)  {
        RemoteControl remoteControl = remoteControlService.findById(id);

        RemoteControlDto dto = RemoteControlMapper.toRemoteControlDto(remoteControl);

        return ResponseEntity.ok (dto);
    }

    @PostMapping
    public ResponseEntity <RemoteControlDto> addRemoteControl(@RequestBody RemoteControlInputDto inputDto) {

        RemoteControl savedRemoteControl = remoteControlService.saveRemoteControl(inputDto);

        RemoteControlDto savedRemoteControlDto = RemoteControlMapper.toRemoteControlDto(savedRemoteControl);

        return ResponseEntity.created(URI.create("/remotecontrol/" + savedRemoteControlDto.getId())).body(savedRemoteControlDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deleteCiModule(@PathVariable ("id") Long id) {
        remoteControlService.deleteRemoteControl(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RemoteControlDto> updateRemoteControl(@PathVariable Long id, @RequestBody RemoteControlInputDto inputDto) {

        RemoteControl updatedRemoteControl = remoteControlService.updateRemoteControl(id, inputDto);

        RemoteControlDto updatedRemoteControlDto = RemoteControlMapper.toRemoteControlDto(updatedRemoteControl);

        return ResponseEntity.ok().body(updatedRemoteControlDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RemoteControlDto> updatePartialRemoteControlr(@PathVariable Long id, @RequestBody RemoteControlInputDto inputDto){

        RemoteControl  updatedRemoteControl = remoteControlService.updateRemoteControl(id, inputDto);
        RemoteControlDto updatedRemoteControlDto = RemoteControlMapper.toRemoteControlDto(updatedRemoteControl);

        return ResponseEntity.ok().body(updatedRemoteControlDto);

    }

}
