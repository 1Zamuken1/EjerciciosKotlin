package Entregable

import kotlin.random.Random

fun main() {
    tienda()
}

fun tienda() {
    // Variable global para acumular el historial de todas las sesiones
    val historialComprasGlobal = mutableListOf<Pair<Int, Triple<String, Int, Int>>>()

    val categorias = mapOf(
        1 to "Perecederos",
        2 to "Aseo",
        3 to "Perfumeria",
        4 to "Abarrotes"
    )

    val productos = mapOf(
        // Perecederos
        1 to mapOf(
            1 to ("Tomate" to 500),
            2 to ("Lechuga" to 3000),
            3 to ("Cebolla" to 600),
            4 to ("Huevos" to 200),
            5 to ("Leche" to 2000)
        ),
        // Aseo
        2 to mapOf(
            1 to ("Escoba" to 2000),
            2 to ("Jabón" to 2000),
            3 to ("Trapero" to 2500),
            4 to ("Recogedor" to 2000),
            5 to ("Soflan" to 1500)
        ),
        // Perfumería
        3 to mapOf(
            1 to ("HugoBoss" to 50000),
            2 to ("Clavin Klein" to 60000),
            3 to ("Giorgio Armani" to 70000),
            4 to ("Chanel" to 80000),
            5 to ("Carolina Herrera" to 90000)
        ),
        // Abarrotes
        4 to mapOf(
            1 to ("Arroz" to 2000),
            2 to ("Fríjoles" to 2000),
            3 to ("Aceite" to 1800),
            4 to ("Azucar" to 2000),
            5 to ("Harina" to 2000)
        )
    )

    fun factura(nombreCliente: String, DNI: Int, carrito: List<Triple<String, Int, Int>>){
        val factura = Random.nextInt(1000, 9999)
        println("+-------------------------------------------------------------+")
        println("|                     Juan's & asociados                      |")
        println("+-------------------------------------------------------------+")
        println("|   Factura No.: $factura                                     |")
        println("+-------------------------------------------------------------+")
        println("|   Nombre del Cliente: $nombreCliente                        |")
        println("+-------------------------------------------------------------+")
        println("|   Identificación: $DNI                                      |")
        println("+-------------------------------------------------------------+")
        println("")
        println("+-------+----------+-----------------+-------+")
        println("| Clave | Cantidad | Precio Unitario | Total |")
        println("+-------+----------+-----------------+-------+")
        var totalGeneral = 0
        for ((index, item) in carrito.withIndex()){
            val clave = index + 1
            val producto = item.first
            val cantidad = item.second
            val total = item.third
            val precioUnitario = total / cantidad

            println("| $clave  | $cantidad  | $precioUnitario  | $total |")
            println("+-------+----------+-----------------+-------+")
            totalGeneral += total
        }

        println("+--------------------------------------+")
        println("| Total de la compra: $totalGeneral    |")
        println("+--------------------------------------+")
    }

    fun cajero(historialCompras: List<Pair<Int, Triple<String, Int, Int>>>, categorias: Map<Int, String>) {
        val totalCategoria = mutableMapOf<Int, Int>()
        val cantidadCategoria = mutableMapOf<Int, Int>()
        var totalGeneral = 0

        // Verificar si hay compras registradas
        if (historialCompras.isEmpty()) {
            println("+-------------------------------------------+")
            println("|  No hay compras registradas para mostrar. |")
            println("+-------------------------------------------+")
            return
        }

        for ((categoria, triple) in historialCompras){
            val cantidad = triple.second
            val total = triple.third

            cantidadCategoria[categoria] = cantidadCategoria.getOrDefault(categoria, 0) + cantidad
            totalGeneral += total
        }

        println("+-------------------------------------------+")
        println("|               Resumen del día             |")
        println("+-------------------------------------------+")
        for ((id, nombreCategoria) in categorias) {
            val cantidad = cantidadCategoria.getOrDefault(id, 0)
            if (cantidad > 0) {
                println("|  Categoría: $nombreCategoria              |")
                println("+-------------------------------------------+")
                println("|  Cantidad total vendida: $cantidad        |")
                println("+-------------------------------------------+")
                // Aquí calculamos el total por categoría
                var totalCat = 0
                for ((cat, triple) in historialCompras) {
                    if (cat == id) {
                        totalCat += triple.third
                    }
                }
                println("+-------------------------------+")
                println("|   Total vendido: $$totalCat   |")
                println("+-------------------------------+")
                println()
            }
        }
        println("")
        println("+-----------------------------------------+")
        println("|  Total general del día: $$totalGeneral  |")
        println("+-----------------------------------------+")
    }

    fun cliente(): List<Pair<Int, Triple<String, Int, Int>>> {
        print("Por favor ingresa tu nombre: ")
        val nombre = readln().toString()
        print("Por favor ingresa tu identificación: ")
        val DNI = readln().toInt()
        println("Bienvenido $nombre")

        // Mostrar categorías
        println("Estas son las categorías de productos que tenemos a la venta: ")
        for ((id, nombre) in categorias) {
            println("$id para $nombre")
        }

        // Repetir ciclo hasta que la opcion del usuario sea correcta
        var comprando = true
        // Lista para el carrito, Triple petición para nombre, cantidad y precio
        val carrito = mutableListOf<Triple<String, Int, Int>>()
        // historial de compras para el cajero (SE MANTIENE AQUÍ)
        val historialCompras = mutableListOf<Pair<Int, Triple<String, Int, Int>>>()

        while (comprando) {
            println("Por favor ingrese el número de categoría del que quiere ver y comprar productos:")
            val opcionCategoria =
                readln().toIntOrNull() // toIntOrNull() convierte a número e impide que haya errores con letras

            if (opcionCategoria != null && productos.containsKey(opcionCategoria)) { //Confirmación de que se ingrese un numero && el numero debe estar entre los de categoria
                val productosCategoria = productos[opcionCategoria]!! // El !! es para cofnfirmar que no va a ser nulo
                println("Productos disponibles en ${categorias[opcionCategoria]}: ")
                for ((id, producto) in productosCategoria) {
                    println("$id. ${producto.first} -> $${producto.second}")
                }
                println("Oprime 0 para finalizar la compra")

                var seguirCompra = true
                while (seguirCompra){
                    print("Ingresa el número del producto que quieres comprar: ")
                    val opcionProducto = readln().toIntOrNull()

                    if (opcionProducto == 0) {
                        seguirCompra = false
                    } else if (opcionProducto != null && productosCategoria.containsKey(opcionProducto)){
                        val productoSeleccionado = productosCategoria[opcionProducto]!!

                        print("¿Cuántas unidades de ${productoSeleccionado.first} desea comprar?: ")
                        val cantidad = readln().toIntOrNull() ?: 0

                        if (cantidad > 0){
                            val totalCompra = cantidad * productoSeleccionado.second
                            carrito.add(Triple(productoSeleccionado.first, cantidad, totalCompra))
                            // Guardamos historial (SE MANTIENE EN LA FUNCIÓN CLIENTE)
                            historialCompras.add(Pair(opcionCategoria, Triple(productoSeleccionado.first, cantidad, totalCompra)))
                            println("Se añadieron $cantidad de ${productoSeleccionado.first} al carrito")
                        } else {
                            println("Cantidad inválida.")
                        }
                    } else {
                        println("Producto inválido.")
                    }

                    if (seguirCompra) {
                        println("¿Desea comprar algo más en esta categoría? (s/n)")
                        val respuesta = readln().lowercase()
                        if (respuesta != "s") {
                            seguirCompra = false
                        }
                    }
                }
            } else {
                println("Opción inválida, intente de nuevo.")
            }

            // Carrito
            println("Carrito de compras")
            if (carrito.isEmpty()){
                println("Tu carrito está vacío.")
            } else {
                var totalGeneral = 0
                for ((producto, cantidad, totalCompra) in carrito){
                    println("- $producto x $cantidad = $totalCompra")
                    totalGeneral += totalCompra
                }
                println("Total: $totalGeneral")
            }

            println("¿Qué deseas hacer ahora?")
            println("1. Para confirmar compra")
            println("2. Eliminar producto del carrito")
            println("3. Seguir comprando")
            val opcionCarrito = readln().toIntOrNull()

            when (opcionCarrito){
                1 -> {
                    if (carrito.isEmpty()){
                        println("No puedes confirmar una compra vacía.")
                    } else{
                        println("Compra confirmada.")
                        factura(nombre, DNI, carrito)
                        // Ya no llamamos cajero aquí, solo retornamos el historial
                        comprando = false
                    }
                }
                2 -> {
                    if (carrito.isEmpty()){
                        println("No hay productos para eliminar.")
                    } else {
                        println("Elige un producto para eliminar: ")
                        for ((index, producto) in carrito.withIndex()){
                            println("${index + 1}. ${producto.first} x ${producto.second} = ${producto.third}")
                        }
                        val opcionEliminar = readln().toIntOrNull()
                        if (opcionEliminar != null && opcionEliminar in 1 .. carrito.size){
                            val eliminado = carrito.removeAt(opcionEliminar - 1)
                            println("Se eliminó ${eliminado.first} del carrito.")
                            // También eliminar del historial
                            historialCompras.removeIf { it.second.first == eliminado.first }
                        } else {
                            println("Opción inválida.")
                        }
                    }
                }
                3 -> {
                    println("Puedes seguir comprando en otra categoría.")
                }
                else -> println("Opción inválida, intente de nuevo.")
            }
        }

        return historialCompras
    }

    //Menú principal
    var continuarPrograma = true
    while (continuarPrograma) {
        println(" MENÚ PRINCIPAL ")
        println("¿Eres cliente o cajero?")
        println("1. Para cliente")
        println("2. Para cajero")
        println("3. Salir")
        val usuario = readln().toIntOrNull()

        when (usuario) {
            1 -> {
                val historialSesion = cliente()
                // Agregar el historial de esta sesión al historial global
                historialComprasGlobal.addAll(historialSesion)
            }

            2 -> {
                cajero(historialComprasGlobal, categorias)
            }

            3 -> {
                println("¡Gracias por usar nuestro sistema!")
                continuarPrograma = false
            }

            else -> println("¡Error! por favor ingresa una opción válida")
        }
    }
}