package com.muj_unity_fest_backend.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muj_unity_fest_backend.dto.MessageDto;
import com.muj_unity_fest_backend.service.MessageService;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("mujunityfest")
public class MessageController {

	private MessageService messageService;

	private Logger LOGGER = Logger.getLogger(getClass().getName());
	@Autowired
	public MessageController(MessageService messageService) {
		super();
		this.messageService = messageService;
	}
	@PostMapping("saveMessage")
	public ResponseEntity<MessageDto> saveMessage(@RequestBody @Valid MessageDto messageDto){
		MessageDto savedMessageDto = new MessageDto();
		try {
			savedMessageDto = messageService.saveMessage(messageDto);
			LOGGER.info("Executing the saveMessage component in the MessageController class");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ResponseEntity.ok(savedMessageDto);
	}
	@GetMapping("getList")
	public ResponseEntity<List<MessageDto>> getAllList(){
		List<MessageDto> getAll = messageService.getAllMessage();
		LOGGER.info("Executing the getAll List component in the MessageController class");
		return ResponseEntity.ok(getAll);
		
	}
	@GetMapping("getList/{id}")
	public ResponseEntity<MessageDto> getMessageById(@PathVariable("id") Integer id){
		MessageDto messageDto=null;
		try {
			LOGGER.info("Executing the get Message By Id component in the MessageController class");
		messageDto = messageService.getMessageById(id);
	} catch (Exception e) {
		e.printStackTrace();
	}	
	return ResponseEntity.ok(messageDto);
	}
}
