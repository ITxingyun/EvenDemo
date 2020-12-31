package com.xingyun.architecture.ddd;

import com.xingyun.architecture.ddd.dp.Address;
import com.xingyun.architecture.ddd.dp.Name;
import com.xingyun.architecture.ddd.dp.PhoneNumber;

import org.jetbrains.annotations.NotNull;

public interface RegistrationService {
	User register(@NotNull Name name, @NotNull PhoneNumber phone, @NotNull Address address);
}
