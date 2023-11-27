package com.dim.Repocitori;

import com.dim.Module.Lugares;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface RepocitoriLugar extends JpaRepository<Lugares, Long>{

    //SELECT *
    //FROM lugares
    //WHERE ST_DWithin(ubicacion, ST_GeographyFromText('POINT(-74.006 40.712)'), 10);
//        @Query(value = "SELECT * FROM lugares WHERE ST_DWithin(ST_GeographyFromText('POINT(?1 ?2)'), 100)", nativeQuery = true)
//        Collection<Lugares> buscarLugaresPorLatitudLongitud(double latitud,double longitud );


    @Query("SELECT l FROM Lugares l WHERE ST_DWithin(l.ubicacion, ST_GeographyFromText('POINT(' || ?1 || ' ' || ?2 || ')'), 100000)")
    List<Lugares> findByDistance(float longitud, float latitud);

}
