package nl.novi.TIEwebapi.mappers;

import nl.novi.TIEwebapi.dtos.WallBracketDto;
import nl.novi.TIEwebapi.dtos.WallBracketInputDto;
import nl.novi.TIEwebapi.models.WallBracket;

public class WallBracketMapper {

    public static WallBracketDto toWallBracketDto (WallBracket wallBracket) {
        WallBracketDto dto = new WallBracketDto();

        dto.setId(wallBracket.getId());
        dto.setSize(wallBracket.getSize());
        dto.setAdjustable(wallBracket.getAdjustable());
        dto.setName(wallBracket.getName());
        dto.setPrice(wallBracket.getPrice());

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
