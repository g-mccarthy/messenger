package org.glen.mccarthy.messenger.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.glen.mccarthy.messenger.database.DataBaseClass;
import org.glen.mccarthy.messenger.model.Message;

public class MessageService {
	
	Map<Long, Message> messages = DataBaseClass.getMessages();

	public MessageService(){
		messages.put(1l, new Message(1, "Hello World", "Glen"));
		messages.put(2l, new Message(2, "Hello Jersey", "Jason"));
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Message m : messages.values()){
			cal.setTime(m.getCreated());
			if(cal.get(Calendar.YEAR) == year)
				messagesForYear.add(m);
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size){
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if(start + size > list.size()) return new ArrayList<Message>();
		return ((List<Message>) list).subList(start, start + size); 
	}
	
	
	public Message addMessage(Message message){
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(messages.size() <= 0)
			return null;
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id){
		return messages.remove(id);
	}
	
}
