#Products Project MCA#
<em> Author: Inmaculada C. Jiménez Almeda </em>

----
####Ejecución del proyecto####

**Requerimientos:**

- Java: Version 16
- Docker
- Maven
- Los puertos 5000 y 3001 deben estar liberados

**Pasos a seguir:**

1º Compilar la aplicación ejecutando en la carpeta raíz del proyecto: </br>
>`mvn clean install -Dmaven.test.skip=true`

2º Entrar en la carpeta de products-back: </br>
>`cd ./products-back`

3º Construir la imagen en docker ejecutando: </br>
>`docker build --tag=products-project:latest .`

4º Volver a la carpeta raíz: </br>
>`cd ..`

5º Ejecutar el comando que monta el contenedor docker de la aplicación y la arranca: </br>
>`docker run -p5000:5000 products-project:latest`

6º Acceder a la siguiente URL de Swagger para probar la aplicación: </br>
>` http://localhost:5000/swagger-ui/index.html`

Para la ejecución de los test ejecutar el comando en la carpeta products-back: </br>
>`mvn test`

----

#####Ejemplos de peticiones:#####

_Peticiones OK:_

>`http://localhost:5000/product/1/similar`
>`http://localhost:5000/product/2/similar`

_Petición KO:_
>`http://localhost:5000/product/1000/similar`

----











