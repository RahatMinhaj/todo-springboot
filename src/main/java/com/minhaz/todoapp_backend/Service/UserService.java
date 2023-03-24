package com.minhaz.todoapp_backend.Service;

import com.minhaz.todoapp_backend.Entity.Users;
import com.minhaz.todoapp_backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserService{

    @Autowired
    UserRepository userRepo;

    public void initRoleAndUser() {

        System.out.println("=============================================I am called");
        Users normalUser = new Users();
        normalUser.setUserName("user1");
        normalUser.setUserPass("userPass");
        normalUser.setUserRole("user");
        userRepo.save(normalUser);
        System.out.println("print confirm");

        Users adminUser = new Users();
        adminUser.setUserName("Admin");
        adminUser.setUserPass("AdminPass");
        adminUser.setUserRole("admin");


        userRepo.save(adminUser);

    }

    public Users checkLogin(String userName, String userPass) {
        Users user = userRepo.findByUserNameAndUserPass(userName, userPass);
        if(user != null){
        return user;
        }else{
            return null;
        }
    }



//    public Users loginChecks(Users user) {
//        Users usersss = userRepo.findByUser_name(user.getUser_name());
//        System.out.println(usersss);
//
//        return null;
//
////        if(!user.getUser_name().equals(null)){
////
////        }
////
////        return null;
//
//    }
}
