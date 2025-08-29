package ejerciciosFunciones

fun ejercicio1(num1: Double, num2: Double): Double{
    return num1 + num2
}

val ejercicio2 = {num1: Double, num2: Double -> num1 * num2}

fun ejercicio3(nombre: String, edad: Int){
    print("Hola $nombre, tienes $edad años")
}

val ejercicio4 = {num: Int -> if (num%2==0){
    println("El número $num es par")} else{
    println("El número $num es impar")
} }

fun ejercicio5(num1: Double, num2: Double){
    if (num1 > num2){
        println("El número $num1 es mayor que $num2")
    } else if (num1 == num2){
        println("El número $num1 y $num2 son iguales")
    } else{
        println("El número $num2 es mayor que el $num1")
    }
}

fun ejercicio6(precio: Double, descuento: Int): Double{
    return precio - ((precio * descuento) / 100)
}

fun ejercicio7(){
    println("-- Cantidad de numeros y suma --")
    print("Ingresa la cantidad de números a sumar: ")
    var cantNum = readln().toInt()
    var suma = 0.0
    for (i in 1 .. cantNum){
        print("Ingresa el número $i: ")
        var num = readln().toDouble()
        suma = num + num
    }
    print("El total de la suma es de: $suma")
}

fun ejercicio8(){
    println("-- Cantidad de numeros pares e impares --")
    print("Ingresa la cantidad de números a verificar: ")
    var canNum = readln().toInt()
    var pares = 0
    var impares = 0
    for (i in 1 .. canNum){
        print("Ingresa el número $i: ")
        var num = readln().toInt()
        if (num%2 == 0){
            pares ++
        } else{
            impares ++
        }
    }
    println("El total de números pares es de: $pares, mientras que es de impares es de: $impares")
}

fun ejercicio9(num: Int){
    for (i in 1 .. 10){
        var resultado = num * i
        println("$num x $i = $resultado")
    }
}

fun ejercicio10(){
    val nombreAprendiz = mutableListOf<String>("")
    val edadAprendiz = mutableListOf<Int>(0)
    val componenteFav = mutableListOf<String>("")

    var seguir = "si"
    var i = 1

    while (seguir == "si"){
        println("Ingrese el nombre del aprendiz: ")
        nombreAprendiz.add(readln().toString())
        println("Ingrese la edad del aprendiz: ")
        edadAprendiz.add(readln().toInt())
        println("Ingrese el componente favorito: ")
        componenteFav.add(readln().toString())

        println("¿Desea ingresar otro aprendiz? (si/no): ")
        seguir = readln().toString().lowercase()
        i++
    }

    println("\n--- Información de los aprendices ---")
    var indice = 1
    while (indice < nombreAprendiz.size){
        println("Aprendiz No: $indice")
        println("Nombre: ${nombreAprendiz[indice]}")
        println("Edad: ${edadAprendiz[indice]}")
        println("Componente favorito: ${componenteFav[indice]}")
        println("-----------------------------------")
        indice++
    }
}
