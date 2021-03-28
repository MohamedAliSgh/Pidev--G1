package com.example.repository;

import org.springframework.data.repository.CrudRepository;


import com.example.entity.Media;

public interface MediaRepository extends CrudRepository<Media,Long> {

}
