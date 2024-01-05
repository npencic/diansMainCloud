package mk.ukim.finki.diansproekt.service;

import mk.ukim.finki.diansproekt.model.User;

public interface AuthService {
    User login(String username, String password);
    User register(String username,String password, String repeatPassword,String name,String surname);
}
