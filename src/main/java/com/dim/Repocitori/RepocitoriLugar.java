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

    @Query(value = "SELECT id,nombres,latitud,longitud,id_padron from obtener_lugares_cercanos(:latitud, :longitud)", nativeQuery = true)
    List<Lugares> findByDistance(@Param("latitud") float latitud,@Param("longitud") float longitud);
}

/*

{
    "padron": "9",
    "Dirección": "24 de sepriembre 330",
    "estado":"Sin deuda",
    "svg" : "<svg fill=\"{fillColor}\" width=\"25px\" height=\"25px\" viewBox=\"0 0 24 24\" xmlns=\"http://www.w3.org/2000/svg\" enableBackground=\"new 0 0 24 24\"><path d=\"M17,15.5V17c0,0.6-0.4,1-1,1s-1-0.4-1-1v-1.5H9V17c0,0.6-0.4,1-1,1s-1-0.4-1-1v-1.5H5c-0.7,0-1.4-0.2-2-0.5v4c0,1.7,1.3,3,3,3h12c1.7,0,3-1.3,3-3v-4c-0.6,0.3-1.3,0.5-2,0.5H17z M21,6h-4V5c0-1.7-1.3-3-3-3h-4C8.3,2,7,3.3,7,5v1H3C2.4,6,2,6.4,2,7v4c0,1.7,1.3,3,3,3h14c1.7,0,3-1.3,3-3V7C22,6.4,21.6,6,21,6z M15,6H9V5c0-0.6,0.4-1,1-1h4c0.6,0,1,0.4,1,1V6z\" /></svg>",
    "color":"#ff0000", rojo
    "ubicacion": {
      "nombre": "Casa Histórica - Museo Nacional de la Independencia"
    },
    "lat": -26.83309617953548,
    "lng": -65.20386410021385
  }


  {
    "padron": "47",
    "Dirección": "Av. Manuel Belgrano 2970, T4000 San Miguel de Tucumán, Tucumán",
    "estado": "Sin deuda",
    "svg": "<svg fill=\"{fillColor}\" width=\"17px\" height=\"17px\" viewBox=\"0 0 24 24\" xmlns=\"http://www.w3.org/2000/svg\" enableBackground=\"new 0 0 24 24\"><path d=\"M17,15.5V17c0,0.6-0.4,1-1,1s-1-0.4-1-1v-1.5H9V17c0,0.6-0.4,1-1,1s-1-0.4-1-1v-1.5H5c-0.7,0-1.4-0.2-2-0.5v4c0,1.7,1.3,3,3,3h12c1.7,0,3-1.3,3-3v-4c-0.6,0.3-1.3,0.5-2,0.5H17z M21,6h-4V5c0-1.7-1.3-3-3-3h-4C8.3,2,7,3.3,7,5v1H3C2.4,6,2,6.4,2,7v4c0,1.7,1.3,3,3,3h14c1.7,0,3-1.3,3-3V7C22,6.4,21.6,6,21,6z M15,6H9V5c0-0.6,0.4-1,1-1h4c0.6,0,1,0.4,1,1V6z\" /></svg>",
    "color": "#00ff28" verde,
    "ubicacion": {
      "nombre": "Sanatorio Galeno"
    },
    "lat": -26.811391107366852,
    "lng": -65.23928055548183
  }


#ff0000 rojo

#009929 verde


 */