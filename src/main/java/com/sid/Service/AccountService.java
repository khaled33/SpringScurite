package com.sid.Service;

import com.sid.entity.Role;
import com.sid.entity.Users;

public interface AccountService {
    public Users saveUser(Users users);
    public Role saveRole(Role role);
    public void addRoleToUser(String userame,String  rolename);
    public Users findUserByUsername(String username);

}
