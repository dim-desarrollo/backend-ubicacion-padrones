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
    @Column(name = "id")
    private Long id;

    @Column(name = "nombres")
    private String nombre;

    @Column(name = "longitud")
    private double longitud;

    @Column(name = "latitud")
    private double latitud;

    @OneToOne
    @JoinColumn(name = "id_padrones", referencedColumnName = "id_padrones") // Debes especificar la columna de referencia aquí
    private Padrones id_padron;

//    @Column(name = "id_padron")
//    private Long id_padron;

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



  [
    {
        "id": 1,
        "nombre": "av 24 de septiembre 334 San Miguel de Tucuman",
        "longitud": -26.8316497,
        "latitud": -65.202393,
        "id_padron": {
            "id_padrones": 1,
            "modificado": false,
            "padron": 212121,
            "svg": "<?xml version=\"1.0\" ?><svg xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" version=\"1.1\" viewBox=\"0 0 512 512\" style=\"enable-background:new 0 0 512 512;\" xml:space=\"preserve\"><g id=\"_x32_0_x2C__Debt_x2C__Business_and_Finance_x2C__Banking_x2C__Bomb_x2C__Dollar_x2C__Business_x2C__Money_x2C__Gaming\"><g><path style=\"fill:#FFFFFF;\" d=\"M236,51.04h-20h-5h-25c-16.57,0-30,13.43-30,30v27.66h110V81.04C266,64.47,252.57,51.04,236,51.04z    \"/><path style=\"fill:#FFFFFF;\" d=\"M266,108.7c83.72,23.89,145,100.96,145,192.34c0,110.45-89.54,200-200,200s-200-89.55-200-200    c0-91.38,61.28-168.45,145-192.34c17.47-4.99,35.92-7.66,55-7.66S248.53,103.71,266,108.7z\"/><circle style=\"fill:#9DCAFC;\" cx=\"211\" cy=\"301.04\" r=\"130\"/><g><path style=\"fill:#4269A7;\" d=\"M446,61.036c-5.522,0-10,4.477-10,10v2.5c0,20.678-16.822,37.5-37.5,37.5S361,94.213,361,73.536     v-22.5c0-27.57-22.43-50-50-50h-60c-24.146,0-44.348,17.205-48.994,40H186c-22.056,0-40,17.944-40,40v20.31     C61.925,128.78,1,207.92,1,301.036c0,115.794,94.206,210,210,210s210-94.206,210-210c0-93.116-60.925-172.256-145-199.69v-20.31     c0-22.056-17.944-40-40-40h-13.28c4.128-11.639,15.243-20,28.28-20h60c16.542,0,30,13.458,30,30v22.5     c0,31.706,25.794,57.5,57.5,57.5s57.5-25.794,57.5-57.5v-2.5C456,65.513,451.522,61.036,446,61.036z M401,301.036     c0,104.767-85.233,190-190,190s-190-85.233-190-190s85.233-190,190-190S401,196.269,401,301.036z M256,81.036v14.87     c-29.621-6.493-60.363-6.496-90,0v-14.87c0-11.028,8.972-20,20-20h50C247.028,61.036,256,70.008,256,81.036z\"/><path style=\"fill:#4269A7;\" d=\"M446,1.036c-5.522,0-10,4.477-10,10v20c0,5.523,4.478,10,10,10s10-4.477,10-10v-20     C456,5.513,451.522,1.036,446,1.036z\"/><path style=\"fill:#4269A7;\" d=\"M398.071,32.178l14.143-14.142c3.905-3.905,3.905-10.237,0-14.142     c-3.904-3.905-10.234-3.905-14.143,0l-14.143,14.142c-3.905,3.905-3.905,10.237,0,14.142     C387.835,36.084,394.165,36.082,398.071,32.178z\"/><path style=\"fill:#4269A7;\" d=\"M508.071,18.035L493.929,3.893c-3.906-3.905-10.236-3.905-14.143,0     c-3.905,3.905-3.905,10.237,0,14.142l14.143,14.142c3.906,3.905,10.236,3.905,14.143,0     C511.976,28.272,511.976,21.94,508.071,18.035z\"/><path style=\"fill:#4269A7;\" d=\"M71,301.036c0,77.196,62.804,140,140,140s140-62.804,140-140s-62.804-140-140-140     S71,223.839,71,301.036z M331,301.036c0,66.168-53.832,120-120,120s-120-53.832-120-120s53.832-120,120-120     S331,234.867,331,301.036z\"/><path style=\"fill:#4269A7;\" d=\"M201,221.036v15.897c-22.97,9.632-28.717,39.527-11.214,57.032l28.285,28.284     c5.849,5.849,5.849,15.365,0.001,21.213c-5.849,5.849-15.365,5.849-21.214,0c-3.906-3.905-10.236-3.905-14.143,0     c-3.905,3.905-3.905,10.237,0,14.143c5.175,5.175,11.582,8.383,18.284,9.633v13.799c0,5.523,4.478,10,10,10s10-4.477,10-10     v-15.911c22.894-9.568,28.766-39.464,11.214-57.018l-28.285-28.284c-5.849-5.849-5.849-15.365,0-21.213     c5.863-5.864,15.352-5.862,21.213,0c3.906,3.906,10.236,3.906,14.143,0c3.905-3.905,3.905-10.237,0-14.142     c-5.186-5.186-11.589-8.402-18.284-9.655v-13.776c0-5.523-4.478-10-10-10S201,215.513,201,221.036z\"/></g></g></g><g id=\"Layer_1\"/></svg>",
            "deuda": null
        }
    }
]


#ff0000 rojo

#009929 verde


 */