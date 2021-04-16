package tn.esprit.spring.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entities.Post;


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
