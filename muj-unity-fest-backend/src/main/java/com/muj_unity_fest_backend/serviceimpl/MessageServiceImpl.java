package com.muj_unity_fest_backend.serviceimpl;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.muj_unity_fest_backend.dto.MessageDto;
import com.muj_unity_fest_backend.entity.Message;
import com.muj_unity_fest_backend.exception.CustomBasedException;
import com.muj_unity_fest_backend.exception.CustomMadeException;
import com.muj_unity_fest_backend.mapper.MessageMapper;
import com.muj_unity_fest_backend.repository.MessageRepository;
import com.muj_unity_fest_backend.service.MessageService;

import jakarta.mail.internet.MimeMessage;
@Service
public class MessageServiceImpl implements MessageService{

	private MessageRepository messageRepository;
	private JavaMailSender javaMailSender;
	MessageMapper messageMapper = new MessageMapper();

	private Logger LOGGER = Logger.getLogger(getClass().getName());
	@Autowired
	public MessageServiceImpl(MessageRepository messageRepository, JavaMailSender javaMailSender) {
		super();
		this.messageRepository = messageRepository;
		this.javaMailSender = javaMailSender;
	}

	@Transactional
	@Override
	public MessageDto saveMessage(MessageDto messsageDto) throws CustomBasedException {
		
		Message message = messageMapper.mapToMessage(messsageDto);
		System.out.println(message.toString());
		Message savedMessage = messageRepository.save(message);
		String subject = "Contact Us Email";
		String messages = "Dear "+messsageDto.getName()+",<br>  You have submitted your questions successfully to MUJ Unity Fest 2025 Committee team. Someone will contact you within the next 24 hours about your query.";
		sendEmail(message, subject, messages);
		LOGGER.info("Executing the saveMessage component in the MessageService class");
		  if(savedMessage !=null) { MessageDto messageDto =
		  messageMapper.mapToMessageDto(savedMessage); return messageDto; }else {
			  
			  throw
		  new CustomBasedException("Oops! Some error has occured"); }
		
		
	}

	@Override
	public void sendEmail(Message messageDto,String subject,String message) {
		String from = "suman.talukdar53@gmail.com";
		String to = messageDto.getEmail();
		Assert.notNull(to, "Recipient email must not be null");
	    if (to.trim().isEmpty()) {
	        throw new IllegalArgumentException("Recipient email must not be empty");
	    }
		try {
			MimeMessage msg = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg);
			helper.setFrom(from, "MujUnityFest 2025");
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(message,true);
			javaMailSender.send(msg);
			LOGGER.info("Executing the sendEmail component in the MessageService class");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MessageDto> getAllMessage() {
		List<Message> list = messageRepository.findAll();
		LOGGER.info("Executing the getAllMessage component in the MessageService class");
		return list.stream().map((l) -> messageMapper.mapToMessageDto(l)).collect(Collectors.toList());
	}

	@Override
	public MessageDto getMessageById(Integer id) throws CustomMadeException {
		Message message = messageRepository.findById(id).get();
		LOGGER.info("Executing the getMessageById component in the MessageService class");
		if(message!=null) {
			MessageDto getMessageDto = messageMapper.mapToMessageDto(message);
			
			return getMessageDto;
		}else {
			throw new CustomMadeException("Message Id not found");
		}
		
	}

	
}
