package org.glen.mccarthy.messenger.resources;


import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.glen.mccarthy.messenger.model.Message;
import org.glen.mccarthy.messenger.resources.beans.MessageFilterBean;
import org.glen.mccarthy.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService service = new MessageService();

	@GET
	public List<Message> getMessages(@BeanParam MessageFilterBean bean){
		if(bean.getYear() > 0)
			return service.getAllMessagesForYear(bean.getYear());
		if(bean.getStart() != null && bean.getSize() != null)
			return service.getAllMessagesPaginated(bean.getStart(), bean.getSize());
		return service.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId")long messageId){
		return service.getMessage(messageId);
	}
	
	@POST
	public Message addMessage(Message message){
		return service.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId")long id, Message message){
		message.setId(id);
		return service.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void removeMessage(@PathParam("messageId")long id){
		service.removeMessage(id);
	}
}
