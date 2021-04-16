package tn.esprit.spring.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Notification;
import tn.esprit.spring.service.*;

@RestController
public class NotificationRestControlImpl {
	
	
	@Autowired
	NotificationServiceImpl NotificationServiceImpl ;
	
	// URL: http://localhost:8083/SpringMVC/servlet/retrieve-all-Notification
	@GetMapping("/retrieve-all-Notification")
	@ResponseBody
	public List<Notification>retriveAllNotifications(){
		List<Notification> list = NotificationServiceImpl.retriveAllnotifications();
		return list;
		}
	// URL: http://localhost:8083/SpringMVC/servlet/{id-notification}
		@GetMapping("/{id-notification}")
		@ResponseBody
		public Optional<Notification> retrieveNotification(@PathVariable("id-notification") Long idNotification) {
			return NotificationServiceImpl.retrieveNotification(idNotification);
		}
		
		// URL: http://localhost:8083/SpringMVC/servlet/delete-Notification/{id-notification}
		@DeleteMapping("/delete-Notification/{id-notification}")  
		public String deleteNotification(@PathVariable("id-notification") Long idNotification)   
		{  
			List<Notification>notifications=NotificationServiceImpl.retriveAllnotifications();
			for(Notification n:notifications)
				if(n.getIdNotification()==idNotification){
			NotificationServiceImpl.deleteNotification(idNotification);
			return "Record deleted succesfully";}
			
			return "not existe";
		}
		// URL: http://localhost:8083/SpringMVC/servlet/addNotification
	@PostMapping("/addNotification")  
	public Notification addNotification(@RequestBody Notification n)   
	{  
		NotificationServiceImpl.addNotification(n);
		return n;
	}
	// URL: http://localhost:8083/SpringMVC/servlet/UpdateNotification
	@PutMapping("/UpdateNotification")  
	private  Notification update(@RequestBody Notification n)   
	{  
	NotificationServiceImpl.updateNotification(n);  
	return n;  
	}

}
