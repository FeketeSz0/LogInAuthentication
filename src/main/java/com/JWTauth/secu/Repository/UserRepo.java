package com.JWTauth.secu.Repository;

import com.JWTauth.secu.Modells.AppUser;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepo {
    private final static ArrayList<AppUser> users = new ArrayList<>(
            List.of(new AppUser())
    );

   public AppUser findbyName(String name){
        return (AppUser) users.stream().filter(appUser -> appUser.getUsername().equals(name));
    }

    public List<AppUser> getAppUsers(){
       return users;
    }
    public void addUser(AppUser appUser){
       users.add(appUser);
    }






}
