Git es un **sistema de control de versiones distribuido** que permite gestionar y rastrear cambios en el código fuente de un proyecto. Es ampliamente utilizado en el desarrollo de software para coordinar el trabajo en equipo y mantener un historial de modificaciones.
## **Instalación de Git**

Para instalar Git en tu sistema:

- **Windows**: Descargar e instalar desde [git-scm.com](https://git-scm.com/)
- **Linux** (Debian/Ubuntu): `sudo apt install git`
- **macOS**: `brew install git`
## **Ramas y Fusión (Branching & Merging)**

Las ramas permiten trabajar en funcionalidades nuevas sin afectar la versión principal del código.

- Crear una nueva rama:
    `git branch nombre-rama`
- Cambiar a una rama específica:
    `git checkout nombre-rama`
- Crear y cambiar de rama en un solo paso:
    `git checkout -b nombre-rama`
- Fusionar una rama con la principal:
    `git checkout main git merge nombre-rama`
- Eliminar una rama:
    `git branch -d nombre-rama`
## **Trabajar con Repositorios Remotos**

Para conectar Git con un servicio como GitHub o GitLab se utilizan repositorios remotos.

- Agregar un repositorio remoto:
	`git remote add origin URL-del-repositorio`

- Subir cambios al repositorio remoto:
    `git push origin nombre-rama`
- Descargar los cambios más recientes:
    `git pull origin nombre-rama`
- Clonar un repositorio remoto:
	`git clone URL-del-repositorio`
## **7. Manejo de Historial y Revertir Cambios**

- Ver los commits anteriores:
    `git log --oneline --graph --all`
- Restaurar un archivo al último commit:
    `git checkout -- archivo`
- Deshacer el último commit (manteniendo los cambios en el área de trabajo):
    `git reset --soft HEAD~1`
- Deshacer el último commit (borrando los cambios):
    `git reset --hard HEAD~1`
- Revertir un commit específico:
    `git revert ID-del-commit`
## **8. Ignorar Archivos con `.gitignore`**

El archivo `.gitignore` permite especificar archivos o carpetas que no deben ser rastreados por Git.

Ejemplo de `.gitignore`:
`# Ignorar archivos compilados *.exe *.class  # Ignorar carpetas específicas /node_modules /build`
## **9. Etiquetas (Tags)**

Las etiquetas permiten marcar versiones específicas en un repositorio.

- Crear una etiqueta:
    `git tag -a v1.0 -m "Versión 1.0"`
- Ver las etiquetas disponibles:
    `git tag`
- Subir etiquetas a un repositorio remoto:
    `git push origin --tags`