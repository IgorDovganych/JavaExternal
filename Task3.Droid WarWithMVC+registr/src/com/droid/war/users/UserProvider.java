package com.droid.war.users;

import com.droid.war.model.User;

public interface UserProvider {
    User getUserByName(String name);

    /**
     * @param user
     * @return true if user was created or false if user with such name already exists
     */
    boolean createUser(User user);
}
