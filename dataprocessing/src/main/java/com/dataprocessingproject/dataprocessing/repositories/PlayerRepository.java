package com.dataprocessingproject.dataprocessing.repositories;

import com.dataprocessingproject.dataprocessing.models.PlayerModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<PlayerModel, String> {
}
