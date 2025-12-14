package dk.projekt.alphaprojecttool.service;

import dk.projekt.alphaprojecttool.model.User;

public interface UserService {
    User findByUsername(String username);
}
