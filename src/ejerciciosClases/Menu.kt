package ejerciciosClases;

fun Menu() {
    var salir = false

    while (!salir) {
        println("+--------------------------------------------------------------------------+")
        println("|           Ingrese el número para el ejercicio a realizar                 |")
        println("+--------------------------------------------------------------------------+")
        println("|   1. Ejercicio 1 - Círculo (área y perímetro)                            |")
        println("|   2. Ejercicio 2 - Estudiante (aprobado/reprobado)                       |")
        println("|   3. Ejercicio 3 - Cuenta bancaria                                       |")
        println("|   4. Ejercicio 4 - Lista de productos                                    |")
        println("|   5. Ejercicio 5 - Verificación de libro antiguo                         |")
        println("|   6. Ejercicio 6 - Registro de contactos                                 |")
        println("|   7. Volver al menú principal                                            |")
        println("+--------------------------------------------------------------------------+")
        print("Opción: ")

        val opcion = readln().toInt()

        when (opcion) {
            1 -> {
                println("+----------------------------+")
                println("|  EJERCICIO 1:   CÍRCULO    |")
                println("+----------------------------+")
                print("Ingrese el radio del círculo: ")
                val radio = readln().toDouble()
                val circulo = Circulo(radio)
                println("El perímetro del círculo es de ${circulo.calcularPerimetro()} y el área es de ${circulo.calcularArea()}")
            }

            2 -> {
                println("+-------------------------------+")
                println("|  EJERCICIO 2:   ESTUDIANTE    |")
                println("+-------------------------------+")
                print("Ingrese su nombre: ")
                val nombre = readln().toString().lowercase().replaceFirstChar { it.uppercase() }
                print("Ingrese su nota: ")
                val nota = readln().toDouble()
                val estudiante = Estudiante(nombre, nota)
                println(estudiante.aprobar())
            }

            3 -> {
                println("+-----------------------------------+")
                println("|  EJERCICIO 3:   CUENTA BANCARIA   |")
                println("+-----------------------------------+")
                print("Ingrese el titular: ")
                val titular = readln().toString().lowercase().replaceFirstChar { it.uppercase() }
                print("Ingrese su saldo inicial: ")
                val saldoInicial = readln().toDouble()
                val cuenta = CuentaBancaria(titular, saldoInicial)
                println(cuenta.movimientos())
            }

            4 -> {
                println("+--------------------------------+")
                println("|  EJERCICIO 4:   PRODUCTOS      |")
                println("+--------------------------------+")
                print("¿Cuántos productos quieres ingresar?: ")
                val numProductos = readln().toInt()
                val productos = mutableListOf<Producto>()
                var total = 0

                for (i in 1..numProductos) {
                    println("\nProducto $i")
                    print("Ingrese el nombre del producto: ")
                    val nombre = readln().toString().lowercase().replaceFirstChar { it.uppercase() }

                    print("Ingrese el precio del producto: $")
                    val precio = readln().toInt()

                    val producto = Producto(nombre, precio)
                    productos.add(producto)
                    total += precio
                }

                println("\n--- Lista de productos ---")
                for (p in productos) {
                    println("Nombre: ${p.nombre} | Precio: $${p.precio}")
                }
                println("\nEl total de la compra es: $$total")
            }

            5 -> {
                println("+--------------------------------+")
                println("|  EJERCICIO 5:   LIBRO ANTIGUO  |")
                println("+--------------------------------+")
                print("Título del libro: ")
                val titulo = readln().toString().lowercase().replaceFirstChar { it.uppercase() }
                print("Autor del libro: ")
                val autor = readln().toString().lowercase().replaceFirstChar { it.uppercase() }
                print("Año de publicación (YYYY): ")
                val publicacion = readln().toInt()
                val esAntiguo = EsAntiguo(titulo, autor, publicacion)
                println(esAntiguo.verificacion())
            }

            6 -> {
                println("+---------------------------------+")
                println("|  EJERCICIO 6:   CONTACTOS       |")
                println("+---------------------------------+")
                var contador = 1
                while (contador <= 5) {
                    println("\nContacto $contador")
                    print("Ingrese el nombre: ")
                    val nombre = readln().toString().lowercase().replaceFirstChar { it.uppercase() }
                    print("Ingrese el teléfono: ")
                    val telefono = readln()
                    Contacto.registrar(nombre, telefono)
                    contador++
                }
                Contacto.mostrarContactos()
            }

            7 -> {
                println("Volviendo al menú principal...")
                salir = true
            }

            else -> println("Opción inválida")
        }
    }
}
