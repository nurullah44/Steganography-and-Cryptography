import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import java.awt.Color
import java.io.File

fun main() {
    var inputImageName: String
    var outputImageName: String
    while (true ) {
        println("Task (hide, show, exit):")
        when (readln()){
            "hide" -> {
                println("Input image file:")
                inputImageName = readln()
                println("Output image file:")
                outputImageName = readln()
                println("Input Image: $inputImageName\nOutput Image: $outputImageName")
                try {
                    val readInput: BufferedImage = ImageIO.read(File(inputImageName))

                    for ( i in 0 until readInput.width){
                        for ( j in 0 until readInput.height) {
                            val getColor = Color(readInput.getRGB(i,j))
                            val r = getColor.red
                            val g = getColor.green
                            val b = getColor.blue
                            val lsb_r = r or 1
                            val lsb_g = g or 1
                            val lsb_b = b or 1
                            val newColor = Color (lsb_r,lsb_g,lsb_b).rgb
                            readInput.setRGB(i,j,newColor)
                        }
                    }
                    ImageIO.write(readInput,"png",File(outputImageName))
                    println("Image image.png is saved.")
                } catch ( e: Exception) {
                    println("Can't read input file!")
                }
            }
            "show" -> println("Obtaining message from image.")
            "exit" -> {
                println("Bye!")
                break
            }
            else -> println("Wrong task: task")
        }
    }
}

