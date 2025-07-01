package com.andres.taskmanager.service;

import com.andres.taskmanager.dto.TareaDTO;
import com.andres.taskmanager.entity.TareaEntity;
import com.andres.taskmanager.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaServiceImpl implements TareaService{

    @Autowired
    private TareaRepository tareaRepository;

    @Override
    public TareaEntity crearTarea(TareaDTO tareaDTO) {
        TareaEntity tarea = new TareaEntity();
        tarea.setTitulo(tareaDTO.getTitulo());
        tarea.setDescripcion(tareaDTO.getDescripcion());

        return tareaRepository.save(tarea);
    }

    @Override
    public List<TareaEntity> listarTareas() {
        return tareaRepository.findAll();
    }

    @Override
    public TareaEntity actualizarTarea(Long id, TareaDTO tareaDTO) {
        TareaEntity tarea = tareaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
        tarea.setTitulo(tareaDTO.getTitulo());
        tarea.setDescripcion(tareaDTO.getDescripcion());
        return tareaRepository.save(tarea);
    }

    @Override
    public void eliminarTarea(Long id) {
        tareaRepository.deleteById(id);

    }
}
