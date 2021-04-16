package com.example.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.app.entity.Commentaire;
import com.example.app.entity.Reacts;

public interface ReactsJpaRepository extends JpaRepository<Reacts,Long> {
	//@Query("SELECT*FROM reacts where Post_id= :postid")
	//public List<Reacts> retriveReactsbypost(@Param("postid") Long postid);
}
