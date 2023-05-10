package br.com.fatef.dto;

import org.springframework.beans.BeanUtils;

import br.com.fatef.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long idUser;
    private String name;
    private Integer idade;

    public static UserDTO mapper(User entity) {
	var result = UserDTO.builder().build();
	BeanUtils.copyProperties(entity, result);
	return result;
    }
}
