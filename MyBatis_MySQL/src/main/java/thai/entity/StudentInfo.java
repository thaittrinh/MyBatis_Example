package thai.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentInfo {

	private Integer id;
	
	private Integer studentId;
	
	private String address;
	
	private Double average;
	
	private Date birthday;
	
}
