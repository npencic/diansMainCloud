package mk.ukim.finki.diansproekt.repository.impl;

import mk.ukim.finki.diansproekt.bootstrap.DataHolder;
import mk.ukim.finki.diansproekt.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl {
    public Optional<User> findByUsername(String username)
    {
        return DataHolder.users.stream().filter(r->r.getUsername().equals(username)).findFirst();
    }
    public Optional<User> findByUsernameAndPassword(String username,String password)
    {
        return DataHolder.users.stream().filter((r->r.getUsername().equals(username) && r.getPassword().equals(password))).findFirst();
    }
    public User saveOrUpdate(User user)
    {
        DataHolder.users.removeIf(r->r.getUsername().equals(user.getUsername()));
        DataHolder.users.add(user);
        return user;
    }

    public void delete(String username)
    {
        DataHolder.users.removeIf(r->r.getUsername().equals(username));
    }

}
