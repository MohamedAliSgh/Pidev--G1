package com.example.app.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.app.entity.Commentaire;
import com.example.app.entity.Media;
import com.example.app.entity.Post;
import com.example.app.entity.ProjectDetail;
import com.example.app.entity.Reacts;

public interface PostService {
	public List<Post> retriveAllPosts();
	public void AddPost(Post p);
	public void DeletePost(Post p);
	public void UpdatePost(long PostID);
	public Post getPostById(Long id);
	//public List<Commentaire> Getpostcomments(Long postid);
   // public List<Media> getpostmedia(Long postid);
    //public List<Reacts> getpostreacts(Long postid);
	public Post getJson(String post,MultipartFile[] files);
}
