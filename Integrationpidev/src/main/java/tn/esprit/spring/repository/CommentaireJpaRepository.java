package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entities.Commentaire;



public interface CommentaireJpaRepository extends JpaRepository<Commentaire,Long>{
	//@Query("SELECT*FROM COMMENTAIRE where Post_id= :postid")
	
	//public List<Commentaire> retrivecommentsbypost(@Param("postid") Long postid);

}
