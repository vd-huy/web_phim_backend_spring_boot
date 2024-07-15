package com.HuyEndy.webphimbackend.service.user;

import com.HuyEndy.webphimbackend.config.JwtProvider;
import com.HuyEndy.webphimbackend.dto.UserRegistrationCountByMonthDTO;
import com.HuyEndy.webphimbackend.dto.UserStatisticsDTO;
import com.HuyEndy.webphimbackend.model.User;
import com.HuyEndy.webphimbackend.repository.UserRepository;
import com.HuyEndy.webphimbackend.respone.MessageRespone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtProvider jwtProvider;

    public User findUserByJwtToken(String jwt) throws Exception {

        String email = jwtProvider.getEmailFromJwtToken(jwt);

        User user = findUserByEmail(email);

        return user;
    }

    public User findUserByEmail(String email) throws Exception {
        User user = userRepository.findByEmail(email);

        if (user == null){
            throw new Exception("User not found");
        }
        return user;
    }

    public UserStatisticsDTO getUserStatistics(LocalDate today) {
        return userRepository.countUsersCreateByDate(today);
    }

    public List<UserRegistrationCountByMonthDTO> getUserRegistrationCountByMonth() {

        return userRepository.findCountUserRegistrationCountByMonth();
    }

    public int getTotalCountUsers() {
        return userRepository.totalCountUser();
    }
}
