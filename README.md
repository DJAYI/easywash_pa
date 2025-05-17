# EasyWash Project

## Descripción General

**EasyWash** es una aplicación de escritorio desarrollada en Java con Swing que gestiona un sistema de lavado de vehículos. Permite a clientes, empleados y administradores interactuar con el sistema para agendar citas, gestionar servicios, administrar empleados y vehículos, y llevar un control de usuarios. El sistema utiliza archivos JSON para almacenar la información de manera persistente.

---

## Tabla de Contenidos

1. [Estructura del Proyecto](#estructura-del-proyecto)
2. [Conceptos Clave](#conceptos-clave)
3. [Funcionalidades Principales](#funcionalidades-principales)
4. [Cómo Funciona el Sistema](#cómo-funciona-el-sistema)
5. [Explicación de Clases y Componentes](#explicación-de-clases-y-componentes)
6. [Cómo Ejecutar el Proyecto](#cómo-ejecutar-el-proyecto)
7. [Notas para Principiantes](#notas-para-principiantes)

---

## Estructura del Proyecto

easywash_pa/ ├── src/ │ ├── main/ │ │ ├── java/ │ │ │ └── com/tecno_comfenalco/easywashproject/ │ │ │ ├── controllers/ │ │ │ ├── enums/ │ │ │ ├── models/ │ │ │ ├── repository/ │ │ │ └── views/ │ │ └── resources/ │ │ └── public/ │ └── test/ ├── \*.json (archivos de datos) ├── pom.xml (archivo de configuración Maven) └── README.md

---

## Conceptos Clave

### 1. **MVC (Modelo-Vista-Controlador)**

- **Modelo:** Representa los datos y la lógica de negocio (por ejemplo, `Client`, `Employee`, `Service`, `Appointment`).
- **Vista:** Interfaz gráfica con la que interactúa el usuario (por ejemplo, formularios de registro, paneles de citas).
- **Controlador:** Gestiona la lógica entre la vista y el modelo (por ejemplo, `ClientController`, `ServiceController`).

### 2. **Swing**

- Es una biblioteca de Java para crear interfaces gráficas de usuario (GUI).

### 3. **Persistencia con JSON**

- Los datos se guardan en archivos `.json` en vez de una base de datos tradicional.
- Cada entidad (clientes, empleados, servicios, etc.) tiene su propio archivo.

### 4. **Enumeraciones (Enums)**

- Tipos especiales de datos que representan un conjunto fijo de constantes (por ejemplo, tipos de documento, tipos de vehículo, estados de cita).

---

## Funcionalidades Principales

### 1. **Gestión de Clientes**

- Registro de nuevos clientes.
- Inicio de sesión de clientes.
- Visualización y edición de datos personales.
- Visualización de citas y vehículos asociados.

### 2. **Gestión de Empleados**

- Registro y edición de empleados (solo administradores).
- Asignación de citas a empleados.

### 3. **Gestión de Servicios**

- Creación, edición y eliminación de servicios ofrecidos.
- Visualización de todos los servicios disponibles.

### 4. **Gestión de Vehículos**

- Registro de vehículos por parte de los clientes.
- Visualización de vehículos asociados a un cliente.

### 5. **Gestión de Citas**

- Agendamiento de citas por parte de los clientes.
- Visualización de historial de citas.
- Cambio de estado de las citas (pendiente, cotizado, etc.).

### 6. **Gestión de Usuarios (Administradores)**

- Registro y autenticación de usuarios administradores.
- Acceso a paneles de administración.

---

## Cómo Funciona el Sistema

### 1. **Inicio**

- Al ejecutar el programa, se muestra la pantalla principal ([VistaPrincipal](src/main/java/com/tecno_comfenalco/easywashproject/views/layouts/VistaPrincipal.java)).
- El usuario elige si es cliente o administrador.

### 2. **Flujo de Cliente**

- **Registro:** Si el cliente no tiene cuenta, accede al formulario de registro ([RegisterClientView](src/main/java/com/tecno_comfenalco/easywashproject/views/clients/RegisterClientView.java)), ingresa sus datos y se guardan en `clients.json`.
- **Login:** Si ya tiene cuenta, ingresa sus credenciales ([LoginClienteView](src/main/java/com/tecno_comfenalco/easywashproject/views/auth/LoginClienteView.java)).
- **Dashboard:** Una vez autenticado, accede a su panel donde puede:
  - Agendar nuevas citas.
  - Ver historial de citas.
  - Ver y gestionar sus vehículos.

### 3. **Flujo de Administrador**

- **Login:** El administrador ingresa sus credenciales ([LoginUserView](src/main/java/com/tecno_comfenalco/easywashproject/views/auth/LoginUserView.java)).
- **Dashboard:** Puede:
  - Ver y gestionar empleados.
  - Ver y gestionar servicios.
  - Ver y gestionar citas de todos los clientes.

### 4. **Gestión de Datos**

- Todas las operaciones de creación, edición y eliminación se reflejan en los archivos JSON correspondientes.
- Los controladores (`*Controller.java`) se encargan de la lógica de negocio y de interactuar con los repositorios (`*RepositoryImpl.java`).

---

## Explicación de Clases y Componentes

### 1. **Modelos**

- [`Client`](src/main/java/com/tecno_comfenalco/easywashproject/models/Client.java): Representa a un cliente.
- [`Employee`](src/main/java/com/tecno_comfenalco/easywashproject/models/Employee.java): Representa a un empleado.
- [`Service`](src/main/java/com/tecno_comfenalco/easywashproject/models/Service.java): Representa un servicio ofrecido.
- [`Vehicle`](src/main/java/com/tecno_comfenalco/easywashproject/models/Vehicle.java): Representa un vehículo.
- [`Appointment`](src/main/java/com/tecno_comfenalco/easywashproject/models/Appointment.java): Representa una cita.

### 2. **Controladores**

- [`ClientController`](src/main/java/com/tecno_comfenalco/easywashproject/controllers/ClientController.java): Lógica para clientes.
- [`EmployeeController`](src/main/java/com/tecno_comfenalco/easywashproject/controllers/EmployeeController.java): Lógica para empleados.
- [`ServiceController`](src/main/java/com/tecno_comfenalco/easywashproject/controllers/ServiceController.java): Lógica para servicios.
- [`UserController`](src/main/java/com/tecno_comfenalco/easywashproject/controllers/UserController.java): Lógica para usuarios administradores.
- [`AppointmentController`](src/main/java/com/tecno_comfenalco/easywashproject/controllers/AppointmentController.java): Lógica para citas.
- [`NavigationManager`](src/main/java/com/tecno_comfenalco/easywashproject/controllers/NavigationManager.java): Gestiona la navegación entre vistas.

### 3. **Vistas**

- Formularios y paneles Swing para cada funcionalidad (registro, login, dashboard, gestión de entidades).

### 4. **Repositorios**

- Implementaciones que leen y escriben datos en archivos JSON (por ejemplo, `ClientRepositoryImpl`, `ServiceRepositoryImpl`).

---

## Cómo Ejecutar el Proyecto

1. **Requisitos Previos**

   - Tener instalado Java JDK 8 o superior.
   - Tener instalado Maven.

2. **Compilar el Proyecto**
   ```sh
   mvn clean install
   ```

Ejecutar la Aplicación
Desde tu IDE, ejecuta la clase Main.
O desde terminal:
Notas para Principiantes
¿Qué es un archivo JSON?
Es un formato de texto para almacenar datos estructurados, similar a un diccionario o un objeto en muchos lenguajes de programación.

¿Qué es una clase?
Es una plantilla para crear objetos en programación orientada a objetos. Por ejemplo, la clase Client define cómo es un cliente.

¿Qué es un método?
Es una función definida dentro de una clase que realiza una acción o devuelve un valor.

¿Qué es una interfaz gráfica (GUI)?
Es la parte visual de la aplicación con la que interactúa el usuario (ventanas, botones, formularios).

¿Qué es un Enum?
Es un tipo especial de clase que representa un conjunto fijo de constantes (por ejemplo, tipos de documento).

¿Qué es un controlador?
Es una clase que contiene la lógica para manipular los datos y coordinar la interacción entre la vista y el modelo.

¿Qué es persistencia?
Es la capacidad de guardar datos para que no se pierdan cuando se cierra la aplicación. Aquí se hace usando archivos JSON.

Créditos
Desarrollado por: jacob, danil
Licencia
Este proyecto es solo para fines educativos.
