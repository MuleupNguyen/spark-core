package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    List<User> users;
    public UserServiceImpl() {
        this.users = new ArrayList<>();
    }
    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public Collection<User> getUsers() {
        return users.stream().collect(Collectors.toList());
    }

    @Override
    public Optional<User> getUser(String id) {
        return users.stream()
                .filter( e -> e.getId().equals(id))
                .findFirst();
    }

    @Override
    public User editUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public boolean userExist(String id) {
        return false;
    }
}
