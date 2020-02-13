package br.com.fiap.library.service;

import br.com.fiap.library.dto.AuthDTO;
import br.com.fiap.library.dto.CreateUserDTO;
import br.com.fiap.library.dto.JwtDTO;
import br.com.fiap.library.dto.UsertDTO;

public interface UserService {

    JwtDTO login(AuthDTO authDTO);
    UsertDTO create(CreateUserDTO createUserDTO);

}
