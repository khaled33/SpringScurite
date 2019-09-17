package com.sid.Dao;

import com.sid.entity.Role;
import com.sid.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    public Role findByRoleName(String rolename);
}
