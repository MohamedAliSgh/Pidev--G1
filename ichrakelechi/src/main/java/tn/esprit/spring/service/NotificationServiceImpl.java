package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Notification;
import tn.esprit.spring.repository.NotificationRepository;
@Service
public class NotificationServiceImpl implements NotificationService {
	
	@Autowired
	NotificationRepository NotificationRepository;
	private static final Logger l= LogManager.getLogger(NotificationServiceImpl.class);
	@Override
	 public List<Notification> retriveAllnotifications()
	  {
		  List<Notification> notifications =(List<Notification>) NotificationRepository.findAll();
		  
		  for(Notification notification : notifications)
		  {	l.info("Notification +++ :"+notification);	  }
		  return notifications;
		  
	  }
	 @Override
	 public Notification addNotification(Notification n){

			return NotificationRepository.save(n);
		}
	 @Override
	 public void deleteNotification(Long idNotification)
	  {
		 NotificationRepository.deleteById(idNotification); 
	  }
	 @Override
	public Notification updateNotification (Notification n)
	  {   
		 return NotificationRepository.save(n);  
	  }
	 @Override
	 public Optional<Notification> retrieveNotification(Long idNotification) {
			return NotificationRepository.findById(idNotification);

	}


}
