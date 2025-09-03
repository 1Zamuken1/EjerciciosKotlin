package ejerciciosClases

import kotlin.math.PI
import kotlin.math.pow

class Circulo(val radio: Double){
    fun calcularPerimetro(): Double{
        val perimetro = 2 * PI * radio
        return perimetro
    }
    fun calcularArea(): Double{
        val area = PI * radio.pow(2)
        return area
    }
}
