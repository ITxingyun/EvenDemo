package com.xingyun.architecture.ddd;

import com.xingyun.architecture.ddd.dp.Address;
import com.xingyun.architecture.ddd.dp.Name;
import com.xingyun.architecture.ddd.dp.PhoneNumber;

public class User {
	private int id;
	private Name name;
	private PhoneNumber phoneNumber;
	private Address address;

	public User(Name name, PhoneNumber phoneNumber, Address address) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name=" + name +
				", phoneNumber=" + phoneNumber +
				", address=" + address +
				'}';
	}
}
