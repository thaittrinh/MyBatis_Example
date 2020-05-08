package thai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thai.dto.PageDTO;
import thai.dto.StudentDTO;
import thai.repository.StudentDetailRepository;

@Service
public class StudentDetailService {

	@Autowired
	StudentDetailRepository studentDetailRepository;
	
	public List<StudentDTO> findAll(PageDTO pageDTO){
		
		return studentDetailRepository.findALL(pageDTO);
	}

	public int totalPage(PageDTO pageDTO) {
	
		return (int) Math.ceil((studentDetailRepository.totalStudent(pageDTO)/(pageDTO.getItems()*1.0)));
	}
}
