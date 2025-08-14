import ejerciciosCiclos.*
import ejerciciosCondicionales.*

fun main() {
    var salir = false

    while (!salir) {
        println("+-----------------------------------------------------------------------+")
        println("|     Ingrese qué ejercicios de los talleres desea ver                  |")
        println("+-----------------------------------------------------------------------+")
        println("|     1. Para taller de Condicionales | Fundamenteos 2                  |")
        println("|     2. Para taller de ciclos        | Fundamenteos 3                  |")
        println("|     3. Para salir del programa                                        |")
        println("+-----------------------------------------------------------------------+")
        print("Opción: ")
        val opcion = readln().toInt()

        when (opcion) {
            1 -> {
                var menuPrincipal1 = false
                while (!menuPrincipal1) {
                    println("+-----------------------------------------------------------------------+")
                    println("|        Ingrese el número para el ejercicio a realizar                 |")
                    println("+-----------------------------------------------------------------------+")
                    println("|   1. Para ejercicio 1 - Nota del 0 al 100                             |")
                    println("|   2. Para ejercicio 2 - Edad y Nota para beca                         |")
                    println("|   3. Para ejercicio 3 - Estrato y tarifas                             |")
                    println("|   4. Para ejercicio 4 - rango e nacimiento por DNI                    |")
                    println("|   5. Para ejercicio 5 - Puntaje según edad y nivel académico          |")
                    println("|   6. Para ejercicio 6 - Calculadora y verificar 0                     |")
                    println("|   7. Para ejercicio 7 - temperatura                                   |")
                    println("|   8. Volver al menú principal                                         |")
                    println("+-----------------------------------------------------------------------+")
                    print("Opción: ")
                    val subOpcion = readln().toInt()

                    when (subOpcion) {
                        1 -> ejerciciosCiclos.ejercicio1()
                        2 -> ejerciciosCiclos.ejercicio2()
                        3 -> ejerciciosCiclos.ejercicio3()
                        4 -> ejerciciosCiclos.ejercicio4()
                        5 -> ejerciciosCiclos.ejercicio5()
                        6 -> ejerciciosCiclos.ejercicio6()
                        7 -> ejerciciosCiclos.ejercicio7()
                        8 -> menuPrincipal1 = true
                        else -> println("Opción inválida")
                    }
                }
            }

            2 -> {
                var menuPrincipal2 = false
                while (!menuPrincipal2) {
                    println("+-----------------------------------------------------------------------+")
                    println("|        Ingrese el número para el ejercicio a realizar                 |")
                    println("+-----------------------------------------------------------------------+")
                    println("|   1. Para ejercicio 1 - Obtener tabla de multiplicar                  |")
                    println("|   2. Para ejercicio 2 - Mostrar suma de números pares                 |")
                    println("|   3. Para ejercicio 3 - Llegar de número A a número B                 |")
                    println("|   4. Para ejercicio 4 - Calificación final                            |")
                    println("|   5. Para ejercicio 5 - Cálculo de fiesta                             |")
                    println("|   6. Para ejercicio 6 - Lista de productos                            |")
                    println("|   7. Volver al menú principal                                         |")
                    println("+-----------------------------------------------------------------------+")
                    print("Opción: ")
                    val subOpcion = readln().toInt()

                    when (subOpcion) {
                        1 -> ejerciciosCondicionales.ejercicio1()
                        2 -> ejerciciosCondicionales.ejercicio2()
                        3 -> ejerciciosCondicionales.ejercicio3()
                        4 -> ejerciciosCondicionales.ejercicio4()
                        5 -> ejerciciosCondicionales.ejercicio5()
                        6 -> ejerciciosCondicionales.ejercicio6()
                        7 -> menuPrincipal2 = true
                        else -> println("Opción inválida")
                    }
                }
            }

            3 -> {
                println("Fin del programa")
                salir = true
            }

            else -> println("Opción inválida")
        }
    }
}
