package org.nath9i.pp3_1_2.dao;

import org.nath9i.pp3_1_2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
