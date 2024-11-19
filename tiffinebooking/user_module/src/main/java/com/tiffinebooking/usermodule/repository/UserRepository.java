package com.tiffinebooking.usermodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiffinebooking.usermodule.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

}
