package com.HuyEndy.webphimbackend.controller.user;

import com.HuyEndy.webphimbackend.dto.UserRegistrationCountByMonthDTO;
import com.HuyEndy.webphimbackend.dto.UserStatisticsDTO;
import com.HuyEndy.webphimbackend.model.User;
import com.HuyEndy.webphimbackend.respone.CountRespone;
import com.HuyEndy.webphimbackend.respone.MessageRespone;
import com.HuyEndy.webphimbackend.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/profile")
    public ResponseEntity<User> findUserByJwtToken(@RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/admin/user-statistics")
    public UserStatisticsDTO getUserStatistics(@RequestHeader("Authorization") String jwt,
                                                        @RequestParam("today") LocalDate today) {

//        LocalDate startDate = LocalDate.parse(startDateStr.replace("\"", ""));
//        LocalDate endDate = LocalDate.parse(endDateStr.replace("\"", ""));
        return userService.getUserStatistics(today);
    }

    @GetMapping("/admin/registration-count-by-month")
    public List<UserRegistrationCountByMonthDTO> getUserRegistrationCountByMonth(@RequestHeader("Authorization") String jwt) throws Exception {
        return userService.getUserRegistrationCountByMonth();
    }

    @GetMapping("/admin/total-user")
    public CountRespone getTotalCountUsers(@RequestHeader("Authorization") String jwt) throws Exception {
        CountRespone countRespone = new CountRespone();
        countRespone.setCount(userService.getTotalCountUsers());
        return countRespone;
    }


}

