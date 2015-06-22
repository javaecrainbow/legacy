package com.salk.legacy.booking.service;

import com.salk.legacy.domain.User;

public interface UserService {
 void addUser(User user);
 void modifyUser(User user);
 User findUser(String id);
 void deleteUser(String[] ids);
 void queryUsers();
}
