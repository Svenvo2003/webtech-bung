package htw.webtech.backend.repository;

import htw.webtech.backend.entity.User;  // WICHTIG: User importieren
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {



}