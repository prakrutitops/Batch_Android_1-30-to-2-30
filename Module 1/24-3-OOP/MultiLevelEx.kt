open class A1
{
    fun a1()
    {
        println("A Executed")
    }
}
open class B1 :A1()
{
    fun b1()
    {
        println("B Executed")
    }
}
class C1 :B1()
{
    fun c1()
    {
        println("C Executed")
    }
}

fun main()
{
    var c1 = C1()
    c1.a1()
    c1.b1()
    c1.c1()
}