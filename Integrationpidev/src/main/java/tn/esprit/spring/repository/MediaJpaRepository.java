package com.example.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.app.entity.Commentaire;
import com.example.app.entity.Media;

public interface MediaJpaRepository extends JpaRepository<Media,Long>  {
	//@Query("SELECT*FROM Media where idpost= :postid")
	//public List<Media> retriveMediasbypost(@Param("postid") Long postid);

}
