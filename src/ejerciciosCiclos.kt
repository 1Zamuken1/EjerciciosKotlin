package ejerciciosCiclos

fun ejercicio1() {
    print("Por favor ingrese una nota del 0 al 100: ")
    var nota = readln().toInt()

    var rango = when (nota) {
        in 90..100 -> 'A'
        in 80..90 -> 'B'
        in 70..79 -> 'C'
        in 60..69 -> 'D'
        in 0..59 -> 'E'
        else -> "Ingrese una nota válida"
    }
    println("Su nota de $nota corresponde a una calificación de: $rango")
}

fun ejercicio2() {
    print("Por favor ingrese su edad: ")
    var edad = readln().toInt()
    print("Por favor ingrese su nota: ")
    var nota = readln().toInt()

    if (edad in 18..25 && nota in 80..100) {
        println("Felicidades has obtenido tu beca")
    } else {
        println("Lo sentimos, no has alcanzado la beca, vuelve en otro momento")
    }
}

fun ejercicio3() {
    print("Valor a Cancelar: ")
    var valor = readln().toDouble()

    print("Por favor ingrese su estrato del 1 al 6: ")
    var estrato = readln().toInt()

    if (estrato in 1..2) {
        var valCancelar = valor * 0.50
        println("Valor total a cancelar: $valCancelar")
        println("Mensaje: Obtiene el 50% de descuento")
    } else if (estrato in 3..4) {
        var valCancelar = valor * 1.0
        println("Valor total a cancelar: $valCancelar")
        println("Mensaje: Paga la tarifa normal")
    } else if (estrato in 5..6) {
        var valCancelar = valor * 1.25
        println("Valor total a cancelar: $valCancelar")
        println("Mensaje: Debe pagar 25% de recargo")
    }
}

fun ejercicio4() {
    print("Por favor ingrese su número de DNI para identificar su rango de nacimiento: ")
    var dni = readln().toInt()

    var rango = when (dni) {
        in 10000000..20000000 -> "entre 1950 a 1970"
        in 20000001..40000000 -> "entre 1971 a 1990"
        in 40000001..60000000 -> "entre 1991 a 2010"
        else -> "Error"
    }

    if (rango == "Error") {
        print("¡$rango!")
        println("Por favor ingrese un DNI válido")
    } else {
        println("Su DNI ingresado '$dni' corresponde al rango de nacimiento de $rango")
    }
}

fun ejercicio5() {
    fun menor(nivel: Int, edad: Int) {
        if (nivel == 1) {
            var puntaje = edad * 1.1
            println("Tu puntaje es de: $puntaje")
        } else if (nivel == 2) {
            var puntaje = edad * 1.3 + 5
            println("Tu puntaje es de: $puntaje")
        } else if (nivel == 3) {
            var puntaje = edad * 1.5 + 10
            println("Tu puntaje es de: $puntaje")
        }
    }

    fun adolescente(nivel: Int, edad: Int) {
        if (nivel == 1) {
            var puntaje = edad * 1.2
            println("Tu puntaje es de: $puntaje")
        } else if (nivel == 2) {
            var puntaje = edad * 1.4 + 10
            println("Tu puntaje es de: $puntaje")
        } else if (nivel == 3) {
            var puntaje = edad * 1.6 + 20
            println("Tu puntaje es de: $puntaje")
        }
    }

    fun anciano(nivel: Int, edad: Int) {
        if (nivel == 1) {
            var puntaje = edad * 1.0
            println("Tu puntaje es de: $puntaje")
        } else if (nivel == 2) {
            var puntaje = edad * 1.2 + 15
            println("Tu puntaje es de: $puntaje")
        } else if (nivel == 3) {
            var puntaje = edad * 1.4 + 25
            println("Tu puntaje es de: $puntaje")
        }
    }

    print("Por favor ingrese su edad: ")
    var edad = readln().toInt()

    println("Por favor ingrese su nivel educativo")
    println("1. Para Básico")
    println("2. Para Medio")
    println("3. Para Avanzado")
    var nivEdu = readln().toInt()

    var rango = when (edad) {
        in 0..18 -> menor(nivEdu, edad)
        in 19..25 -> adolescente(nivEdu, edad)
        else -> anciano(nivEdu, edad)
    }
}

fun ejercicio6() {
    println("Calculadora sencilla")
    println("Por favor ingrese 2 números:")

    print("Número 1: ")
    var num1 = readln().toDouble()

    print("Número 2: ")
    var num2 = readln().toDouble()

    println("Por favor indica qué quieres hacer con estos números")
    println("1. Para Sumar")
    println("2. Para Restar")
    println("3. Para multiplicar")
    println("4. Para Dividir")
    var opcion = readln().toInt()

    if (opcion == 4 && num2.toInt() == 0) {
        println("Para este caso, tu segundo número es 0, deseas cambiarlo?\nSi eliges no cambiarlo te mostrará un error")
        println("(Si / No)")
        var cambio = readln().lowercase()
        if (cambio == "si") {
            print("Por favor ingresa nuevamente el número 2:")
            num2 = readln().toDouble()

            if (num2.toInt() == 0) {
                println("¡Error!\nEstás intentando diidir entre 0")
            } else {
                var operacion = num1 / num2
                println("El resultado de tu división es de: $operacion")
            }
        } else {
            println("¡Error!\nNo se puede dividir entre 0")
        }
    } else {
        val (operacion, resultado) = when (opcion) {
            1 -> "Suma" to (num1 + num2)
            2 -> "Resta" to (num1 - num2)
            3 -> "Multiplicación" to (num1 * num2)
            4 -> "División" to (num1 / num2)
            else -> "Error, por favor ingresa una opción válida" to null
        }
        if (resultado != null) {
            println("El resultado de tu $operacion es: $resultado")
        } else {
            println("Error: opción no válida.")
        }
    }
}

fun ejercicio7() {
    println("Clasificación de temperatura")
    println("Por favor ingrese la temperatura en °C")
    print("°C: ")
    var temp = readln().toDouble()

    var clasificacion = when {
        temp <= 0.0 -> "congelante"
        temp in 1.0..10.0 -> "muy Fría"
        temp in 11.0..20.0 -> "fría"
        temp in 21.0..30.0 -> "templada"
        temp in 31.0..40.0 -> "caliente"
        temp > 40.0 -> "Peligroso"
        else -> "Error"
    }
    println("La temperatura $temp es considerada como $clasificacion")
}