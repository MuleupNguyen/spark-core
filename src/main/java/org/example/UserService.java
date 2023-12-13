package org.example;

import java.util.Collection;
import java.util.Optional;

public interface UserService {

    public void addUser (User user);

    public Collection<User> getUsers ();
    public Optional<User> getUser (String id);

    public User editUser (User user);

    public void deleteUser (String id);

    public boolean userExist (String id);
}
