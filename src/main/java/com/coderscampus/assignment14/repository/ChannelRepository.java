package com.coderscampus.assignment14.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.coderscampus.assignment14.dto.Channel;

@Component
public class ChannelRepository {
	private List<Channel> channels = new ArrayList<>();
	private Long id = 2L;
	
	public ChannelRepository () {
		Channel general = new Channel();
		general.setChannelId(1L);
		general.setName("General");
		
		channels.add(general);
	}
	
		public Channel newChannel (String name) {
			
			Channel newChannel = new Channel();
			newChannel.setChannelId(id);
			newChannel.setName(name);
			channels.add(newChannel);
			id++;
			return newChannel;
		}
		
	
	public Optional<Channel> findById (Long channelId) {
		return channels.stream()
					   .filter(channel -> channel.getChannelId().equals(channelId))
					   .findAny();
	}
	public List<Channel> findAll() {
		return channels;
	}
}
