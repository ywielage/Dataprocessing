package com.dataprocessingproject.dataprocessing.repositories;

import com.dataprocessingproject.dataprocessing.models.CourseRecordModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRecordRepository extends CrudRepository<CourseRecordModel, String> {

}
