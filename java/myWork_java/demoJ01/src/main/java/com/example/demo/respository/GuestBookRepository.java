package com.example.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.GuestBook;

public interface GuestBookRepository 
					extends JpaRepository<GuestBook, Long> {
}
