@2@
Feature: :Automatizar flujo operacion planta
  yo como usuario de la pagina ROP, deseo ingresar a la opcion operacion planta con el fin de editar el registro del dia correctamente.

  @MetasOperativas
  Scenario: Editar registro del dia Correctamente.
    Given que el usuario se logea en la pagina Rop e ingresa a la opcion operacion planta.
    When El usuario edita el registro en el horario correspondiente
    Then El usuario puede visualizar el registro dentro del rango metas operativas.
