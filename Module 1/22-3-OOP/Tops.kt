//constructor - default constructor/Primary Constructor
class Tops(var id:Int, var name:String,var surname:String,var email:String)
{

        fun display()
        {
            println("$id , $name , $surname , $email")
        }

}
fun main()
{
    var t = Tops(101,"Prakruti","Vyas","Prakruti@gmail.com")
    var t2 = Tops(102,"Rutvik","Xyz","Rutvik@gmail.com")
    var t3 = Tops(103,"Manan","Xyz","Manan@gmail.com")

   t.display()
    t2.display()
    t3.display()


}