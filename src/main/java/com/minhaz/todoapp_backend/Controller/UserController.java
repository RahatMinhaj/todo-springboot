package com.minhaz.todoapp_backend.Controller;

import com.minhaz.todoapp_backend.Entity.Users;
import com.minhaz.todoapp_backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@CrossOrigin(origins = "http://localhost:4200" , allowedHeaders = "*")
@RequestMapping("/todoapp")
public class UserController {

    @Autowired
    UserService userService;

    @PostConstruct
    public void InitUser() {
        userService.initRoleAndUser();
    }


    @PostMapping("/login")
    public ResponseEntity<Users> logincheck(@RequestBody Users user){
        String userName = user.getUserName();
        String pass = user.getUserPass();

        Users loginchk = userService.checkLogin(userName,pass);

        if(loginchk!= null){
            System.out.println(loginchk.getUserRole());
            return ResponseEntity.ok(loginchk);
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
