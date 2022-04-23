package com.coderscampus.assignment14.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment14.dto.Channel;
import com.coderscampus.assignment14.dto.Message;
import com.coderscampus.assignment14.repository.ChannelRepository;
import com.coderscampus.assignment14.repository.MessageRepository;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepo;
	@Autowired
	private ChannelRepository channelRepo;
	
	public List<Message> getMessagesByChannel (Long channelId) {
		return messageRepo.findMessagesByChannel(channelId).orElse(new ArrayList<>());
	}

	public void addMessageToChannel(Message message) {
		Optional<Channel> channelOpt = channelRepo.findById(message.getChannelId());
		if (channelOpt.isPresent()) {
			List<Message> messagesByChannel = getMessagesByChannel(message.getChannelId());
			messagesByChannel.add(message);
			messageRepo.saveMessagesByChannel(message.getChannelId(), messagesByChannel);
		}
	}
}
