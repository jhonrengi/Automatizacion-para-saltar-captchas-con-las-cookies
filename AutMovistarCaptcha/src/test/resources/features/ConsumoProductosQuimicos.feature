#language: es
Característica: Automatizar flujo consumo productos quimicos.
  yo como usuario de la pagina ROP, deseo ingresar a la opcion consumo productos quimicos con el fin de editar el registro del dia correctamente.
  @ProductosQuimicos
  Escenario: Editar registro del dia Correctamente.
    Dado que el usuario se logea en la pagina Rop e ingresa a la opcion Consumo Productos Quimicos.
    Cuando El usuario seleccione la fecha correspondiente, con el quimico asgindado y pueda edtiar el consumo del dia.
    Entonces El usuario puede visualizar un registro con la cantidad total calculada.