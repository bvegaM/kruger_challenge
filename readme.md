# KRUGER CHALLENGE

## Diseño del reto

Para resolver este problema utilizamos las siguientes tecnologías:

* Spring Framework:
  
  * Spring Boot
  
  * Spring Security
  
  * Spring Data JPA

* Open API + Swagger

* PostgreSQL

* docker (docker-compose)

Con estas tecnologías logramos que el desarrollo del reto sea lo más práctico posible y a corde a los requerimientos que se solicitaban.

## Como usarlo?

Para descargar el proyecto se tiene que realizar un clone del siguiente repositorio:

```git
git clone https://github.com/bvegaM/kruger_challenge.git
```

#### Configuración de la base de datos

##### Utilizar postgres con docker

Una vez descargado el proyecto es muy importante tomar en cuenta que su máquina debe contar con docker para correr la base de datos. Con ello puede dirigirse al proyecto y dentro de ello a la carpeta ```docker``` donde estara el docker-compose file. Para correr dicho archivo solamente se debe ejecutar el siguiente comando

```docker
docker-compose up -d
```

Con ello se levantara una base de datos postgres con la siguiente estructura:

```info
database: vaccines
user: kruger
password: kruger.123
port: 4358 (si necesitas otro puerto, puedes cambiarlo en el compose)
```

##### crear la base de datos

Con la base de datos cargada, se puede utilizar la base y su estructura haciendo uso del archivo schema.sql que se encuentra en la carpeta `docker` , con ello se cargara la siguiente estructura de base de datos.

![asd](/Users/bvegam/Documents/cursos/kruger_challenge/img/database_model.png)

Ademas de ello se crearan dos registros de roles los cuales serviran para el reto, es **muy importante** que esos dos registros esten creados.

#### Levantar el proyecto

Para ello de preferencia puede utilizar el IDE IntellIj si se lo desea. Antes de correr con el proyecto es muy importante hacer un build prevío, por esa razón recomiendo el uso de dicho IDE, ya que el gestor es Graddle y es más sencillo hacerlo en ese IDE, pero si prefieren, pueden hacerlo en eclipse o en el ide que les parezca conveniente.



Una vez levantado el proyecto se creara un usuario por defecto para que pueda crear empleados y utilizar el resto de endopoints. EL usuario tiene las siguientes credenciales.

* **user:** admin

* **password:** admin

Una vez levantado el proyecto, para consumir los servicios se lo realiza a traves del context-path `api/v1` y después el endpoint a consumir. Para hacerlo más sencillo esta la documentación con swagger, la cual se puede acceder utilizando el siguiente link:[Swagger UI](http://localhost:8080/api/v1/swagger-ui/index.html#/) . Con ello aparecera un sitio como el siguiente:

![aas](/Users/bvegam/Documents/cursos/kruger_challenge/img/swagger.png)

El admin puede consumir y acceder a todos los endpoint. Por otro lado un rol user solamente puede acceder al `/employee/update/`,`/dose/**`,  que son endpoints donde el usuario puede realizar consultas y creaciones. Esto lo pueden verificar en el archivo de configuración de seguridad del proyecto.



Ejemplo de creación de empleado:

```json
{
  "address": "cuenca",
  "dateBirth": "2022-06-14",
  "dni": "0150749059",
  "doses": [
    {
      "doseDate": "2022-06-14",
      "doseNumber": 2,
      "vaccine": "SPUTNIK"
    }
  ],
  "email": "bvega@gmail.com",
  "firstName": "bryam",
  "lastName": "vega",
  "phone": "0985164142",
  "vaccineStatus": true
}
```

Con ello se consume en el post de employee y se creara un empleado y su usuario que esta conformado por la primera letra de su nombre  y el resto de su apellido  y como contraseña su número de cedula.



Ante cualquier duda o pregunta hagamenlo saber y encantado los ayudare!!!! :D 



**NOTA:** Por falta de tiempo debido a diferentes motivos laborales y relacionados al estudio falto controlar los errores, por lo que tal vez ese punto no se presente una respuesta en caso de que exista un fallo en el servicio.
