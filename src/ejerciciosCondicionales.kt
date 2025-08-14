package ejerciciosCondicionales

fun ejercicio1() {
    print("Ingrese un número para obtener su tabla de multiplicar (del 1 al 10): ")
    val numero = readln().toInt()

    for (i in 1..10) {
        println("$numero * $i = ${i * numero}")
    }
}

fun ejercicio2() {
    println("Programa para calcular números pares entre 97 y 1003")
    var suma = 0

    for (i in 97..1003) {
        if (i % 2 == 0) {
            println("Número par: $i")
        }

        if (i % 2 == 0) {
            suma += i
        }
    }

    println("La suma de los números es: $suma")
}

fun ejercicio3() {
    println("Programa que calcula el recorrido de número A a número B")
    print("Por favor ingrese un número entero A mayor: ")
    var numA = readln().toInt()

    print("Por favor ingrese un número entero B menor: ")
    var numB = readln().toInt()

    var a = 1

    if (numB > numA || numA == 0 || numB == 0) {
        println("Datos incorrectos, por favor vuelve a empezar")
    } else {
        for (i in numA downTo numB) {
            println("A$a = $i")
            a++
        }
    }
}

fun ejercicio4() {
    println("Programa que pide número de estudiantes, calcula nota final por cada uno y promedio")
    println("por favor ingrese el número de aprendices")
    var numEstudiantes = readln().toInt()
    var contador = 0
    var promedio = 0.0
    var sumaNotaFinal = 0.0

    for (contador in 1..numEstudiantes) {
        println("Ingrese la nota de su primer parcial")
        var parcial1 = readln().toDouble()
        println("Ingrese la nota de su segundo parcial")
        var parcial2 = readln().toDouble()
        println("Ingrese la nota de su tercer parcial")
        var parcial3 = readln().toDouble()

        var promedioParcial = ((parcial1 + parcial2 + parcial3) / 3) * 0.55

        println("Por favor ingrese su nota de el examen final")
        var eFinal = readln().toDouble()
        eFinal *= 0.30


        println("Por favor ingrese la nota de su trabajo final")
        var tFinal = readln().toDouble()
        tFinal *= 0.15

        var notaFinal = promedioParcial + eFinal + tFinal

        println("Nota final del estudiante $contador: $notaFinal")

        sumaNotaFinal += notaFinal
    }
    promedio = sumaNotaFinal / numEstudiantes


    println("Estudiantes ingresados: $numEstudiantes")
    print("Promedio = $promedio")
}

// Data class para crear plantillas
data class Aprendiz(
    //nombre, edad, genero, jornada
    val nombre: String,
    val edad: Int,
    val genero: String,
    val jornada: String,
    val entrada: Boolean
)

fun ejercicio5() {
    val listaAprendices = mutableListOf<Aprendiz>()

    println("¿Cuantos aprendices desea ingresar?")
    val numAprendices = readln().toInt()

    for (i in 1..numAprendices) {
        println("\nAprendiz #$i: ")
        print("Nombre: ")
        val nombre = readln().toString()

        print("Edad: ")
        val edad = readln().toInt()

        val entrada = edad >= 17

        println("Género: ")
        println("M para masculino / F para femenino")
        val genero = readln().lowercase().toString()

        println("Jornada: ")
        println("+---------------------+")
        println("|   M = mañana        |")
        println("|   T = tarde         |")
        println("|   N = noche         |")
        println("|   Ma = madrugada    |")
        println("+---------------------+")
        val jornada = readln().lowercase().toString()

        listaAprendices.add(Aprendiz(nombre, edad, genero, jornada, entrada))
    }

    // contadores
    var genMasculino = 0
    var genFemenino = 0
    var manana = 0
    var tarde = 0
    var noche = 0
    var madrugada = 0

    // contar genero
    for (Aprendiz in listaAprendices) {
        if (Aprendiz.genero == "Masculino") {
            genMasculino++
        } else if (Aprendiz.genero == "Femenino") {
            genFemenino++
        }

        // contar  jornada
        if (Aprendiz.jornada == "Mañana") {
            manana++
        } else if (Aprendiz.jornada == "Tarde") {
            tarde++
        } else if (Aprendiz.jornada == "Noche") {
            noche++
        } else if (Aprendiz.jornada == "Madrugada") {
            madrugada++
        }
    }

    println("+-------------------------------------------------------+")
    println("|    Lista de aprendices ingresados                     |")
    println("+-------------------------------------------------------+")
    for (Aprendiz in listaAprendices) {
        // Pregunta entrada
        val pregEntrada = if (Aprendiz.entrada) "Si puede" else "No puede"
        println("+---------------------+---------------------------------+")
        println("|    Nombre:          |   ${Aprendiz.nombre}            |")
        println("+---------------------+---------------------------------+")
        println("|    Edad:            |   ${Aprendiz.edad}              |")
        println("+---------------------+---------------------------------+")
        println("|    Género:          |   ${Aprendiz.genero}            |")
        println("+---------------------+---------------------------------+")
        println("|    Jornada:         |   ${Aprendiz.jornada}           |")
        println("+---------------------+---------------------------------+")
        println("|    ¿Puede entrar?:  |   $pregEntrada                  |")
        println("+---------------------+---------------------------------+")
    }

    // variables para promedio
    var sumaEdadesHombres = 0
    var sumaEdadesMujeres = 0
    var conteoHombres = 0
    var conteoMujeres = 0

    // promedio edades y excluir los menores de edad
    for (i in 1..numAprendices) {
        if (listaAprendices[i - 1].entrada) {
            if (listaAprendices[i - 1].genero == "m") {
                sumaEdadesHombres += listaAprendices[i - 1].edad
                conteoHombres += 1
            } else if (listaAprendices[i - 1].genero == "f") {
                sumaEdadesMujeres += listaAprendices[i - 1].edad
                conteoMujeres += 1
            }
        }
    }

    // Variables para edad
    var promedioEdadHombres = 0
    var promedioEdadMujeres = 0

    if (conteoHombres > 0) {
        promedioEdadHombres = sumaEdadesHombres / conteoHombres
    }

    if (conteoMujeres > 0) {
        promedioEdadMujeres = sumaEdadesMujeres / conteoMujeres
    }

    println("+---------------------------------+-------+")
    println("|     Cantidad Hombres            |  $genMasculino   |")
    println("+---------------------------------+-------+")
    println("|     Cantidad Mujeres            |  $genFemenino    |")
    println("+---------------------------------+-------+")
    println("|  Promedio edad de Hombres       |  $promedioEdadHombres    |")
    println("+---------------------------------+-------+")
    println("|  Promedio edad de Mujeres       |  $promedioEdadMujeres    |")
    println("+---------------------------------+-------+")
    println("|  Cantidad aprendices mañana     |  $manana    |")
    println("+---------------------------------+-------+")
    println("|  Cantidad aprendices tarde      |  $tarde    |")
    println("+---------------------------------+-------+")
    println("|  Cantidad aprendices noche      |  $noche    |")
    println("+---------------------------------+-------+")
    println("|  Cantidad aprendices madrugada  |  $manana    |")
    println("+---------------------------------+-------+")
}

fun ejercicio6() {
    println("Lista para ingresar productos")

    val listaProductos = mutableListOf<String>()

    println("¿Cuantos elementos vas a ingresar a la lista?")
    val cantidad = readln().toInt()

    for (i in 1..cantidad) {
        println("Ingresa el elemento #$i")
        val elemento = readln()
        listaProductos.add(elemento)
    }

    println("\n----- Lista de productos -----")
    for (producto in listaProductos) {
        println("- $producto")
    }
}