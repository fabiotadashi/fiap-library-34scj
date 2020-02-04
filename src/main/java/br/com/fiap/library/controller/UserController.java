package br.com.fiap.library.controller;

import br.com.fiap.library.dto.AuthDTO;
import br.com.fiap.library.dto.CreateUserDTO;
import br.com.fiap.library.dto.JwtDTO;
import br.com.fiap.library.dto.UserDTO;
import br.com.fiap.library.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

	private final UserService service;

	public UserController(UserService service) {
		this.service = service;
	}

	@PostMapping(value = "/login")
	public JwtDTO login(@RequestBody AuthDTO authDTO) throws Exception {
		return service.login(authDTO);
	}

	@PostMapping
	public UserDTO create(@RequestBody CreateUserDTO createUserDTO) {
		return service.create(createUserDTO);
	}


}