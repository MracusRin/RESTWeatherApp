package com.mracus.RESTWeatherApp.repositories;

import com.mracus.RESTWeatherApp.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
    @Query("select count(m) from Measurement m where m.raining = true ")
     Integer showRainyDays();
}
