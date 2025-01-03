package nl.novi.TIEwebapi.repositories;

import nl.novi.TIEwebapi.models.Television;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TelevisionRepository extends JpaRepository <Television,Long> {

        List<Television> findAllTelevisionsByBrandEqualsIgnoreCase(String brand);
}
