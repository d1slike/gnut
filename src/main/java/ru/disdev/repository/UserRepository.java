package ru.disdev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.disdev.model.users.RegisteredUser;

/**
 * Created by Dislike on 28.06.2016.
 */
@Repository
public interface UserRepository extends JpaRepository<RegisteredUser, Integer> {

}
