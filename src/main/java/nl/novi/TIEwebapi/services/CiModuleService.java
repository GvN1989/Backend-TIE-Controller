package nl.novi.TIEwebapi.services;

import nl.novi.TIEwebapi.dtos.CiModuleInputDto;
import nl.novi.TIEwebapi.exceptions.RecordNotFoundException;
import nl.novi.TIEwebapi.mappers.CiModuleMapper;
import nl.novi.TIEwebapi.models.CiModule;
import nl.novi.TIEwebapi.repositories.CiModuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiModuleService {

    private final CiModuleRepository ciModuleRepository;

    public CiModuleService(CiModuleRepository ciModuleRepository) {
        this.ciModuleRepository = ciModuleRepository;
    }

    public List<CiModule> findAll(){return ciModuleRepository.findAll();}

    public CiModule findById(Long id) {
        CiModule ciModule = ciModuleRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("CI-module with id: " + id + "not found"));

        if (ciModule.getTelevisions() != null) {
            ciModule.getTelevisions().size();
        }

        return ciModule;
    }
    public CiModule saveCiModule(CiModuleInputDto inputDto) {
        CiModule ciModule = CiModuleMapper.toCiModuleEntity(inputDto);
        return ciModuleRepository.save(ciModule);
    }

    public CiModule updateCiModule (Long id, CiModuleInputDto inputDto) {

        if (!ciModuleRepository.existsById(id)) {
            throw new RecordNotFoundException("No CI-module found with ID " + id);
        }

        CiModule ciModule = CiModuleMapper.toCiModuleEntity(inputDto);
        ciModule.setId(id);
        return ciModuleRepository.save(ciModule);
    }

    public CiModule updatePartialCiModule (Long id, CiModuleInputDto inputDto) {
        CiModule existingCiModule = ciModuleRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("No CI-module found with ID " + id));

        if (inputDto.getType()!= null) existingCiModule.setType(inputDto.getType());
        if (inputDto.getName() != null) existingCiModule.setName(inputDto.getName());
        if (inputDto.getPrice() != null) existingCiModule.setPrice(inputDto.getPrice());


        return ciModuleRepository.save(existingCiModule);
    }

    public void deleteCiModule (Long id) {
        if (!ciModuleRepository.existsById(id)) {
            throw new RecordNotFoundException("No CI-module found with ID " + id);
        }

        ciModuleRepository.deleteById(id); }


}
