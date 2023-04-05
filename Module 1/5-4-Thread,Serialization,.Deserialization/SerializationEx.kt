import java.io.FileOutputStream
import java.io.ObjectOutputStream

fun main()
{
    var s1 = Student1(101,"Abcd")
    var fout = FileOutputStream("E://xyz.txt")
    var out = ObjectOutputStream(fout)
    out.writeObject(s1)


}