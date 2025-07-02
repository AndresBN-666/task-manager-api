package com.andres.taskmanager.controller;

import com.andres.taskmanager.dto.TareaDTO;
import com.andres.taskmanager.entity.TareaEntity;
import com.andres.taskmanager.service.TareaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @PostMapping
    public TareaEntity crear(@RequestBody @Valid TareaDTO tareaDTO){
        return tareaService.crearTarea(tareaDTO);
    }

    @GetMapping
    public List<TareaEntity> listar(){
        return tareaService.listarTareas();
    }

    @PutMapping("/{id}")
    public TareaEntity actualizarTarea(@PathVariable Long id,
                                       @RequestBody @Valid TareaDTO tareaDTO){
        return tareaService.actualizarTarea(id, tareaDTO);
    }

    @DeleteMapping("/{id}")
    public void eliminarTarea(@PathVariable Long id){
        tareaService.eliminarTarea(id);
    }

}
