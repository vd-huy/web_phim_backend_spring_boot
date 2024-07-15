package com.HuyEndy.webphimbackend.controller.user;

import com.HuyEndy.webphimbackend.config.JwtProvider;
import com.HuyEndy.webphimbackend.model.USER_ROLE;
import com.HuyEndy.webphimbackend.model.User;
import com.HuyEndy.webphimbackend.repository.UserRepository;
import com.HuyEndy.webphimbackend.request.LoginRequest;
import com.HuyEndy.webphimbackend.respone.AuthRespone;
import com.HuyEndy.webphimbackend.respone.MessageRespone;
import com.HuyEndy.webphimbackend.service.user.CustomerUserDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private CustomerUserDetailService customerUserDetailService;


    @PostMapping("/signup")
    public ResponseEntity<AuthRespone> createUserHandle(@RequestBody User user) throws Exception {

        User isEmailExits = userRepository.findByEmail(user.getEmail());
        if (isEmailExits!=null){
            throw new Exception("Email is  already used");
        }

        User createdUser = new User();
        createdUser.setEmail(user.getEmail());
        createdUser.setFullName(user.getFullName());
        createdUser.setRole(user.getRole());
        createdUser.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = userRepository.save(createdUser);


        Authentication authentication = new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateToken(authentication);

        AuthRespone authRespone = new AuthRespone();
        authRespone.setJwt(jwt);
        authRespone.setMessage("Register success");
        authRespone.setRole(savedUser.getRole());

        return new ResponseEntity<>(authRespone, HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthRespone> signin(@RequestBody LoginRequest request){

            String email = request.getEmail();
            String password = request.getPassword();


            Authentication authentication = authenticate(email, password);

            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            String role = authorities.isEmpty() ? null : authorities.iterator().next().getAuthority();

            String jwt = jwtProvider.generateToken(authentication);

            AuthRespone authRespone = new AuthRespone();
            authRespone.setJwt(jwt);
            authRespone.setMessage("Login success");

            authRespone.setRole(USER_ROLE.valueOf(role));

            return new ResponseEntity<>(authRespone, HttpStatus.OK);



    }

    private Authentication authenticate(String email, String password) {
        UserDetails userDetails = customerUserDetailService.loadUserByUsername(email);
        if (userDetails == null){
            throw new BadCredentialsException("Invalid email,...");
        }
        if (!passwordEncoder.matches(password,userDetails.getPassword())){
            throw new BadCredentialsException("Invalid password...");
        }

        return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
    }
}
