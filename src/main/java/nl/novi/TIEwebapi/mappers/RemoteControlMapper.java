package nl.novi.TIEwebapi.mappers;

import nl.novi.TIEwebapi.dtos.RemoteControlDto;
import nl.novi.TIEwebapi.dtos.RemoteControlInputDto;
import nl.novi.TIEwebapi.models.RemoteControl;

public class RemoteControlMapper {

    public static RemoteControlDto toRemoteControlDto (RemoteControl remoteControl) {
        RemoteControlDto dto = new RemoteControlDto();

        dto.setId(remoteControl.getId());
        dto.setCompatibleWith(remoteControl.getCompatibleWith());
        dto.setBatteryType(remoteControl.getBatteryType());
        dto.setBrand(remoteControl.getBrand());
        dto.setName(remoteControl.getName());
        dto.setPrice(remoteControl.getPrice());
        dto.setOriginalStock(remoteControl.getOriginalStock());

        return dto;

    }

    public static RemoteControl toRemoteControlEntity(RemoteControlInputDto inputDto){
        RemoteControl remoteControl= new RemoteControl();

        remoteControl.setCompatibleWith(inputDto.getCompatibleWith());
        remoteControl.setBatteryType(inputDto.getBatteryType());
        remoteControl.setName(inputDto.getName());
        remoteControl.setBrand(inputDto.getBrand());
        remoteControl.setPrice(inputDto.getPrice());
        remoteControl.setOriginalStock(inputDto.getOriginalStock());

        return remoteControl;

    }

}
