package com.example.app.control;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.entity.Media;
import com.example.app.entity.Post;
import com.example.app.service.MediaService;

@RestController
public class fileuploadcontroller {
	@Autowired
	MediaService mediaser;
	@RequestMapping(value="/addfile", method=RequestMethod.POST, consumes ={ MediaType.MULTIPART_FORM_DATA_VALUE,MediaType.APPLICATION_JSON_VALUE})	
	private Media savepost(@RequestPart("Media") String media,@RequestPart("file") MultipartFile file)   
	{ 
	
    Media meedia=new Media();
	mediaser.save(file);
	meedia=mediaser.getJson(media, file);
	mediaser.AddMedia(meedia);	    
	return meedia;
	}

}
