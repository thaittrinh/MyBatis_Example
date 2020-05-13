package thai.dto;




import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

	private int id;
	
	private String name;
	
	private String code;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date birthday;
	
	private String address;
	
	private double average;
	
}
