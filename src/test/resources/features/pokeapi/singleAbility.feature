# new feature
# Tags: optional

Feature: Habilidades de pokemon
  Como fan de pokemon
  quiero buscar informacion sobre una habilidad de los pokemon
  para tener mas informacion del mundo pokemon

  Scenario Outline: Pokemon que posee una habilidad
    Given que el fan se encuentra en el recurso web adecuado para buscar informacion sobre pokemon
    When el usuario genera la consulta indicando la habilidad "<porIdONombre>"
    Then observa que uno de los pokemon que tiene esa habilidad es "<nombrePokemon>"
    Examples:
      | porIdONombre | nombrePokemon |
      | stench       | gloom         |
      | insomnia     | ariados       |
      | 10           | lanturn       |