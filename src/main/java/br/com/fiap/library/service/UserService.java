package br.com.fiap.library.service;

import br.com.fiap.library.dto.AuthDTO;
import br.com.fiap.library.dto.CreateUserDTO;
import br.com.fiap.library.dto.JwtDTO;
import br.com.fiap.library.dto.UserDTO;

public interface UserService {

    JwtDTO login(AuthDTO authDTO) throws Exception;
    UserDTO create(CreateUserDTO createUserDTO);

}
