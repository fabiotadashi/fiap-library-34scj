package br.com.fiap.library.controller;

import br.com.fiap.library.dto.AuthDTO;
import br.com.fiap.library.dto.CreateUserDTO;
import br.com.fiap.library.dto.JwtDTO;
import br.com.fiap.library.dto.UsertDTO;
import br.com.fiap.library.service.UserService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/login")
    public JwtDTO login(AuthDTO authDTO){
        return userService.login(authDTO);
    }

    @PostMapping
    public UsertDTO create(CreateUserDTO createUserDTO){
        return userService.create(createUserDTO);
    }

}
