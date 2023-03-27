//OPen yout Class
//Open your Function for overriding

open class Bank1
{
    open fun rate():Int
    {
        return 0
    }
}
class Sbi :Bank1()
{
    override fun rate():Int
    {
        return 7
    }
}
class Icici :Bank1()
{
    override fun rate():Int
    {
        return 8
    }
}
class Axis :Bank1()
{
    override fun rate():Int
    {
        return 9
    }
}

fun main()
{
    var b :Bank1 //Refrence Variable

    //Assign refrence as a SBI

    b= Sbi()
    println(b.rate())

    //Assign refrence as a ICICI

    b= Icici()
    println(b.rate())

    //Assign refrence as a AXIS
    b=Axis()
    println(b.rate())




}