open class P
{
   fun p1()
   {
       println("P Executed")
   }
}
open class Q :P()
{
    fun q1()
    {
        println("Q Executed")
    }
}
interface R
{
    fun r1()

}
class S : Q() ,R
{
    fun s1()
    {
        println("S Executed")
    }

    override fun r1() {
        println("R Executed")
    }


}

fun main()
{
    var s = S()

    s.p1()
    s.q1()
    s.r1()
    s.s1()
}