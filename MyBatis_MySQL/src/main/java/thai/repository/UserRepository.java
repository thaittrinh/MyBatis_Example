package thai.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import thai.entity.User;
import thai.util.MyBatisUtil;

@Repository
public class UserRepository {
	
	SqlSession session;
	
	public List<User> findAll(){
	
		List<User> users = null;
		try {
			session = MyBatisUtil.getSqlSessionFactory().openSession();
			users = session.selectList("selectAllUser");
			session.commit();
		} catch (Exception e) {		
			throw new RuntimeException();
		}finally {
			session.close();
		}	session = MyBatisUtil.getSqlSessionFactory().openSession();
		return users;	
	}
	
	//name unique
	public User getOneByName(String name) {
		User user = null;
		try {
			session = MyBatisUtil.getSqlSessionFactory().openSession();
			user = session.selectOne("selectUserByName", name);
			session.commit();
		} catch (Exception e) {
			throw new RuntimeException();
		}finally {
			session.close();
		}
		
		return user;
	}
	
	public boolean insertUser(User user) {
		try {
			session = MyBatisUtil.getSqlSessionFactory().openSession();
			session.insert("insertUser", user);
			session.commit();
			
			return true;
		} catch (Exception e) {
			
			return false;
		}finally {
			
			session.close();
		}
	}
	
	
}
