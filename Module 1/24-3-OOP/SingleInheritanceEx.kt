open class A
{
    fun a1()
    {
        println("A Executed")
    }
}
class B : A()
{
    fun b1()
    {
        println("B Executed")
    }
}

fun main()
{
    var b1 = B()

    b1.b1()
    b1.a1()
}