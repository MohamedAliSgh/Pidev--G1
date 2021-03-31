package tn.esprit.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.entities.Message;

public interface MessageRepository extends CrudRepository<Message,Long> {

}
