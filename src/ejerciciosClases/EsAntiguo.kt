package ejerciciosClases

class EsAntiguo(var titulo: String, var autor: String, var publicacion: Int){
    fun verificacion(): String{
        if (publicacion < 2000){
            return "El libro $titulo fué publicado antes del año 2000 - es antíguo"
        } else if (publicacion == 2000){
            return "E libro $titulo es del año 2000 - No es antíguo pero tampoco nuevo"
        } else {
            return "El libro $titulo fué publicado luego del año 2000 - No es antíguo"
        }
    }
}