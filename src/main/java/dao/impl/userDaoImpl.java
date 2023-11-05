package dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import dao.DbConnection;
import dao.userDao;
import entity.user;

public class userDaoImpl implements userDao {

	public static void main(String[] args) {
		
//		user u = new user("cat","joo","789");
//		new userDaoImpl().addUser(u);
		
		List<user> userList = new userDaoImpl().userList();
		userList.stream().forEach(x -> System.out.println(x));
//		
//		user u =  new userDaoImpl().queryUser("poo", "123");
//		System.out.println(u);
////	
//		boolean x =new userDaoImpl().queryUsername("poo");
//		System.out.println(x);
	}
	@Override
	public void addUser(user user) {
		
		Session se = DbConnection.getDb();
		Transaction t =se.beginTransaction();
		se.save(user);
		t.commit();
		
		
		
	}

	@Override
	public List<user> userList() {
		
		Session se = DbConnection.getDb();
		String SQL = "select * from user";
		NativeQuery na = se.createNativeQuery(SQL,user.class);
		List<user> listUser = na.getResultList();
		
		return listUser;
	}

	@Override
	public user queryUser(String username, String password) {
		
		Session se = DbConnection.getDb();
		String SQL ="select * from user where username=?1 and password=?2";
		NativeQuery nq = se.createNativeQuery(SQL,user.class);
		nq.setParameter(1, username);
		nq.setParameter(2, password);
		
		user u =(user) nq.uniqueResult();
		
		return u;
	}

	@Override
	public boolean queryUsername(String username) {
		
		Session se = DbConnection.getDb();
		String SQL = "select * from user where username=?1";
		NativeQuery nq = se.createNativeQuery(SQL,user.class);
		nq.setParameter(1, username);
		
		user x = (user) nq.uniqueResult();
		
		if(x!=null) {
			return true;
		}else {
			return false;
		}
		
		
	}

}
