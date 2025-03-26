package com.muj_unity_fest_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muj_unity_fest_backend.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Integer>{

}
