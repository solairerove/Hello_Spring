package lych.helloworld.service;

import lych.helloworld.model.User;

import java.util.List;

public interface UserService {

    User addUser(final User user);

    User updateUser(final User user);

    void removeUser(final Integer id);

    User getUserByUsername(final String username);

    List<User> listUsers();
}
