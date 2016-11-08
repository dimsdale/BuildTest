package ua.sdo.service;

import ua.sdo.model.User;

public interface UserService {

    User getUser(String login);

    void createUser(User user);
}
