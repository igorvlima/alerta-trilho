package com.br.alertmessagesendler.repository;

import com.br.alertmessagesendler.domain.Delay.Line;
import com.br.alertmessagesendler.models.PassengerLineModel;
import lombok.Getter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerLineRepository extends JpaRepository<PassengerLineModel, Integer> {

    @Query(value = "SELECT pl.passenger_id FROM PassengerLineModel pl WHERE pl.line_id = :lineId")
    List<Integer> findAllPassengersIdByLineId(@Param("lineId") Integer lineId);
}
