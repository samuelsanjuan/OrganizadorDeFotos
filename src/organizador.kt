

import java.awt.Button
import java.awt.GridLayout
import java.io.File
import javax.swing.JFrame
import javax.swing.JPanel

fun main() {

    val directorio="D:\\imagenes"
    val fotos:MutableList<String> = mutableListOf()
    var foto="a"

    val frame=JFrame("Organizador")
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    frame.setSize(1820, 1024)
    frame.layout= GridLayout()

    val miniminiLayout=JPanel()
    miniminiLayout.layout=GridLayout(2,1)
    val miniLayout=JPanel()
    miniLayout.layout=GridLayout(2,2)
    val miniLayout2=JPanel()
    miniLayout2.layout=GridLayout(2,2)


    val siguiente=Button("siguiente")
    miniminiLayout.add(siguiente)
    val anterior=Button("anterior")
    miniminiLayout.add(anterior)

    val carpeta1=Button("anime")
    miniLayout.add(carpeta1)
    val carpeta2=Button("cute")
    miniLayout.add(carpeta2)
    val carpeta3=Button("basura")
    miniLayout.add(carpeta3)
    val carpeta4=Button("memes")
    miniLayout.add(carpeta4)
    val carpeta5=Button("real life")
    miniLayout2.add(carpeta5)
    val carpeta6=Button("videojuegos")
    miniLayout2.add(carpeta6)
    val carpeta7=Button("wallpapers")
    miniLayout2.add(carpeta7)
    val carpeta8=Button("otros")
    miniLayout2.add(carpeta8)


    miniminiLayout.add(miniLayout)
    miniminiLayout.add(miniLayout2)
    frame.add(miniminiLayout)

    frame.setVisible(true)

    carpeta1.addActionListener{
        copyImagen(directorio,foto,"anime")
        foto=siguiente(frame,fotos)
    }
    carpeta2.addActionListener{
        copyImagen(directorio,foto,"cute")
        foto=siguiente(frame,fotos)
    }
    carpeta3.addActionListener{
        copyImagen(directorio,foto,"data")
        foto=siguiente(frame,fotos)
    }
    carpeta4.addActionListener{
        copyImagen(directorio,foto,"memes y cosas random")
        foto=siguiente(frame,fotos)
    }
    carpeta5.addActionListener{
        copyImagen(directorio,foto,"real life")
        foto=siguiente(frame,fotos)
    }
    carpeta6.addActionListener{
        copyImagen(directorio,foto,"videojuegos")
       foto= siguiente(frame,fotos)
    }
    carpeta7.addActionListener{
        copyImagen(directorio,foto,"wallpapers")
        foto=siguiente(frame,fotos)
    }
    carpeta8.addActionListener{
        copyImagen(directorio,foto,"zOtros")
        foto=siguiente(frame,fotos)
    }


    anterior.addActionListener {
        foto=anterior(frame,fotos)
    }


    siguiente.addActionListener {
        foto=(siguiente(frame,fotos))
    }

    File(directorio).list().forEach {
        val comprobar=File(directorio+"\\"+it)
        if (!(comprobar.isDirectory))
        fotos.add(it)
    }
}





