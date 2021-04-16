package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.Notification;

public interface NotificationService {
	public List<Notification> retriveAllnotifications();
	 public Notification addNotification(Notification n);
	 public void deleteNotification(Long idNotification);
	 public Notification updateNotification(Notification n);
	 public Optional<Notification> retrieveNotification(Long idNotification);

}
