package com.example.app.service;

import java.util.List;

import com.example.app.entity.Post;
import com.example.app.entity.Reacts;

public interface ReactsService {
	 public List<Reacts> retriveAllReacts();
	 public void AddReact(Reacts r);
	 public void DeleteReact(Reacts r);
	 public void UpdateReact(long ReactID);
	 public Reacts getReactById(Long id);
	 public List<Reacts>getReactByPost(Post p);

}
