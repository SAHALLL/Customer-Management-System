package com.sahal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sahal.model.UserInfo;

@Repository
public interface UseraddRepo extends JpaRepository<UserInfo, Long>{

}
