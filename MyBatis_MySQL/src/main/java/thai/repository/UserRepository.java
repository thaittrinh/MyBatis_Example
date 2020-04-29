package thai.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import thai.entity.User;
import thai.util.MyBatisUtil;

@Repository
public class UserRepository {

	public List<User> finllAll(){
		
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<User> users = session.selectList("selectAllUser");
		session.commit();
		session.close();
		return users;	
	}
}