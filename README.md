<h1>Products Project MCA</h1></br>
<em> Author: Inmaculada C. Jiménez Almeda </em>

----
<h3>Ejecución del proyecto</h3>

**Requerido:**

- Java: Version 16
- Docker
- Maven
- Los puertos 5000 y 3001 tienen que estar liberados

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

<h3>Ejemplos de peticiones:</h3>

_Peticiones OK:_

>`http://localhost:5000/product/1/similar` </br>
>`http://localhost:5000/product/2/similar`

_Petición KO:_
>`http://localhost:5000/product/1000/similar`

----











