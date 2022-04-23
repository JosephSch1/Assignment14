package com.coderscampus.assignment14.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.coderscampus.assignment14.dto.Channel;
import com.coderscampus.assignment14.dto.Message;
import com.coderscampus.assignment14.service.ChannelService;
import com.coderscampus.assignment14.service.MessageService;

@Controller
public class ChannelController {
	
	@Autowired
	private ChannelService channelService;
	@Autowired
	private MessageService messageService;
	
	@GetMapping("/")
	public String welcomeRedirect() {
		return "redirect:/welcome";
	}
	
	@GetMapping("/channels/{channelId}")
	public String getChannel(ModelMap model, @PathVariable Long channelId) {
		Channel channel = channelService.findChannelById(channelId);
		List<Message> messagesByChannel = messageService.getMessagesByChannel(channelId);
		model.put("channel", channel);
		model.put("messages", messagesByChannel);
		
		return "channel";
	}
	
	@GetMapping("/welcome")
	public String getWelcome (ModelMap model) {
		List<Channel> channels = channelService.findAll();
		model.put("channels", channels);
		return "welcome";
	}
}
