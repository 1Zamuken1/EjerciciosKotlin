package ejerciciosClases

class Estudiante(val nombre: String, val nota: Double){
    fun aprobar(): String{
        if (nota >= 3.0){
            return "El estudiante $nombre si aprobó"
        } else{
            return "El estudiante $nombre no aprobó"
        }
    }
}