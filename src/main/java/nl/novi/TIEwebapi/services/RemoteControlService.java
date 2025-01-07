package nl.novi.TIEwebapi.services;

import nl.novi.TIEwebapi.dtos.RemoteControlInputDto;
import nl.novi.TIEwebapi.exceptions.RecordNotFoundException;
import nl.novi.TIEwebapi.mappers.RemoteControlMapper;
import nl.novi.TIEwebapi.models.RemoteControl;
import nl.novi.TIEwebapi.repositories.RemoteControlRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemoteControlService {

    private final RemoteControlRepository remoteControlRepository;

    public RemoteControlService(RemoteControlRepository remoteControlRepository) {
        this.remoteControlRepository = remoteControlRepository;
    }

    public List<RemoteControl> findAll(){return remoteControlRepository.findAll();}

    public RemoteControl findById(Long id) {
        return remoteControlRepository.findById(id)
                .orElseThrow(()-> new RecordNotFoundException("Remote control with id: " + id + "not found"));
    }

    public RemoteControl saveRemoteControl(RemoteControlInputDto inputDto) {
        RemoteControl remoteControl= RemoteControlMapper.toRemoteControlEntity(inputDto);
        return remoteControlRepository.save(remoteControl);
    }

    public RemoteControl updateRemoteControl (Long id, RemoteControlInputDto inputDto) {

        if (!remoteControlRepository.existsById(id)) {
            throw new RecordNotFoundException("No television found with ID " + id);
        }

        RemoteControl remoteControl = RemoteControlMapper.toRemoteControlEntity(inputDto);
        remoteControl.setId(id);
        return remoteControlRepository.save(remoteControl);
    }

    public RemoteControl updatePartialRemoteControl (Long id, RemoteControlInputDto inputDto) {
        RemoteControl existingRemoteControl = remoteControlRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("No remote control found with ID " + id));

        if (inputDto.getCompatibleWith() != null) existingRemoteControl.setCompatibleWith(inputDto.getCompatibleWith());
        if (inputDto.getBatteryType()!= null) existingRemoteControl.setBatteryType(inputDto.getBatteryType());
        if (inputDto.getName() != null) existingRemoteControl.setName(inputDto.getName());
        if (inputDto.getBrand() != null) existingRemoteControl.setBrand(inputDto.getBrand());
        if (inputDto.getOriginalStock() != null) existingRemoteControl.setOriginalStock(inputDto.getOriginalStock());
        if (inputDto.getPrice() != null) existingRemoteControl.setPrice(inputDto.getPrice());


        return remoteControlRepository.save(existingRemoteControl);
    }

    public void deleteRemoteControl (Long id) {
        if (!remoteControlRepository.existsById(id)) {
            throw new RecordNotFoundException("No remote control found with ID " + id);
        }

        remoteControlRepository.deleteById(id); }



}
