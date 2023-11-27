package com.dim.Controller;


import com.dim.Module.Coordenada;
import com.dim.Module.Lugares;
import com.dim.Services.LugarServicio;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LugaresController implements LugaresApi {

    private final LugarServicio lugarServicio;

    @Override
    public ResponseEntity<Collection<Lugares>> getLugaresByCoordenadas(Float latitud,Float longitud) {
        return ResponseEntity.ok(lugarServicio.getLugaresByLatitudLogintud(latitud,longitud));
    }

}
