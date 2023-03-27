class OverloadingEx
{
    fun cal(a:Int,b:Int) : Int //Method 1
    {
        return a+b
    }
    fun cal(a:Int,b:Int,c:Int) : Int //Method 2
    {
        return a*b*c
    }

}
fun main()
{

    var o1 = OverloadingEx()

    //Call Method
    println(o1.cal(2,3))
    println(o1.cal(2,3,2))
}