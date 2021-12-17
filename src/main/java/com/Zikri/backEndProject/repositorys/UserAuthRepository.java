package com.Zikri.backEndProject.repositorys;

import com.Zikri.backEndProject.models.auth.UserAuth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserAuthRepository extends JpaRepository<UserAuth, Long> {

    public UserAuth getUserByUsername(@Param("username") String username);

}
