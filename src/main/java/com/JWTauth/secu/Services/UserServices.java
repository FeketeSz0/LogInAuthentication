package com.JWTauth.secu.Services;

import com.JWTauth.secu.Modells.AppUser;
import com.JWTauth.secu.Modells.Role;
import com.JWTauth.secu.Repository.UserRepo;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserServices implements  IUserService{
    private final UserRepo userRepo;

    private final BCryptPasswordEncoder passwordEncoder;

    public UserServices(UserRepo userRepo, BCryptPasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = userRepo.findbyName(username);
        if (appUser == null) {

            throw new UsernameNotFoundException("not found");
        }
        Collection<SimpleGrantedAuthority> authorizies = new ArrayList<>();
        return new User(
                appUser.getUsername(),appUser.getPassword(), authorizies
        );
    }
    @Override
    public AppUser saveUser(AppUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.addUser(user);
        return user;
    }



    @Override
    public void addRoletoUser(String username, Role roleName) {
            var result = getUser(username);
            result.setRole(roleName);
    }


    @Override
    public AppUser getUser(String username) {
        return userRepo.findbyName(username);

    }

    @Override
    public List<AppUser> getUsers() {
       return userRepo.getAppUsers();
    }


}
