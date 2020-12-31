package com.xingyun.architecture.ddd;

import com.xingyun.architecture.ddd.dp.Address;
import com.xingyun.architecture.ddd.dp.Name;
import com.xingyun.architecture.ddd.dp.PhoneNumber;

import org.jetbrains.annotations.NotNull;

public class RegistrationServiceImpl implements RegistrationService {
    private UserRepository userRepo;

    public RegistrationServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User register(@NotNull Name name, @NotNull PhoneNumber phone, @NotNull Address address) {
        User user = new User(name, phone, address);
        return userRepo.createUser(user);
    }
}
