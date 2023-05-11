package br.com.fatef.dto;

import javax.validation.constraints.NotNull;

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
public class UserCreateDTO {
    
    @NotNull(message = "O campo name não pode ser nulo!")
    private String name;
    
    @NotNull(message = "O campo idade não pode ser nulo!")
    private Integer idade;

    public static UserCreateDTO mapper(User entity) {
	var result = UserCreateDTO.builder().build();
	BeanUtils.copyProperties(entity, result);
	return result;
    }
}
