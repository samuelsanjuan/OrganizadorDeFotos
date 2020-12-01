import java.awt.Image
import javax.swing.ImageIcon
import javax.swing.JFrame
import javax.swing.JLabel
import kotlin.math.roundToInt


var foto=JLabel(ImageIcon())
var contador=-1
const val directorio="D:\\imagenes"

fun siguiente(frame:JFrame,fotos:MutableList<String>):String{

    val icono:ImageIcon

    if (contador+1<fotos.size){
        contador+=1
        frame.remove(foto)
        icono= ImageIcon(directorio+"\\"+fotos[contador])

        foto = JLabel(escalar(icono))

        frame.add(foto)
        frame.setVisible(true)

    }
    return fotos[contador]
}

fun anterior(frame:JFrame,fotos:MutableList<String>):String{

    val icono:ImageIcon
    if (contador>0) {
        contador -= 1
        frame.remove(foto)
        icono = ImageIcon(directorio + "\\" + fotos[contador])

        foto = JLabel(escalar(icono))

        frame.add(foto)
        frame.setVisible(true)

    }
    return fotos[contador]
}

    fun escalar(icon:ImageIcon):ImageIcon{
        var width:Double=icon.iconWidth.toDouble()
        var height:Double=icon.iconHeight.toDouble()

        while (width>910||height>1024){
            width/=1.01
            height/=1.01
        }
        while (width<910&&height<1024){
            width*=1.01
            height*=1.01
        }
        return ImageIcon(icon.image.getScaledInstance(width.roundToInt(),height.roundToInt(), Image.SCALE_DEFAULT))
}
