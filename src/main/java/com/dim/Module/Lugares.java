package com.dim.Module;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.awt.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lugares")
public class Lugares {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_lugar")
    private Long id;
    @Column(name = "nombres")
    private String nombre;

//    @Type(type = "org.hibernate.spatial.GeometryType")
    @Column(name = "longitud")
    private Long longitud;

    @Column(name = "latitud")
    private Long latitud;

    @Column(name = "id_padrones")
    private Long id_padron;

    /*
        @Type(type = "org.hibernate.spatial.GeometryType")
    @Column(name = "tu_campo_geografico", columnDefinition = "Geometry")
    private Point tuCampoGeografico;

     */

}

/*

CREATE TABLE lugares (
    id serial PRIMARY KEY,
    nombre VARCHAR(100),
    ubicacion GEOGRAPHY(Point, 4326) -- 4326 es el SRID para coordenadas geográficas WGS 84
);

INSERT INTO lugares (nombre, ubicacion) VALUES
    ('Lugar A', ST_GeographyFromText('POINT(-74.006 40.712)')),
    ('Lugar B', ST_GeographyFromText('POINT(-73.987 40.754)')),
    ('Lugar C', ST_GeographyFromText('POINT(-118.250 34.050)'));

-- Encontrar lugares dentro de un radio de 100 kilómetros de una ubicación específica
        SELECT *
        FROM lugares
        WHERE ST_DWithin(ubicacion, ST_GeographyFromText('POINT(-74.006 40.712)'), 10);
        -- 100,000 metros = 100 kilómetros
 */