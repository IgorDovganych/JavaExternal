package com.droid.war.users;

import com.droid.war.model.User;
import com.droid.war.model.UserRole;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserProvider implements UserProvider {

    private static final InMemoryUserProvider IN_MEMORY_USER_PROVIDER = new InMemoryUserProvider();

    public static InMemoryUserProvider getInstance() {
        return IN_MEMORY_USER_PROVIDER;
    }

    private Map<String, User> userByUserName = new HashMap<>();

    {
        createUser(new User("Igor", "aaa", UserRole.ADMIN));
        createUser(new User("User", "pass", UserRole.USER));
    }

    @Override
    public User getUserByName(String name) {
        return userByUserName.get(name);
    }

    @Override
    public boolean createUser(User user) {
        return userByUserName.putIfAbsent(user.getUserName(), user) == null;
    }
}
