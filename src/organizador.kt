

import java.awt.Button
import java.awt.GridLayout
import java.io.File
import javax.swing.JFrame
import javax.swing.JPanel

fun main() {

    val directorio="D:\\imagenes\\pruebas"
    val fotos:MutableList<String> = mutableListOf()
    var foto="a"

    val frame=JFrame("Organizador")
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.setSize(1820, 1024)
    frame.layout= GridLayout()

    val miniminiLayout=JPanel()
    miniminiLayout.layout=GridLayout(3,1)
    val miniLayout=JPanel()
    miniLayout.layout=GridLayout(2,4)

    File(directorio).list().forEach {
        val comprobar=File(directorio+"\\"+it)
        if (!(comprobar.isDirectory)){
            fotos.add(it)
        }else{
            val carpeta=it
            val boton=Button(it)
            miniLayout.add(boton)
            boton.addActionListener{
                if (fotos.size-1>contador) {
                    copyImagen(directorio, foto, carpeta)
                    deleteImage(foto, directorio, carpeta)
                    foto = siguiente(frame, fotos, directorio)
                }
            }
        }
    }

    val siguiente=Button("siguiente")
    miniminiLayout.add(siguiente)
    val anterior=Button("anterior")
    miniminiLayout.add(anterior)

    miniminiLayout.add(miniLayout)
    frame.add(miniminiLayout)

    frame.isVisible = true

    anterior.addActionListener {
        foto=anterior(frame,fotos,directorio)
    }

    siguiente.addActionListener {
        foto=siguiente(frame,fotos,directorio)
    }
}





