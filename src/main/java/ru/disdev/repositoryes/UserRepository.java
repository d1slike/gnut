package ru.disdev.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.disdev.model.users.RegisteredUser;

/**
 * Created by Dislike on 28.06.2016.
 */
public interface UserRepository extends JpaRepository<RegisteredUser, Integer> {

}
