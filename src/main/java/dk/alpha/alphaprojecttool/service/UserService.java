package dk.alpha.alphaprojecttool.service;

import dk.alpha.alphaprojecttool.model.User;

public interface UserService {
    User findByUsername(String username);
}
