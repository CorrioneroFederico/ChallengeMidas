# ChallengeMidas

El siguiente challenge fue proporcionado por Midas Consultores SA.
El objetivo del challenge fue desarrollado en lenguaje Java (Ver. 8+) utilizando el framework Spring. Para el cumplmiento del objetivo utilicé los siguiente criterios:
* Uso el patron MVC (Model-View-Controller) sin la necesidad de la vista ya que el objetivo es el desarrollo solo de la API (backend).
* Se implementó como medida de seguridad Spring Security para el Login y Autenticación.
* Para la base de datos decidí utilizar la provista por Spring (H2), esta es una bas de datos en memoria provista por el framework esto con la intención de poder probarse sin necesidad de descargar una BD para su prueba.
* Para la persistencia de los datos se utilizado Hibernate.
* Las pruebas realizadas fueron hechas en POSTMAN con la direccion base de "http://localhost:8080/", y las rutas pertinentes a cada controlador "usuario", "carrito" y "producto". Ejemplo: http://localhost:8080/producto/listar

Enunciado del ejercicio:

Necesitamos desarrollar las API, para la parte backend de un sistema de una tienda que permita a los usuarios registrarse, iniciar sesión, ver productos disponibles, agregarlos a su carrito de compras para realizar pedidos.

Para simplificar, sólo consideraremos dos tipos de usuarios: los clientes y los administradores

Los administradores pueden:

-          Realizar abm de productos 

-          Ver la lista de todos los usuarios registrados en el sistema.

-          Ver la lista de todos los pedidos realizados en el sistema.

 

Los clientes pueden:

-          Registrarse

-          Iniciar sesión

-          Listar todos los productos

-          Realizar pedidos de productos disponibles en la tienda.

 

Se valora el uso de excepciones, documentación de código como así también la incorporación de otras herramientas/framework o todo aquello que consideres.
