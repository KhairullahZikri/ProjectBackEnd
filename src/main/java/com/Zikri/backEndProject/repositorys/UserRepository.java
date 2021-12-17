package com.Zikri.backEndProject.repositorys;

import com.Zikri.backEndProject.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
