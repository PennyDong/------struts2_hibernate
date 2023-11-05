package dao.impl;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import dao.DbConnection;
import dao.voteDao;
import entity.member;

public class memberDaoImpl implements voteDao {

	public static void main(String[] args) {
		
		//List<member> vote = new memberDaoImpl().queryAll();
		//vote.stream().forEach(x->System.out.println(x));
		
		new memberDaoImpl().updateVote(1);
		
		//new memberDaoImpl().updateVote(1);
		
	}

	@Override
	public List<member> queryAll() {
		
		Session se = DbConnection.getDb();
		String SQL = "select * from member";
		NativeQuery nq = se.createNativeQuery(SQL, member.class);
		List<member> voteList = nq.getResultList();
		
		return voteList;
	}

	@Override
	public void updateVote(Integer id) {
		
		Session se = DbConnection.getDb();
		Transaction t =se.beginTransaction();
		String SQL = "update member set quantity=quantity+1 where id=?1";
		NativeQuery nq = se.createNativeQuery(SQL, member.class);
		nq.setParameter(1, id);
		nq.executeUpdate();
		t.commit();
		se.close();
		
		
		}
		
	

	@Override
	public member queryId(Integer id) {
		
		Session se = DbConnection.getDb();
		String SQL = "select * from member where id=?1";
		NativeQuery nq = se.createNativeQuery(SQL, member.class);
		nq.setParameter(1, id);
		member m =(member) nq.uniqueResult();
		
		return m;
	}

}
