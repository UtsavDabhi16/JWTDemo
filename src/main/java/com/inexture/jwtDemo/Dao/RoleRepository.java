package com.inexture.jwtDemo.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inexture.jwtDemo.Model.Role;
import com.inexture.jwtDemo.Model.Roles;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	Optional<Role> findByRoleName(Roles role);
}
