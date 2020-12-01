import java.io.*

var imagen2: BufferedOutputStream? = null
    var imagen1: BufferedInputStream? = null

    fun copyImagen(directorio: String, foto: String,carpeta:String) {

        imagen2 = BufferedOutputStream(FileOutputStream(directorio+"\\"+carpeta+"\\"+foto))
        imagen1 = BufferedInputStream(FileInputStream(directorio+"\\"+foto))
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