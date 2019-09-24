

package com.jypt.dao;

import java.util.List;

import com.jypt.model.User;



public interface UserDao {
 public abstract    User   login(User user);
 public abstract    List<User>   selectUserList();
 public abstract   int   removeUserById(int id);
 public abstract   int  registerUser(User user);
 public abstract  User   selectUserById(User user);
 public abstract  int editUser(User user);
}
