package com.example.appbackend.repository;

import com.example.appbackend.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {
    @Query(value = "select * from users where departement_id=:id",nativeQuery = true)
    List<Users>findAllUsersByDepartementId(@Param("id")Long id);

    @Query(value = "SELECT u.* FROM task AS t\n" +
            "    join users AS u ON t.user_id=u.id\n" +
            "    WHERE t.project_id=:id",nativeQuery = true)
    List<Users>findAllUsersByProjectId(@Param("id")Long id);

}
