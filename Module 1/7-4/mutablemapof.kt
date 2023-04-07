fun main()
{

    var map = mutableMapOf<String,String>()

    map.put("A","1")
    map.put("B","2")
    map.put("C","3")
    map.put("D","4")

    for(i in map.entries)
    {
        println(i)
    }

}