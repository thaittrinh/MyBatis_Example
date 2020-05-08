package thai.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import thai.dto.PageDTO;
import thai.dto.StudentDTO;
import thai.util.MyBatisUtil;

@Repository
public class StudentDetailRepository {

	SqlSession session;

	public List<StudentDTO> findALL(PageDTO pageDTO) {
		List<StudentDTO> StudentDTOs;

		try {

			session = MyBatisUtil.getSqlSessionFactory().openSession();
			StudentDTOs = session.selectList("StudentDetail.selectStudentDetail", pageDTO);
			session.commit();
		} catch (Exception e) {
			StudentDTOs = null;
			e.printStackTrace();
		} finally {

			session.close();
		}
			
		return StudentDTOs;
	}

	
	public int totalStudent(PageDTO pageDTO) {
		
		int row;
		
		try {
			session = MyBatisUtil.getSqlSessionFactory().openSession();
			row = session.selectOne("StudentDetail.countRow",pageDTO);
			session.commit();
		} catch (Exception e) {
			row = 0;
			e.printStackTrace();
		} finally {

			session.close();
		}
		
		return row;
	}
}
