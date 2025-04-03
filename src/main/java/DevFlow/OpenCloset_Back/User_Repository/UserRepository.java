package DevFlow.OpenCloset_Back.User_Repository;

import DevFlow.OpenCloset_Back.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    //Optional<User> findByAddress(String address);
}
