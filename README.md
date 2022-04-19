# Práctica 7 PAT - Persistencias con queries
Esta página he decidido hacer una página de cursos online en la que únicamente se simula el administrador y el hacer login y registrarse para un alumno. El administrador podrá añadir, eliminar o actualizar cursos y verlos tanto por alumno como por curso.

# Ver la práctica
[![](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/#https://github.com/Menendez6/pract7_n)

# Objetivo de la práctica

Desarrollo de una App de Spring Boot que incluya una funcionalidad que permita persistir información utilizando la librería Spring Data JDBC con una base de datos H2.

El módulo de persistencia debe incluir las operaciones (INSERT, UPDATE,  SELECT y DELETE)

Las operaciones debe de incluir como mínimo dos operaciones “JOINS”  utilizando la anotación @Query.

# Explicación de la práctica
## Páginas
La página web contiene las siguientes páginas:
- index.html : Esta paǵina únicamente sirve para hacer login. Si los datos introducidos están en la base de datos, se permite entrar al usuario. Sino saldrá un mensaje de error
- signup.html: Esta página se puede registrar el usuario. Si ya hay un usuario con el mismo nombre o email en la base de datos, aparece un mensaje de error.
- admin.html: En esta página aparecen todos los cursos. Cada cursos tiene un botón de eliminar o actualizar que permitirá realizar la acción correspondiente. Además, en esta página hay 3 botones en la parte superior para añadir un curso, para ver los alumnos que hay en cada curso y para ver los cursos por alumno.
- new_course.html: Formulario que permite introducir los datos para crear un curso.
- up_course.html: Formulario muy parecido al anterior pero que al abrirlo está rellenado con el curso que hayas seleccionado para actualizar.
- courses.html: Lista con todos los cursos para que los vea el usuario y se pueda apuntar.
- students.html: Lista con todos los alumnos para el administrados
- courses_st.html: Lista con todos los cursos por alumnos

## Tablas
- CUSTOMERS: Tabla de clientes en la que tenemos como campos el id, el nombre, el email y la contraseña.
- COURSES: Tabla de cursos en la que tenemos como campos el id, el nombre del curso, el semestre y el grado al que pertenece.
- COURSCUST: Tabla intermedia entre clientes y cursos que recoge el id del cliente y el id del curso.

