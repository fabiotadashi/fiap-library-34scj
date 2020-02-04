package br.com.fiap.library.service.impl;

import br.com.fiap.library.dto.AuthDTO;
import br.com.fiap.library.dto.CreateUserDTO;
import br.com.fiap.library.dto.JwtDTO;
import br.com.fiap.library.dto.UserDTO;
import br.com.fiap.library.entity.User;
import br.com.fiap.library.repository.UserRepository;
import br.com.fiap.library.security.JwtToken;
import br.com.fiap.library.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final AuthenticationManager authenticationManager;
    private final JwtToken jwtToken;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserServiceImpl(AuthenticationManager authenticationManager, JwtToken jwtToken, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtToken = jwtToken;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public JwtDTO login(AuthDTO authDTO) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                                                                    authDTO.getUsername(),
                                                                    authDTO.getPassword())
                                                    );
        } catch (DisabledException e) {
            throw new Exception("User Disabled", e);
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid Credentials", e);
        }

        final String token = jwtToken.generateToken(authDTO.getUsername());

        JwtDTO jwtDTO = new JwtDTO();
        jwtDTO.setToken(token);

        return jwtDTO;
    }

    @Override
    public UserDTO create(CreateUserDTO createUserDTO) {
        User user = new User();
        user.setUsername(createUserDTO.getUsername());
        user.setPassword(passwordEncoder.encode(createUserDTO.getPassword()));
        User savedUser = userRepository.save(user);
        return new UserDTO(savedUser);
    }

}
