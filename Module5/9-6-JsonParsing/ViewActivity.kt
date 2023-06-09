package com.example.jsoncrudex

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONException

class ViewActivity : AppCompatActivity()
{
    lateinit var listView: ListView
    lateinit var list: MutableList<Model>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        listView = findViewById(R.id.list)
        list = ArrayList()
        registerForContextMenu(listView)
        var stringRequest = StringRequest(
            Request.Method.GET,"https://vyasprakruti.000webhostapp.com/InventorymanaementSystem/productview.php",
            {
                    response->
                try
                {

                    var jsonArray = JSONArray(response)

                    for(i in 0 until jsonArray.length())
                    {
                        var jsonObject2 = jsonArray.getJSONObject(i)

                        var id = jsonObject2.getString("product_id")
                        var name = jsonObject2.getString("product_name")
                        var price = jsonObject2.getString("product_price")

                        var m = Model()
                        m.id=id
                        m.name=name
                        m.price=price
                        list.add(m)


                    }

                    var adapter = MyAdapter(applicationContext,list)
                    listView.adapter=adapter



                }
                catch(e: JSONException)
                {
                    Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()
                }




            })
            {
            Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
            }

        var queue: RequestQueue = Volley.newRequestQueue(this)
        queue.add(stringRequest)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        var m1 = menu!!.add(0,1,0,"Update")
        var m2 = menu.add(0,2,0,"Delete")

        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        var acm:AdapterContextMenuInfo = item.menuInfo as AdapterContextMenuInfo
        var pos = acm.position

        val m = list[pos]


        when(item.itemId)
        {

            1->
            {
                var i = Intent(applicationContext,UpdateActivity::class.java)
                i.putExtra("id",m.id)
                i.putExtra("name",m.name)
                i.putExtra("price",m.price)
                startActivity(i)
            }
            2->
            {
                var alretdialog = AlertDialog.Builder(this)
                alretdialog.setTitle("Are you sure you want to delete?")
                alretdialog.setPositiveButton("YES",{ dialogInterface: DialogInterface, i: Int ->

                    var stringrequest = object:StringRequest(Request.Method.POST,"https://vyasprakruti.000webhostapp.com/InventorymanaementSystem/productdelete.php",
                        Response.Listener {

                            Toast.makeText(applicationContext,"DELETED",Toast.LENGTH_LONG).show()
                            var i = Intent(applicationContext,ViewActivity::class.java)
                            startActivity(i)

                        }, Response.ErrorListener {

                            Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()


                        })
                    {
                        override fun getParams(): MutableMap<String, String>?
                        {

                            var map = HashMap<String,String>()
                            map.put("product_id",m.id)
                            return map
                        }
                    }


                    var queue: RequestQueue = Volley.newRequestQueue(this)
                    queue.add(stringrequest)

                })
                alretdialog.setNegativeButton("NO",{ dialogInterface: DialogInterface, i: Int ->

                    dialogInterface.cancel()
                })
                alretdialog.show()
            }


        }



        return super.onContextItemSelected(item)
    }
}