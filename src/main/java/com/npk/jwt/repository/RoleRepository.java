package com.npk.jwt.repository;

import com.npk.jwt.model.Role;
import com.npk.jwt.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleName roleName);
}
