package nl.novi.TIEwebapi.repositories;

import nl.novi.TIEwebapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, String > {


}
