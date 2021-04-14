package com.example.app.service;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.entity.Media;
import com.example.app.entity.Post;

public interface MediaService {
	public void init();
	public List<Media> retriveAllMedia();
	public Media getMediaeById(Long id);
	public void UpdateMedia(long MediaID);
	public Media AddMedia(Media m);
	public String uploadFile(MultipartFile file);
    public Resource load(String nomfichier);
    public Stream<Path> loadAll();
    public void save(MultipartFile files);
    public List<Media> getMediaByPost(Post p);
    public Media getJson(String media,MultipartFile file);
}
