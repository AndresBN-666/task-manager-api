package com.andres.taskmanager.repository;

import com.andres.taskmanager.entity.TareaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<TareaEntity, Long> {
}
