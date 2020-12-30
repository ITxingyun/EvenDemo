package com.xingyun.architecture.ddd;

public interface RegistrationService {
    User register(String name, String phone, String address) throws ValidationException;
}
