package com.muj_unity_fest_backend.service;

import java.util.List;

import com.muj_unity_fest_backend.dto.MessageDto;
import com.muj_unity_fest_backend.entity.Message;
import com.muj_unity_fest_backend.exception.CustomBasedException;
import com.muj_unity_fest_backend.exception.CustomMadeException;

public interface MessageService {

	public MessageDto saveMessage(MessageDto messsageDto) throws CustomBasedException;
	
	public void sendEmail(Message messageDto,String subject,String message);
	
	public List<MessageDto> getAllMessage();
	
	public MessageDto getMessageById(Integer id) throws CustomMadeException;
}
