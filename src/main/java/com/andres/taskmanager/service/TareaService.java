package com.andres.taskmanager.service;

import com.andres.taskmanager.dto.TareaDTO;
import com.andres.taskmanager.entity.TareaEntity;

import java.util.List;

public interface TareaService {
    TareaEntity crearTarea(TareaDTO tareaDTO);
    List<TareaEntity> listarTareas();
    TareaEntity actualizarTarea(Long id,TareaDTO tareaDTO);
    void eliminarTarea(Long id);
}
