# 🗂️ API de Gestión de Tareas

Proyecto backend desarrollado con **Spring Boot 3**, **Java 17** y **MySQL**.  
Permite realizar operaciones CRUD sobre tareas (crear, listar, actualizar, eliminar)  
y está preparado con validaciones y pruebas unitarias.

---

## 🛠️ Tecnologías utilizadas

- Java 17
- Spring Boot 3.5
- Spring Data JPA
- MySQL 8
- Maven
- JUnit 5 + Mockito
- Lombok
- Jakarta Bean Validation

---

## 🚀 Endpoints disponibles

### 📄 Listar todas las tareas
`GET /tareas`

### ➕ Crear nueva tarea
`POST /tareas`

```json
{
  "titulo": "Estudiar",
  "descripcion": "Practicar Spring Boot"
}
 ```

### ✏️ Actualizar tarea

`PUT /tareas/{id}`

### ❌ Eliminar tarea

`DELETE /tareas/{id}`

### Validaciones

 Si los datos no cumplen las reglas, la Api resonde
  
```json

{
  "titulo": "El título es obligatorio",
  "descripcion": "La descripción es obligatoria"
}
 ```

### 🧪 Pruebas unitarias
El proyecto cuenta con pruebas de servicio utilizando JUnit + Mockito, incluyendo casos positivos y negativos.


👨‍💻 Autor
Andrés Bárcena Neyra
📍 Perú





