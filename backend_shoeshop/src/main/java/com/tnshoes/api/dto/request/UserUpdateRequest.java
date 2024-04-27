package com.tnshoes.api.dto.request;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {

	@NotNull(message = "Tên bị null!")
    @Pattern(regexp = "[a-zA-Z][a-zA-Z ]+", message = "Tên chứa kí tự cấm!")
    @Length(min = 3, max = 200, message = "Tên phải từ 3 đến 200 kí tự!")
	private String name;

	private String avatar;

	@NotEmpty(message = "Thiếu Email")
	@Email(message = "Email không hợp lệ!")
	private String email;

	@NotEmpty(message = "Thiếu số điện thoại")
    @Pattern(regexp = "/(84|0[3|5|7|8|9])+([0-9]{8})\\b/g", message = "Số điện thoại không hợp lệ!")
	private String phone;

	@NotEmpty(message = "Thiếu password!")
    @Min(value = 8, message = "Password phải từ 8 kí tự trở lên!")
	private String password;
	
	List<String> roles;
}
