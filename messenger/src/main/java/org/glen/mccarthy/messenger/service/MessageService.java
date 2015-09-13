package org.glen.mccarthy.messenger.service;

import java.util.ArrayList;
import java.util.List;

import org.glen.mccarthy.messenger.model.Message;

public class MessageService {

	public List<Message> getAllMessages(){
		Message m1 = new Message(1, "Hello", "Glen");
		Message m2 = new Message(2, "HI", "Brendan");
		List<Message> list = new ArrayList<Message>();
		list.add(m1);
		list.add(m2);
		return list;
	}
	
}
