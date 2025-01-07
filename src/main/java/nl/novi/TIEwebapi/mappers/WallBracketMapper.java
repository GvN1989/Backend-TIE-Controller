package nl.novi.TIEwebapi.mappers;

import nl.novi.TIEwebapi.dtos.WallBracketDto;
import nl.novi.TIEwebapi.dtos.WallBracketInputDto;
import nl.novi.TIEwebapi.models.WallBracket;
import nl.novi.TIEwebapi.models.Television;

import java.util.stream.Collectors;

public class WallBracketMapper {

    public static WallBracketDto toWallBracketDto (WallBracket wallBracket) {
        WallBracketDto dto = new WallBracketDto();

        dto.setId(wallBracket.getId());
        dto.setSize(wallBracket.getSize());
        dto.setAdjustable(wallBracket.getAdjustable());
        dto.setName(wallBracket.getName());
        dto.setPrice(wallBracket.getPrice());

        if (wallBracket.getTelevisions() != null) {
            dto.setTelevisionIds(
                    wallBracket.getTelevisions().stream()
                            .map(Television::getId)
                            .collect(Collectors.toSet())
            );
        }

        return dto;
    }

    public static WallBracket toWallBracketEntity(WallBracketInputDto inputDto){
        WallBracket wallBracket= new WallBracket();

        wallBracket.setSize(inputDto.getSize());
        wallBracket.setAdjustable(inputDto.getAdjustable());
        wallBracket.setName(inputDto.getName());
        wallBracket.setPrice(inputDto.getPrice());

        return wallBracket;

    }

}
