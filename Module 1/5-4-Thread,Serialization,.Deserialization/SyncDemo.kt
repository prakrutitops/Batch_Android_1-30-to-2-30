class Sender
{
    fun send(msg:String)
    {
        println("Sending "+msg)

            Thread.sleep(1000)

        println(msg+" sent")

    }
}

class ThreadSend(var msg:String,var sender: Sender) :Thread()
{


    override fun run()
    {
        synchronized(sender)
        {
            sender.send(msg)
        }

    }

}

fun main()
{
    var sender = Sender()
    var s1 = ThreadSend("Hii",sender)
    var s2 = ThreadSend("Byee",sender)
    s1.start()
    s2.start()

}