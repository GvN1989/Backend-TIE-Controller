package nl.novi.TIEwebapi.services;

import nl.novi.TIEwebapi.dtos.WallBracketInputDto;
import nl.novi.TIEwebapi.exceptions.RecordNotFoundException;
import nl.novi.TIEwebapi.mappers.WallBracketMapper;
import nl.novi.TIEwebapi.models.WallBracket;
import nl.novi.TIEwebapi.repositories.WallBracketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WallBracketService {

    private final WallBracketRepository wallBracketRepository;

    public WallBracketService(WallBracketRepository wallBracketRepository) {
        this.wallBracketRepository = wallBracketRepository;
    }

    public List<WallBracket> findAll(){return wallBracketRepository.findAll();}

    public WallBracket findById(Long id) {
        return wallBracketRepository.findById(id)
                .orElseThrow(()-> new RecordNotFoundException("Wallbracket with id: " + id + "not found"));
    }

    public WallBracket saveWallBracket(WallBracketInputDto inputDto) {
        WallBracket wallBracket= WallBracketMapper.toWallBracketEntity(inputDto);
        return wallBracketRepository.save(wallBracket);
    }

    public WallBracket updateWallBracket (Long id, WallBracketInputDto inputDto) {

        if (!wallBracketRepository.existsById(id)) {
            throw new RecordNotFoundException("No wall bracket found with ID " + id);
        }

        WallBracket wallBracket = WallBracketMapper.toWallBracketEntity(inputDto);
        wallBracket.setId(id);
        return wallBracketRepository.save(wallBracket);
    }

    public WallBracket updatePartialWallBracket (Long id, WallBracketInputDto inputDto) {
        WallBracket existingWallBracket = wallBracketRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("No wall bracket found with ID " + id));

        if (inputDto.getAdjustable() != null) existingWallBracket.setAdjustable(inputDto.getAdjustable());
        if (inputDto.getName() != null) existingWallBracket.setName(inputDto.getName());
        if (inputDto.getSize() != null) existingWallBracket.setSize(inputDto.getSize());
        if (inputDto.getPrice() != null) existingWallBracket.setPrice(inputDto.getPrice());


        return wallBracketRepository.save(existingWallBracket);
    }

    public void deleteWallBracket (Long id) {
        if (!wallBracketRepository.existsById(id)) {
            throw new RecordNotFoundException("No wallbracket found with ID " + id);
        }

       wallBracketRepository.deleteById(id); }

}
