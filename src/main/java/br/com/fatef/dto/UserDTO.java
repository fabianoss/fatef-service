package br.com.fatef.dto;

import org.springframework.beans.BeanUtils;

import br.com.fatef.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
