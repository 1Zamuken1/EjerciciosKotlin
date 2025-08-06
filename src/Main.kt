fun main(){
    println("Ingrese el número para el ejercicio a realizar")
    println("1. Para ejercicio 1 - Nota del 0 al 100")
    println("2. Para ejercicio 2 - Edad y Nota para beca")
    println("3. Para ejercicio 3 - Estrato y tarifas")
    var opcion = readln().toInt()

    var menu = when(opcion){
        1 -> ejercicio1()
        2 -> ejercicio2()
        3 -> ejercicio3()
        else -> "Ingrese una opción válida"
    }
}

fun ejercicio1(){
    print("Por favor ingrese una nota del 0 al 100: ")
    var nota = readln().toInt()

    var rango = when(nota){
        in 90 .. 100 -> 'A'
        in 80 .. 90 -> 'B'
        in 70 .. 79 -> 'C'
        in 60 .. 69 -> 'D'
        in 0 .. 59 -> 'E'
        else ->  "Ingrese una nota válida"
    }
    println("Su nota de $nota corresponde a una calificación de: $rango")
}

fun ejercicio2(){
    print("Por favor ingrese su edad: ")
    var edad = readln().toInt()
    print("Por favor ingrese su nota: ")
    var nota = readln().toInt()

    if (edad in 18 .. 25 && nota in 80 .. 100){
        println("Felicidades has obtenido tu beca")
    } else{
        println("Lo sentimos, no has alcanzado la beca, vuelve en otro momento")
    }
}

fun ejercicio3(){
    print("Valor a Cancelar: ")
    var valor = readln().toDouble()

    print("Por favor ingrese su estrato del 1 al 6: ")
    var estrato = readln().toInt()

    if (estrato in 1 .. 2){
        var valCancelar = valor * 0.50
        println("Valor total a cancelar: $valCancelar")
        println("Mensaje: Obtiene el 50% de descuento")
    } else if(estrato in 3 .. 4){
        var valCancelar = valor * 1.0
        println("Valor total a cancelar: $valCancelar")
        println("Mensaje: Paga la tarifa normal")
    } else if(estrato in 5 .. 6){
        var valCancelar = valor * 1.25
        println("Valor total a cancelar: $valCancelar")
        println("Mensaje: Debe pagar 25% de recargo")
    }
}