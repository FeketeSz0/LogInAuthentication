package com.JWTauth.secu.Services;

import com.JWTauth.secu.Modells.AppUser;
import com.JWTauth.secu.Modells.Role;

import java.util.List;

public interface IUserService {
    AppUser saveUser (AppUser user);
    void addRoletoUser (String username, Role roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers();
}
