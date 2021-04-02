package com.dataprocessingproject.dataprocessing.repositories;

import com.dataprocessingproject.dataprocessing.models.CourseModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<CourseModel, String> {
    
}
