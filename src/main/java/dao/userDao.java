package dao;

import java.util.List;

import entity.user;

public interface userDao {
	
	
	//create
	void addUser(user user );
	
	//read
	List<user> userList();
	user queryUser(String username,String password);
	boolean queryUsername(String username);
	
}
