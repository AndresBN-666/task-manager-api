package com.andres.taskmanager;

import com.andres.taskmanager.dto.TareaDTO;
import com.andres.taskmanager.entity.TareaEntity;
import com.andres.taskmanager.exception.RecursoNoEncontradoException;
import com.andres.taskmanager.repository.TareaRepository;
import com.andres.taskmanager.service.TareaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TareaServiceImplTest {

    @Mock
    private TareaRepository tareaRepository;

    @InjectMocks
    private TareaServiceImpl tareaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCrearTarea(){
        TareaDTO tareaDTO = new TareaDTO();
        tareaDTO.setTitulo("Estudiar");
        tareaDTO.setDescripcion("Spring Boot");

        TareaEntity tareaEntity = new TareaEntity();
        tareaEntity.setId(1L);
        tareaEntity.setTitulo(tareaDTO.getTitulo());
        tareaEntity.setDescripcion(tareaDTO.getDescripcion());

        when(tareaRepository.save(any(TareaEntity.class))).thenReturn(tareaEntity);

        TareaEntity resultado = tareaService.crearTarea(tareaDTO);

        assertNotNull(resultado);
        assertEquals("Estudiar", resultado.getTitulo());
        assertEquals("Spring Boot", resultado.getDescripcion());
        verify(tareaRepository, times(1)).save(any(TareaEntity.class));

    }


    @Test
    void testListarTarea(){
        TareaEntity t1 = new TareaEntity();
        t1.setId(1L);
        t1.setTitulo("Estudiar");
        t1.setDescripcion("Spring Boot");

        TareaEntity t2 = new TareaEntity();
        t2.setId(2L);
        t2.setTitulo("Estudiar2");
        t2.setDescripcion("Spring Boot2");

        when(tareaRepository.findAll()).thenReturn(Arrays.asList(t1, t2));

        List<TareaEntity> resultado = tareaService.listarTareas();

        assertEquals(2, resultado.size());
        verify(tareaRepository, times(1)).findAll();
    }

    @Test
    void actualizarTareaNoExistente(){
        Long idInexistente = 2L;
        TareaDTO tareaDTO = new TareaDTO("Nuevo Titulo", "Nueva descripcion");

        when(tareaRepository.findById(idInexistente)).thenReturn(Optional.empty());

        RecursoNoEncontradoException ex = assertThrows(RecursoNoEncontradoException.class,
                ()-> {tareaService.actualizarTarea(idInexistente,tareaDTO);});

        assertEquals("Tarea no encontrada", ex.getMessage());
        verify(tareaRepository, times(1)).findById(idInexistente);
    }

    @Test
    void eliminarTareaNoExistente(){
        Long idInexistente = 2L;

        when(tareaRepository.findById(idInexistente)).thenReturn(Optional.empty());

        RecursoNoEncontradoException exception = assertThrows(RecursoNoEncontradoException.class,
                ()-> {tareaService.eliminarTarea(idInexistente);});

        assertEquals("Tarea no encontrada", exception.getMessage());
        verify(tareaRepository, times(1)).findById(idInexistente);
    }

}
