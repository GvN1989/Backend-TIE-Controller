package nl.novi.TIEwebapi.mappers;

import nl.novi.TIEwebapi.dtos.CiModuleDto;
import nl.novi.TIEwebapi.dtos.CiModuleInputDto;
import nl.novi.TIEwebapi.models.CiModule;
import nl.novi.TIEwebapi.models.Television;

import java.util.stream.Collectors;

public class CiModuleMapper {

    public static CiModuleDto toCiModuleDto (CiModule ciModule) {
        CiModuleDto dto = new CiModuleDto();

        dto.setId(ciModule.getId());
        dto.setName(ciModule.getName());
        dto.setType(ciModule.getType());
        dto.setPrice(ciModule.getPrice());

        if (ciModule.getTelevisions() != null) {
            dto.setTelevisionsIds(
                    ciModule.getTelevisions().stream()
                            .map(Television::getId)
                            .collect(Collectors.toList())
            );
        }
        return dto;
    }

    public static CiModule toCiModuleEntity(CiModuleInputDto inputDto) {
        CiModule ciModule = new CiModule();

        ciModule.setName(inputDto.getName());
        ciModule.setType(inputDto.getType());
        ciModule.setPrice(inputDto.getPrice());

        return ciModule;

    }


}
