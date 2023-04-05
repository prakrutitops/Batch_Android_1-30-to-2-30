class A9 :Runnable
{
    override fun run()
    {
        for(i in 1..10)
        {
            println("Thread A: "+i)
        }
    }
}
class B9 :Runnable
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

    var t1 = Thread(A9())
    var t2 = Thread(B9())

    t1.start()
    t2.start()
}