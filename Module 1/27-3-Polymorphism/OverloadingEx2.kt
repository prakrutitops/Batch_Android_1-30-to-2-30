class OverloadingEx2
{
    //Either you can change number of parameter or data type
    fun cal(a:Int,b:Int) : Int //Method 1
    {
        return a+b
    }
    fun cal(a:Double,b:Double) : Double //Method 2
    {
        return a*b
    }

}
fun main()
{

    var o1 = OverloadingEx2()

    //call Method

    println(o1.cal(2,3))//5
    println(o1.cal(2.00,3.00))//6
}