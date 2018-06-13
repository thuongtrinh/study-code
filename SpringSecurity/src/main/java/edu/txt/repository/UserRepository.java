package edu.txt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.txt.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	UserEntity findOneByUserName(String username);
}

