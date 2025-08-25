fun main() {
    ejercicio4()
}

fun ejercicio1() {
    print("¿Cuántos números quieres ingresar?: ")
    var numIngreso = readln().toInt()
    var arrayNumeros = Array(numIngreso) { 0 }
    var suma = 0

    for (i in arrayNumeros.indices) {
        print("Ingresa el número para la posición $i: ")
        arrayNumeros[i] = readln().toInt()
        suma += arrayNumeros[i]
    }

    println("La suma es $suma")
    println()
    println("Números infresados")
    for ((clave, valor) in arrayNumeros.withIndex()) {
        println("Posición $clave : $valor")
    }
}

fun ejercicio2() {
    print("¿Cuántos elementos deseas ingresar?: ")
    val numIngreso = readln().toInt()

    if (numIngreso <= 0) {
        println("Debes ingresar un número mayor a 0.")
    }

    val arrayDeString = Array(numIngreso) { "" }
    var i = 0
    while (i < numIngreso) {
        print("Ingresa el elemento para la posición $i: ")
        var elemento = readln().toString()
        arrayDeString[i] = elemento
        i++
    }

    println("Las cadenas que ingresaste son: ")
    for ((index, cadena) in arrayDeString.withIndex()) {
        println("Posición $index -> $cadena")
    }
}

fun ejercicio3() {
    print("¿Cuántos elementos String deseas ingresar?: ")
    val elementos = readln().toInt()
    val listaDeString = mutableListOf<String>()

    var i = 0
    while (i < elementos) {
        print("Ingresa el número para la posición $i: ")
        listaDeString.add(readln())

        println("¿Deseas continuar? (s/n)")
        val continuar = readln().lowercase()
        if (continuar == "n") {
            break
        }
        i++
    }

    println("Elementos ingresados:")
    for ((indice, valor) in listaDeString.withIndex()) {
        println("$indice -> $valor")
    }
}

fun ejercicio4() {
    print("Ingrese la cantidad de aprendices que desea ingresar: ")
    val numAprendices = readln().toIntOrNull()

    val nombreAprendiz = mutableListOf<String>("")
    val edadAprendiz = mutableListOf<Int>(0)
    val generoAprendiz = mutableListOf<String>("")
    val programaEstudio = mutableListOf<String>("")
    val jornadaEstudio = mutableListOf<String>("")

    var i = 1
    if (numAprendices != null) {
        while (i <= numAprendices) {
            print("Ingresa el nombre del aprendiz No.$i: ")
            nombreAprendiz.add(readln().toString().lowercase().replaceFirstChar { it.uppercase() })

            print("Ingresa la edad del aprendiz No.$i: ")
            edadAprendiz.add(readln().toInt())

            print("Ingresa el género del aprendiz No.$i: ")
            var genero = readln().toString().lowercase()
            if (genero == "m" || genero == "masculino"){
                generoAprendiz.add("Masculino")
            } else{
                generoAprendiz.add("Femenino")
            }

            println("Ingresa el programa de estudio del aprendiz No.$i: ")
            println("1. adso")
            println("2. TPS")
            println("3. curso complementario")
            print("Opción No: ")
            var opcionEstudio = readln().toIntOrNull()
            if (opcionEstudio != null){
                when(opcionEstudio){
                    1 -> programaEstudio.add("ADSO")
                    2 -> programaEstudio.add("TPS")
                    3 -> programaEstudio.add("Curso Complementario")
                    else -> null
                }
            }

            println("Ingresa la jornada de estudio del aprendiz No.$i: ")
            println("1. mañana")
            println("2. tarde")
            println("3. noche")
            println("4. madrugada")
            print("Opción No: ")
            var opcionJornada = readln().toIntOrNull()
            if (opcionJornada != null){
                when(opcionJornada){
                    1 -> jornadaEstudio.add("Mañana")
                    2 -> jornadaEstudio.add("Tarde")
                    3 -> jornadaEstudio.add("Noche")
                    4 -> jornadaEstudio.add("Madrugada")
                    else -> null
                }
            }
            i ++
        }

        val programasUnicos = listOf("ADSO", "TPS", "Curso Complementario")

        for (programa in programasUnicos) {
            println("Reporte $programa")
            for ((indice, valor) in programaEstudio.withIndex()) {
                if (valor == programa) {
                    println("Aprendiz No.: $indice")
                    println("Nombre: ${nombreAprendiz[indice]}")
                    println("Edad: ${edadAprendiz[indice]}")
                    println("Género: ${generoAprendiz[indice]}")
                    println("Programa: $valor")
                    println("Jornada: ${jornadaEstudio[indice]}")
                }
            }
        }
    }
}
