# Propósito del Proyecto

Este es un proyecto para repasar conceptos de Spring Boot, se realiza en base a SpringGrowthChallenge, los componentes de este proyecto son los siguientes:

## Componentes Principales

### 1. Controladores
- **LibrosController**: Un controlador que maneja solicitudes a la ruta `/api/libros`. CRUD que contiene operaciones necesarias para gestión de Libros.
- **UsuariosController**: Un controlador que maneja solicitudes a la ruta `/api/usuarios`. CRUD que contiene operaciones necesarias para gestión de Usuarios.
- **ValidationExceptionController**: Un controlador para manejar excepciones de tipo MethodArgumentNotValidException y sobre el cual el servicio regresa qué campo no es válido.
## Funcionalidades

### 1. Validaciones Spring Boot
Se usan validaciones de campos de entrada de objectos, usando Valid, se maneja las excepciones con un controlador para que sea más fácil al usuario identificar qué campo no es válido.

### 2. Testing
Se usan unit test e integration tests para probar la funcionalidad de cada uno de los módulos.

### 3. Fundamentos JPA
Se ocupa JPA para consultar a base de datos, se prueban varias funciones como paginación, queries nativos, y el uso de transaccionalidad.

## Resumen
En resumen, este proyecto que sirve como base y usa varios conceptos importantes en la implementación de micro servicios con Spring Boot.
