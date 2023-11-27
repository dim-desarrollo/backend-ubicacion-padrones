package com.dim.Controller;


import com.dim.Module.Coordenada;
import com.dim.Module.Lugares;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collection;

@RequestMapping("/padron")
public interface LugaresApi {


    //NOMBRE, PADRON, DIRECCION, FECHA DE ALTA, ESTADO, [LATITUD Y LONGITUD]



    @GetMapping(value = "/{latitud}/{longitud}", produces = {"application/json", "application/vnd.api+json"})
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<Collection<Lugares>> getLugaresByCoordenadas(
            @PathVariable("latitud") Float latitud,
            @PathVariable("longitud") Float longitud);

}
