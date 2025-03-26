package com.muj_unity_fest_backend.mapper;

import com.muj_unity_fest_backend.dto.MessageDto;
import com.muj_unity_fest_backend.entity.Message;

public class MessageMapper {

	public Message mapToMessage(MessageDto messageDto) {
		Message message =new Message(
				messageDto.getId(),
				messageDto.getName(),
				messageDto.getCity(),
				messageDto.getEmail(),
				messageDto.getMobile(),
				messageDto.getSubject(),
				messageDto.getMessage()
				);
		return message;
	}
	
	public MessageDto mapToMessageDto(Message message) {
		MessageDto messageDto = new MessageDto(
				message.getId(),
				message.getName(),
				message.getCity(),
				message.getEmail(),
				message.getMobile(),
				message.getSubject(),
				message.getMessage());
		return messageDto;
	}
}
