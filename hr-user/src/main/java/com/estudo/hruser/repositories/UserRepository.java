package com.estudo.hruser.repositories;

import com.estudo.hruser.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    //forma curso
    User findByEmail(String email);

    //forma Edu <3
    @Query(nativeQuery = true, value = "SELECT e.* FROM TB_USER e WHERE e.email =:email ")
    User getByEmail(@Param("email") String email);
}
