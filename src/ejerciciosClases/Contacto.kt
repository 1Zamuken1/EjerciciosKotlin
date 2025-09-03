package ejerciciosClases

class Contacto(var nombre: String, var telefono: String) {
    companion object {
        var listaContactos = mutableListOf<Contacto>()

        fun registrar(nombre: String, telefono: String) {
            val contacto = Contacto(nombre, telefono)
            listaContactos.add(contacto)
        }

        fun mostrarContactos() {
            println("\n--- Lista de contactos registrados ---")
            var i = 0
            while (i < listaContactos.size) {
                val c = listaContactos[i]
                println("Nombre: ${c.nombre} | Teléfono: ${c.telefono}")
                i++
            }
        }
    }
}