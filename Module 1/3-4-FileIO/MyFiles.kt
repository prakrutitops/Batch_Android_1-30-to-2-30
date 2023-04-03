import java.io.FileOutputStream

fun main()
{

    var data ="Welcome to tops"
    var a = FileOutputStream("E://manav.txt")
    a.write(data.toByteArray())


}