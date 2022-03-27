# new feature
# Tags: optional

Feature: Comentarios de usuarios en los post
  Como usuario de la pagina web de JSONPlaceholder
  debo poder realizar acciones en comentarios de los post
  que me permitan expresar mi opinion

  Background: Acceso al recurso
    Given que el usuario estoy en el recurso web de la pagina

  Scenario: Modificar nombre y cuerpo de un comentario
    When se quiere modificar un mensaje identificado por id= "10" y se cambia el nombre por "Viaje a suiza" y el cuerpo por "Muy divertido y emocionante"
    Then se observa que el contenido que se modifico se ha actualizado correctamente

    Scenario Outline: Crear un nuevo comentario en un post
      When se quiere escribir un nuevo mensaje para el post con id <idPost> y escribo el nombre del mensaje, un email y el cuerpo
      Then se observa que el mensaje se ha creado correctamente
    Examples:
      |idPost|
      |2|
      |4|
      |6|