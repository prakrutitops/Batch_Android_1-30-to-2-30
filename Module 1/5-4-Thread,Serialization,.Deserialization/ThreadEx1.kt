class A8 :Thread()
{
    override fun run()
    {
        for(i in 1..10)
        {
            println("Thread A: "+i)
        }
    }
}
class B8 :Thread()
{
    override fun run()
    {
        for(i in 1..10)
        {
            println("Thread B: "+i)
        }
    }
}
fun main()
{
    var a = A8()
    var b = B8()

    a.start()
    b.start()

}