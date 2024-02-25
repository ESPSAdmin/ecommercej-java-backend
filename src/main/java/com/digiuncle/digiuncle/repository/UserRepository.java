package com.digiuncle.digiuncle.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digiuncle.digiuncle.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, UUID>{
	public Users getUserByEmail(String email);
	public Users getUserByMobile(String mobile);
}
