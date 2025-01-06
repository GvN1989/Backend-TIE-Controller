package nl.novi.TIEwebapi.services;

import nl.novi.TIEwebapi.dtos.SalesInfoDto;
import nl.novi.TIEwebapi.models.Television;
import nl.novi.TIEwebapi.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalesInfoService {

    private final TelevisionRepository televisionRepository;

    public SalesInfoService(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    public List<SalesInfoDto> getAllSalesInfo() {
        List<Television> televisions= televisionRepository.findAll();

        return televisions.stream()
                .map(television -> new SalesInfoDto(
                        television.getId(),
                        television.getName(),
                        television.getBrand(),
                        television.getPrice(),
                        television.getOriginalStock() - television.getSold(),
                        television.getSold()
                ))
                .collect(Collectors.toList());

    }



}
