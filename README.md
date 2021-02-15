# Gestor de voluntarios para emergencia en Chile

Para efectos del laboratorio 3 de Taller de Bases de Datos, se ha implementado un Backend que permite consultas concurrentes a servidores de base de datos relacionales utilizando _hashing_ para direccionar la información a su respectivo alojamiento de datos, además recurre a funcionalidades de una base de datos documental para crear instancias de consultas que permitan comprender el servicio que proveen, conocer sus principales característas y, particularmente, implementar los respectivos JOIN de consulta con aggregate.

## Comenzando 🚀

Las siguientes instrucciones permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas.

Mira **Deployment** para conocer como desplegar el proyecto.


## Herramientas de gestión 📌

* **Tablero Kanban** - https://trello.com/b/sNwyJ3Lm/backendtbd


## Despliegue 📦

En la elaboración del producto, se utilizó un servidor común de uso compartido alojado en Amazon Web Services, un servicio de computación en la nube pública ofrecidas a través de Internet por Amazon. Es en este ambiente donde se desarrollaron los procesos correspondientes a las bases de datos PostgreSql y MongoDB.

_Por seguridad los datos de acceso al servidor serán proveídos directamente a los revisores del laboratorio_

Se debe contar con Java 15 JRE (siglas de de Java Runtime Enviroment) y JDK (siglas de Java Developer Kit). Además se debe contar con la instalación de Gradle, utilizando IntelliJ IDEA Ultimate 2020.3 (https://www.jetbrains.com/es-es/idea/download/) se descargará e instalará automáticamente. Sin embargo, si se desea instalar Gradle de forma manual se deben seguir los siguientes pasos:
0.- Preparar entorno BD (Manejado con docker para simular 3 instancias de Postgres SQL y 1 de MongoDB)
   - Instalar docker en la maquina a trabajar
   (Ref. https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-on-ubuntu-20-04-es)
   - Instalar imagenes requeridas Postgres
   (Ref. https://ichi.pro/es/configuracion-de-desarrollo-local-de-postgresql-con-docker-211253925450730)
   (Ref. https://phoenixnap.com/kb/docker-mongodb)
   ```
   $ docker pull postgres
   $ docker pull mongo
   ```
   - Levantar y configurar contenedores requeridos Postgres
      -Crear directorio donde se almacenará la persistencia de cada DB
        ```
         $ mkdir ${HOME}/postgres-data1/
         $ mkdir ${HOME}/postgres-data2/
         $ mkdir ${HOME}/postgres-data3/
         ```
      -Configurar las tres instancias con su respectivo volumen donde persistirá, puerto habilitado, usuario, contraseña más el nombre asignado al contenedor.
         ```
         $ docker run -d --name dev-postgres1 -e POSTGRES_PASSWORD=xxxxxxxx -v ${HOME}/postgres-data1/:/var/lib/postgresql/data -p 54032:5432 postgres
         $ docker run -d --name dev-postgres2 -e POSTGRES_PASSWORD=xxxxxxxx -v ${HOME}/postgres-data2/:/var/lib/postgresql/data -p 54033:5432 postgres
         $ docker run -d --name dev-postgres3 -e POSTGRES_PASSWORD=xxxxxxxx -v ${HOME}/postgres-data3/:/var/lib/postgresql/data -p 54034:5432 postgres
         ```
      - Realizar Backup en cada DB (Repetir con cada id de contenedor y carpeta de persistencia en este caso dev-postgresX)
      (Ref. https://simkimsia.com/how-to-restore-database-dumps-for-postgres-in-docker-container/)
         ```
         $ docker cp Voluntariado_Backup.sql dev-postgres3:/var/lib/postgresql/data
         ```
         - Ejemplo de ejecucion de backup
         ```
         $ cat backup.sql | docker exec -i [POSTGRESQL_CONTAINER] /usr/bin/psql -h [POSTGRESQL_HOST] -U [POSTGRESQL_USER] [POSTGRESQL_DATABASE]
         $ cat Voluntariado_Backup.sql | docker exec -i [2b548f51af10] /usr/bin/psql -h [3.16.50.104] -U [postgres] [postgres]
         ```
   - Levantar y configurar contenedores requeridos Mongo
         ```
         $ sudo docker run -it -v ~/mongo-data:/data/db -p 27017:27017 --name mongodb -e MONGO_INITDB_ROOT_USERNAME=superAdmin -e MONGO_INITDB_ROOT_PASSWORD=a1b2c3d4 mongo
         ```
         
1.- Se debe descargar la versión de Gradle del siguiente link [https://gradle.org/releases/].

2.- Ubuntu 18.04 LTS y 20.04 LTS
   ```
   $ mkdir /opt/gradle
   $ unzip -d /opt/gradle gradle-6.7.1-bin.zip
   $ ls /opt/gradle/gradle-6.7.1
   LICENSE NOTICE bin getting-started.html init.d lib media
   ```
3.- Luego, configurar las variables de entorno del sistema.
   ```
   $ export PATH=$PATH:/opt/gradle/gradle-6.7.1/bin
   ```
   

## Construido con 🛠️

* [Spring boot](https://spring.io/projects/spring-boot) - El framework de Java
* [Gradle](https://gradle.org/) - Manejador de dependencias
* [Docker](https://www.docker.com/) - Automatizador de despligue de aplicaciones
* [PostgreSql](https://www.postgresql.org/) - Base de datos relacional
* [MongoDB](https://www.mongodb.com) - Base de datos documental


## Autores ✒️

* **Antonina Arriagada**
* **Rodrigo Arcos** 
* **Linda Muñoz**
* **Francisco Núñez**
* **Dennis Urrutia**
* **César Salazar**

---
⌨️ plantilla creada por [Villanuevand](https://github.com/Villanuevand) 😊
