package com.dim.Services;

import com.dim.Module.Coordenada;
import com.dim.Module.Lugares;

import java.util.Collection;
import java.util.List;

public interface LugarServicio extends ServicioCRUD<Lugares>  {

    List<Lugares> getLugaresByLatitudLogintud(Float latitud,Float longitud);

}
