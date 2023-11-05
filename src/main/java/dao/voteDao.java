package dao;

import java.util.List;

import entity.member;

public interface voteDao {
	
	//create
	
	//read
	List<member> queryAll();
	member queryId(Integer id);
	
	//update
	void updateVote(Integer i);
	
	
	//delete
}
