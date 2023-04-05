import java.io.FileInputStream
import java.io.ObjectInputStream

fun main()
{

    var o1 = ObjectInputStream(FileInputStream("E://xyz.txt"))
    var s:Student1 = o1.readObject() as Student1
    println(s.id)
    println(s.name)
}