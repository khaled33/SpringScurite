package com.sid.Controller;

import com.sid.Service.AccountService;
import com.sid.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestController {

    @Autowired
    private AccountService accountService;
@PostMapping("/register")
    public Users Rejister(@RequestBody Users users){
        return accountService.saveUser(users);
    }

}
