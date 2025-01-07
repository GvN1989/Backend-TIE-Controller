package nl.novi.TIEwebapi.services;

import nl.novi.TIEwebapi.dtos.TelevisionInputDto;
import nl.novi.TIEwebapi.exceptions.RecordNotFoundException;
import nl.novi.TIEwebapi.mappers.TelevisionMapper;
import nl.novi.TIEwebapi.models.CiModule;
import nl.novi.TIEwebapi.models.RemoteControl;
import nl.novi.TIEwebapi.models.Television;
import nl.novi.TIEwebapi.models.WallBracket;
import nl.novi.TIEwebapi.repositories.CiModuleRepository;
import nl.novi.TIEwebapi.repositories.RemoteControlRepository;
import nl.novi.TIEwebapi.repositories.TelevisionRepository;
import nl.novi.TIEwebapi.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelevisionService {

    private final TelevisionRepository televisionRepository;
    private final RemoteControlRepository remoteControlRepository;
    private final CiModuleRepository ciModuleRepository;

    private final WallBracketRepository wallBracketRepository;

    public TelevisionService(TelevisionRepository televisionRepository, RemoteControlRepository remoteControlRepository, CiModuleRepository ciModuleRepository, WallBracketRepository wallBracketRepository) {
        this.televisionRepository = televisionRepository;
        this.remoteControlRepository = remoteControlRepository;
        this.ciModuleRepository = ciModuleRepository;
        this.wallBracketRepository = wallBracketRepository;
    }

    public List<Television> findAll(){
        return televisionRepository.findAll();
    }

    public Television findById(Long id){
        return televisionRepository.findById(id)
                .orElseThrow(()-> new RecordNotFoundException("Television with id: " + id + "not found"));

    }

    public Television saveTelevision(TelevisionInputDto inputDto) {
        Television television= TelevisionMapper.toTelevisionEntity(inputDto);
        return televisionRepository.save(television);
    }

    public Television updateTelevision (Long id, TelevisionInputDto inputDto) {

        if (!televisionRepository.existsById(id)) {
            throw new RecordNotFoundException("No television found with ID " + id);
        }

        Television television = TelevisionMapper.toTelevisionEntity(inputDto);
        television.setId(id);
        return televisionRepository.save(television);
    }

    public Television updatePartialTelevision(Long id, TelevisionInputDto inputDto) {
        Television existingTelevision = televisionRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("No television found with ID " + id));

        if (inputDto.getAmbiLight() != null) existingTelevision.setAmbiLight(inputDto.getAmbiLight());
        if (inputDto.getAvailableSize() != null) existingTelevision.setAvailableSize(inputDto.getAvailableSize());
        if (inputDto.getBluetooth() != null) existingTelevision.setBluetooth(inputDto.getBluetooth());
        if (inputDto.getBrand() != null) existingTelevision.setBrand(inputDto.getBrand());
        if (inputDto.getHdr() != null) existingTelevision.setHdr(inputDto.getHdr());
        if (inputDto.getName() != null) existingTelevision.setName(inputDto.getName());
        if (inputDto.getOriginalStock() != null) existingTelevision.setOriginalStock(inputDto.getOriginalStock());
        if (inputDto.getPrice() != null) existingTelevision.setPrice(inputDto.getPrice());
        if (inputDto.getRefreshRate() != null) existingTelevision.setRefreshRate(inputDto.getRefreshRate());
        if (inputDto.getScreenQuality() != null) existingTelevision.setScreenQuality(inputDto.getScreenQuality());
        if (inputDto.getScreenType() != null) existingTelevision.setScreenType(inputDto.getScreenType());
        if (inputDto.getSmartTv() != null) existingTelevision.setSmartTv(inputDto.getSmartTv());
        if (inputDto.getSold() != null) existingTelevision.setSold(inputDto.getSold());
        if (inputDto.getType() != null) existingTelevision.setType(inputDto.getType());
        if (inputDto.getVoiceControl() != null) existingTelevision.setVoiceControl(inputDto.getVoiceControl());
        if (inputDto.getWifi() != null) existingTelevision.setWifi(inputDto.getWifi());

        return televisionRepository.save(existingTelevision);
    }

    public void deleteTelevision (Long id) {
        if (!televisionRepository.existsById(id)) {
            throw new RecordNotFoundException("No television found with ID " + id);
        }

        televisionRepository.deleteById(id); }

    public List<Television> findAllTelevisionsByBrandEqualsIgnoreCase(String brand) {
        return televisionRepository.findAllByBrandEqualsIgnoreCase(brand);

    }

    public Television assignRemoteControlToTelevision( Long televisionId, Long remoteControlId) {

        Television television = televisionRepository.findById(televisionId)
                .orElseThrow(()-> new RecordNotFoundException("Television with ID " + televisionId + " not found"));

        RemoteControl remoteControl = remoteControlRepository.findById(remoteControlId)
                .orElseThrow(() -> new RecordNotFoundException("RemoteControl with ID " + remoteControlId + " not found"));

        television.setRemoteControl(remoteControl);

        return televisionRepository.save(television);
    }

    public Television assignCiModuletoTelevision (Long televisionId, Long CiModuleId) {
        Television television = televisionRepository.findById(televisionId)
                .orElseThrow(()-> new RecordNotFoundException("Television with ID " + televisionId + " not found"));

        CiModule ciModule = ciModuleRepository.findById(CiModuleId)
                .orElseThrow(() -> new RecordNotFoundException("CI-module with ID " + CiModuleId + " not found"));

        television.setCiModule(ciModule);

        return televisionRepository.save(television);
    }

    public Television assignWallBracketToTelevision(Long televisionId, Long wallBracketId) {
        Television television = televisionRepository.findById(televisionId)
                .orElseThrow(() -> new RecordNotFoundException("Television with ID " + televisionId + " not found"));

        WallBracket wallBracket = wallBracketRepository.findById(wallBracketId)
                .orElseThrow(() -> new RecordNotFoundException("WallBracket with ID " + wallBracketId + " not found"));

        television.getWallBrackets().add(wallBracket);
        wallBracket.getTelevisions().add(television);

        return televisionRepository.save(television);
    }


}

