package tn.esprit.spring.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.fasterxml.jackson.databind.ObjectMapper;

import tn.esprit.spring.entities.Media;
import tn.esprit.spring.entities.Post;
import tn.esprit.spring.repository.MediaRepository;



@Service
public class MediaServiceImpl implements MediaService {
	private final Path root = Paths.get("Uploads");
	@Autowired
	MediaRepository mediarepo;
	@Override
	public List<Media> retriveAllMedia() {
    return null; 
	}
    
	@Override
	public Media getMediaeById(Long id) {
		
		return null;
	}

	@Override
	public void UpdateMedia(long MediaID) {
	
		
	}

	@Override
	public Media AddMedia(Media m) {
        return mediarepo.save(m);
	}

	@Override
	public String uploadFile(MultipartFile file) {
	 return null;
	}

	@Override
	public Resource load(String nomfichier) {
	    try {
	        Path file = root.resolve(nomfichier);
	        Resource resource = new UrlResource(file.toUri());

	        if (resource.exists() || resource.isReadable()) {
	          return resource;
	        } else {
	          throw new RuntimeException("Could not read the file!");
	        }
	      } catch (MalformedURLException e) {
	        throw new RuntimeException("Error: " + e.getMessage());
	      }
	}

	@Override
	public Stream<Path> loadAll() {		
		   try {
		        return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
		      } catch (IOException e) {
		        throw new RuntimeException("Could not load the files!");
		      }
	}

	@Override
	public void init() {
	    try {
	        Files.createDirectory(root);
	      } catch (IOException e) {
	        throw new RuntimeException("Could not initialize folder for upload!");
	      }
		
	}

	@Override
	public void save(MultipartFile file) {
	    try {
	        Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
	      } catch (Exception e) {
	        throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
	      }
		
	}
	@Override
	public List<Media> getMediaByPost(Post p) {
		return mediarepo.findMediaByPost(p);
	}

	@Override
	public Media getJson(String media, MultipartFile file) {
        Media mediajson=new Media();
        try{
        	ObjectMapper objectMapper =new ObjectMapper();
        	mediajson=objectMapper.readValue(media,Media.class);    	
        }
        catch(IOException err)
        {
        	System.out.printf("Erreur",err.toString());
        }
        mediajson.setName(file.getOriginalFilename());
        return mediajson;
	}
	

}
