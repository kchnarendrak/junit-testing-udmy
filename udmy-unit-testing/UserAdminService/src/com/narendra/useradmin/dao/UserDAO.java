package com.narendra.useradmin.dao;

import com.narendra.useradmin.dto.User;
import com.narendra.useradmin.util.IDGenerator;

public class UserDAO {

	public int create(User user) {
		int id = IDGenerator.generateID();
		//Save the user object to the db
		return id;
	}
}
