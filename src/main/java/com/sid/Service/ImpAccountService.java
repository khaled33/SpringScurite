package com.sid.Service;

import com.sid.Dao.RoleRepository;
import com.sid.Dao.UserRepository;
import com.sid.entity.Role;
import com.sid.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ImpAccountService implements AccountService {
    @Autowired
     private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
     private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Users saveUser(Users users) {
        //hashage mot de passe
        String hashPw= bCryptPasswordEncoder.encode(users.getPassword());
        users.setPassword(hashPw);

        return userRepository.save(users);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String userame, String rolename) {
        Role role= roleRepository.findByRoleName(rolename);
        Users users = userRepository.findByUsername(userame);
        users.getRoles().add(role);

    }

    @Override
    public Users findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
