## **1. Nombre del proyecto**

**Nombre provisional:**

> _Kaizen_ (puedes cambiarlo por el que prefieras, por ejemplo _ZenTime_)

---

## **2. Objetivo**

Crear una aplicación multiplataforma que ayude al usuario a organizar su vida diaria, mejorar su productividad y cuidar su bienestar personal mediante funcionalidades integradas en un solo lugar.

---

## **3. Público objetivo**

- Personas que quieran organizar sus tareas y rutinas.
- Estudiantes, profesionales y deportistas.
- Público general interesado en un seguimiento integral (productividad + salud).

---

## **4. Funcionalidades principales**

### Gestión de tareas

- Crear, editar y eliminar tareas.
- Asignar fechas, horas, prioridad y etiquetas.
- Marcar como completadas.

### Calendario

- Vista mensual y semanal.
- Integración con tareas y eventos.
- Posibilidad de añadir eventos personales.

### Rutinas

- Crear rutinas diarias/semanales.
- Visualizar progreso.
- Recordatorios automáticos.

### Diario personal

- Registrar pensamientos y notas diarias.
- Añadir imágenes opcionalmente.
- Visualización por fechas.

### Seguimiento de ciclo

- Registrar fechas del ciclo menstrual.
- Predicción aproximada del siguiente ciclo.
- Añadir síntomas y notas diarias.
- Notificaciones de aviso.

### Módulo gym y kcal

- Registrar sesiones de entrenamiento.
- Añadir ejercicios con repeticiones y peso.
- Contador de calorías quemadas.
- Estadísticas y seguimiento por grupos musculares.

### Estadísticas generales

- Progreso mensual y semanal.
- Datos sobre hábitos y actividad.

---

## **5. Plataformas**

- 📱 Android
- 📱 iOS
- 💻 Web
- 🖥️ Escritorio (Windows / Mac / Linux)

---

## **6. Sincronización y almacenamiento**

- **Backend:** Firebase (Firestore, Auth, Storage, Cloud Messaging).
- **Local:** SQLite para funcionamiento offline.
- Sincronización automática cuando haya conexión.
- Control de conflictos y estados de sincronización.

---

## **7. Diseño y estilo visual**

- Base en **modo oscuro**.
- Color principal: negro puro.
- Colores secundarios: neones suaves (verde lima, azul eléctrico, violeta).
- Tipografía: moderna, sans-serif (ej. Inter, Roboto).
- Iconografía minimalista y fina.
- Animaciones suaves (feedback y transiciones).

---

## **8. Seguridad y privacidad**

- Autenticación segura con email y Google.
- Datos cifrados en Firebase.
- Política de privacidad clara (opción de borrar cuenta y datos).
- Gestión confidencial de datos sensibles (ciclo menstrual).

---

## **9. Estructura de la base de datos (Firestore)**
```
`users    
├─ uid         
├─ nombre         
├─ email         
├─ fecha_registro         
├─ configuración (notificaciones, objetivos, etc.)    tasks    
├─ id         
├─ user_id         
├─ título         
├─ descripción         
├─ fecha         
├─ hora         
├─ prioridad         
├─ completado    routines    
├─ id         
├─ user_id         
├─ nombre         
├─ frecuencia         
├─ pasos    diary_entries    
├─ id         
├─ user_id         
├─ fecha         
├─ contenido         
├─ imagenes    cycles    
├─ id         
├─ user_id         
├─ fecha_inicio         
├─ duración_estim         
├─ síntomas    gym_sessions    
├─ id         
├─ user_id         
├─ fecha         
├─ ejercicios (array con nombre, grupo, repeticiones, peso)         
├─ kcal_quemadas`
```

---

## 📱 **10. Estructura de pantallas (wireframes conceptuales)**

### 🏠 Pantalla principal

- Resumen de tareas del día.
- Acceso rápido a calendario, rutinas, diario y gym.
- Estadísticas rápidas.

### 📅 Calendario

- Vista mensual y semanal.
- Añadir evento/tarea desde el calendario.

### ✅ Tareas

- Lista completa.
- Filtros por prioridad, fecha y estado.

### 🔁 Rutinas

- Listado y progreso.
- Crear/editar rutinas.

### 📝 Diario

- Lista de entradas por fecha.
- Crear nueva entrada.

### 💪 Gym

- Lista de sesiones. 
- Crear sesión con ejercicios y kcal.

### 💖 Ciclo
- Vista de ciclo actual y próximos.
- Registro de síntomas.

### ⚙️ Perfil y ajustes

- Configuración general.
- Notificaciones y sincronización.
- Gestión de cuenta.

---

## 💻 **11. Tecnologías**

### **Frontend**

- Flutter (Dart) → Multiplataforma nativo (Android, iOS, Web, Desktop).

### **Backend**

- Firebase (Firestore, Authentication, Cloud Storage, Cloud Messaging).
- SQLite (modo local/offline).

### **Extras**

- Notificaciones: Firebase Cloud Messaging.
- Control de versiones: Git (GitHub o GitLab).

---

## 🚀 **12. MVP para TFG**

✔ Login y perfil.  
✔ Tareas y calendario.  
✔ Rutinas.  
✔ Diario.  
✔ Gym básico.  
✔ Sincronización y offline.  
✔ Notificaciones.  
✔ Seguimiento de ciclo (opcional, recomendado).

---

## 🔥 **13. Funcionalidades post-TFG**

- Exportar datos (PDF/Excel).
- Widgets avanzados.
- Integración con Google Calendar / Apple Calendar.
- Comunidad y retos sociales.
- Planificación de objetivos anuales.

---

## ✅ **14. Valor diferencial**

- Unifica productividad y bienestar físico/mental. 
- Verdaderamente multiplataforma (un solo código).
- Diseño minimalista, moderno y adaptable.
- Modular y preparado para nuevas funcionalidades futuras.

---