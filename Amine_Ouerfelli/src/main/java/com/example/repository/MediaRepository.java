package com.example.repository;

import org.springframework.data.repository.CrudRepository;


import com.example.app.entity.Media;

public interface MediaRepository extends CrudRepository<Media,Long> {

}
