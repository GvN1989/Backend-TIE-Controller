package nl.novi.TIEwebapi.mappers;

import nl.novi.TIEwebapi.dtos.SalesInfoDto;
import nl.novi.TIEwebapi.dtos.TelevisionDto;
import nl.novi.TIEwebapi.dtos.TelevisionInputDto;
import nl.novi.TIEwebapi.models.Television;
import nl.novi.TIEwebapi.models.WallBracket;

import java.util.stream.Collectors;

public class TelevisionMapper {

    public static TelevisionDto toTelevisionDto(Television television) {
        TelevisionDto dto = new TelevisionDto();

        dto.setId(television.getId());
        dto.setType(television.getType());
        dto.setBrand(television.getBrand());
        dto.setName(television.getName());
        dto.setPrice(television.getPrice());
        dto.setAvailableSize(television.getAvailableSize());
        dto.setRefreshRate(television.getRefreshRate());
        dto.setScreenType(television.getScreenType());
        dto.setScreenQuality(television.getScreenQuality());
        dto.setSmartTv(television.getSmartTv());
        dto.setWifi(television.getWifi());
        dto.setVoiceControl(television.getVoiceControl());
        dto.setHdr(television.getHdr());
        dto.setBluetooth(television.getBluetooth());
        dto.setAmbiLight(television.getAmbiLight());
        dto.setOriginalStock(television.getOriginalStock());
        dto.setSold(television.getSold());

        if(television.getRemoteControl()!= null) {
            dto.setRemoteControl(RemoteControlMapper.toRemoteControlDto(television.getRemoteControl()));
        }

        if(television.getCiModule()!= null) {
            dto.setCiModuleId(television.getCiModule().getId());
        }

        if (television.getWallBrackets() != null) {
            dto.setWallBracketIds(
                    television.getWallBrackets().stream()
                            .map(WallBracket::getId)
                            .collect(Collectors.toSet())
            );
        }

        return dto;
    }

    public static Television toTelevisionEntity (TelevisionInputDto inputDto){
        Television television = new Television();

        television.setType(inputDto.getType());
        television.setBrand(inputDto.getBrand());
        television.setName(inputDto.getName());
        television.setPrice(inputDto.getPrice());
        television.setAvailableSize(inputDto.getAvailableSize());
        television.setRefreshRate(inputDto.getRefreshRate());
        television.setScreenType(inputDto.getScreenType());
        television.setScreenQuality(inputDto.getScreenQuality());
        television.setSmartTv(inputDto.getSmartTv());
        television.setWifi(inputDto.getWifi());
        television.setVoiceControl(inputDto.getVoiceControl());
        television.setHdr(inputDto.getHdr());
        television.setBluetooth(inputDto.getBluetooth());
        television.setAmbiLight(inputDto.getAmbiLight());
        television.setOriginalStock(inputDto.getOriginalStock());
        television.setSold(inputDto.getSold());

        return television;
    }

    public static SalesInfoDto toSalesInfoDto(Television television){
        return new SalesInfoDto(
        television.getId(),
        television.getName(),
        television.getBrand(),
        television.getPrice(),
        television.getOriginalStock(),
        television.getSold()
        );
    }

}
