import java.io.*
import java.nio.file.Files
import java.nio.file.Paths

var imagen2: BufferedOutputStream? = null
var imagen1: BufferedInputStream? = null

fun copyImagen(directorio: String, foto: String,carpeta:String,barras:String) {


        imagen2 = BufferedOutputStream(FileOutputStream(directorio+barras+carpeta+barras+foto))
        imagen1 = BufferedInputStream(FileInputStream(directorio+barras+foto))
        var i = 32
        while (i != -1) {
            i = imagen1!!.read()
            if (i != -1) {
                imagen2!!.write(i)
            }
        }
        imagen1!!.close()
        imagen2!!.close()

}

fun deleteImage(foto: String,directorio: String,carpeta: String,barras: String){
    if (File(directorio+barras+carpeta+barras+foto).exists()){
        Files.deleteIfExists(Paths.get(directorio+barras+foto))
    }else{
        println(foto+" no se borro")
    }
}