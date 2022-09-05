package com.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.entity.DAOUser;

@Repository
public interface UserDaoRepository extends JpaRepository<DAOUser, Long> {
	DAOUser findByUsername(String username);
}
