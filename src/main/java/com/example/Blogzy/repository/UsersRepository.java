package com.example.Blogzy.repository;

import com.example.Blogzy.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {

//    User findByEmail(String authenticatedEmail);

}
