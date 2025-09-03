package ejerciciosClases

class CuentaBancaria(val titular: String, val saldoinicial: Double){
    var saldoTotal = saldoinicial
    fun movimientos(): Double{
        println("¿Deseas hacer un depósito o un retiro?")
        println(" 1. -> Depósito")
        println(" 2. -> Retiro")
        var opcion = readln().toInt()
        if (opcion == 1){
            println("¿Cuanto dinero quieres depositar?")
            print("$ ")
            var deposito = readln().toDouble()
            saldoTotal = saldoinicial + deposito
            if (saldoTotal < 0){
                println("Error, no puedes ingresar valores negativos")
            } else {
                println("Depósito exitoso")
                print("Tu saldo total es: ")
                return saldoTotal
            }
        } else if(opcion == 2){
            println("¿Cuánto dinero quieres retirar?")
            print("$ ")
            var retiro = readln().toDouble()
            saldoTotal = saldoinicial - retiro
            if (saldoTotal < 0){
                println("Fondos insuficientes, revisa tu saldo")
                print("Saldo: $")
                return saldoinicial
            } else {
                println("Retiro exitoso")
                print("Saldo total: $")
                return saldoTotal
            }
        } else {
            println("Opción inválida")
            return 0.0
        }
        return 0.0
    }
}