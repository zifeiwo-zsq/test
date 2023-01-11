package service;

import entity.Admin;

public interface UserService {
    Admin findUserByEmail(String email);

    Admin findUserById(Long id);

    Integer activeEmail(Admin admin);
}
