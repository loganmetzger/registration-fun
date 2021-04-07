package com.logan.registration2.ui.main;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class UserViewModel extends ViewModel {

    ArrayList<User> allUsersList = new ArrayList<>();

    public void createUser(@NonNull String name, @NonNull String email, @NonNull String username, @NonNull String password) {
        User newUser = new User();

        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setUsername(username);
        newUser.setPassword(password);

        allUsersList.add(newUser);
    }

    public ArrayList<User> getAllUsersList() {
        return allUsersList;
    }
}