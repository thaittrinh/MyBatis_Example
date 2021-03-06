package thai.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;

public class MyBatisUtil {

	private static SqlSessionFactory sessionFactory;
	
	static {
		Reader reader;
		try {
			reader = Resources.getResourceAsReader("thai/resources/mybatis_config.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sessionFactory;
	}
	
}
