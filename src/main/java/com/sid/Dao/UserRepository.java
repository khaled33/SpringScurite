package com.sid.Dao;

import com.sid.entity.Task;
import com.sid.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> {
public Users findByUsername(String username);
}
