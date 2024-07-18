package com.HuyEndy.webphimbackend.repository;

import com.HuyEndy.webphimbackend.dto.UserRegistrationCountByMonthDTO;
import com.HuyEndy.webphimbackend.dto.UserStatisticsDTO;
import com.HuyEndy.webphimbackend.model.User;
import com.HuyEndy.webphimbackend.respone.MessageRespone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);

    @Query("SELECT new com.HuyEndy.webphimbackend.dto.UserStatisticsDTO(u.createdAt, COUNT(u)) " +
            "FROM User u " +
            "WHERE u.createdAt = :today " +
            "GROUP BY u.createdAt")
//            "ORDER BY DATE(u.createdAt)")
    UserStatisticsDTO countUsersCreateByDate(@Param("today") LocalDate today);

    @Query("SELECT new com.HuyEndy.webphimbackend.dto.UserRegistrationCountByMonthDTO(MONTH(u.createdAt), COUNT(u)) FROM User u GROUP BY MONTH(u.createdAt)")
    List<UserRegistrationCountByMonthDTO> findCountUserRegistrationCountByMonth();

    @Query("SELECT COUNT(u) FROM User u ")
    int totalCountUser();
}
