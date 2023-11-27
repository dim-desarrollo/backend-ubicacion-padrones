package com.dim.Services;

import com.dim.Module.Coordenada;
import com.dim.Module.Lugares;
import com.dim.Repocitori.RepocitoriLugar;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LugarImpl implements LugarServicio{

    private final RepocitoriLugar repocitoriLugar;

    @Override
    public List<Lugares> getLugaresByLatitudLogintud(Float latitud, Float longitud) {

        return repocitoriLugar.findByDistance(latitud ,longitud);
    }

    @Override
    public Lugares guardar(Lugares entidad) {
        return null;
    }

    @Override
    public Lugares actualizar(Long id, Lugares entidad) {
        return null;
    }

    @Override
    public Lugares buscarPorId(Long id) {
        return null;
    }

    @Override
    public Collection<Lugares> buscarTodos() {
        return null;
    }

    @Override
    public Long cantidad() {
        return null;
    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public boolean existePorId(Long id) {
        return false;
    }
}
