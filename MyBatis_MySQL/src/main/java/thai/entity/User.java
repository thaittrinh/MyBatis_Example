package thai.entity;


import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private Integer id;

	@NotBlank(message = "The name is not null")//of hibernate
	@Size(max = 20, message = "Over 20 characters")
	@Pattern(regexp = "[a-zA-Z0-9]+", message = "The name does not contain special characters")
	private String name;

	@Size(min = 6, max = 20, message = "The length from 6 to 20 characters")
	private String password;

}
