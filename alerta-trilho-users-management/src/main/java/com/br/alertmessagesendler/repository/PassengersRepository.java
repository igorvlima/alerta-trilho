package com.br.alertmessagesendler.repository;

import com.br.alertmessagesendler.domain.Delay.Line;
import com.br.alertmessagesendler.models.PassangersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengersRepository extends JpaRepository<PassangersModel, Integer> {

    @Query(value = "SELECT p.phoneNumber FROM PassangersModel p WHERE p.id = :id")
    String getPessengerPhoneNumber(@Param("id") Integer id);
}
