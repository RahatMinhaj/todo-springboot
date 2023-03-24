package com.minhaz.todoapp_backend.Repository;

import com.minhaz.todoapp_backend.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByUserNameAndUserPass(String userName, String userPass);
}
