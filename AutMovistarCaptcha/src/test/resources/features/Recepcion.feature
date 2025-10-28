#language: es
Característica: Automatizar flujo Recepcion productos quimicos.
  yo como usuario de la pagina ROP, deseo ingresar a la opcion Recepcion/Despacho productos quimicos con el fin de Recepcionar una cantidad especifica de un producto quimico correctamente.
  @Recepcion
  Escenario: Recepcion producto quimico correctamente.
    Dado que el usuario se logea en la pagina Rop e ingresa a la opcion Recepcion-Despacho Productos Quimicos.
    Cuando El usuario seleccione una opcion nueva de recepcion, con el quimico asgindado, el proveedor y demas requisitos para la recepcion
    Entonces El usuario puede visualizar el registro de la cantidad total recebida.