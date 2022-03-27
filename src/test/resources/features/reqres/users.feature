# new feature
# Tags: optional

Feature: Administracion de usuarios
  Como administrador de la pagina REQ|RES
  puedo realizar acciones sobre los usuarios definidos para hacer test de API
  y asi poder mantener funcional la pagina


  Scenario Outline: Eliminar usuario
    Given que se tiene acceso al recurso web adecuado
    When quiero eliminar un usuario con id = <idUser>
    Then se tiene como resultado una peticion existosa
    Examples:
    |idUser|
    |1|
    |5|