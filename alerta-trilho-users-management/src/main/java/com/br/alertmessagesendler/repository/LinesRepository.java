package com.br.alertmessagesendler.repository;

import com.br.alertmessagesendler.domain.Delay.Line;
import com.br.alertmessagesendler.models.LinesModel;
import com.br.alertmessagesendler.models.PassangersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LinesRepository extends JpaRepository<LinesModel, Integer> {

    @Query(value = "SELECT l.id FROM LinesModel l WHERE l.name = :name")
    Integer findByLineByName(@Param("name") String line);
}
