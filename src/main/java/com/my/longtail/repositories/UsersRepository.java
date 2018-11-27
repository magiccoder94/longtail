package com.my.longtail.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.longtail.model.Users;

@Repository("usersRepository")
public interface UsersRepository extends JpaRepository<Users, Long>{
	Users findByUsername(String username);
}
