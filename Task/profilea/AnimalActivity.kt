package com.example.profilea

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.bumptech.glide.Glide
import com.google.android.material.navigation.NavigationView
import de.hdodenhof.circleimageview.CircleImageView


class AnimalActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var editor: SharedPreferences.Editor? = null
    var sharedPreferences: SharedPreferences? = null
    var txtuseremail: TextView? = null
    var email: String? = null
    var image: String? = null
    var view: View? = null
    var m: Mode = Mode()
    var imageView: CircleImageView? = null
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        sharedPreferences = getSharedPreferences("user_session", Context.MODE_PRIVATE)
        editor = sharedPreferences!!.edit()
        email = sharedPreferences!!.getString("email", "")
        image = sharedPreferences!!.getString("pic", "")
        //Toast.makeText(this, ""+image, Toast.LENGTH_SHORT).show();
        val drawer: DrawerLayout = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer.setDrawerListener(toggle)
        toggle.syncState()
        val navigationView: NavigationView = findViewById<View>(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)
        val nview: View = navigationView.getHeaderView(0)
        txtuseremail = nview.findViewById<TextView>(R.id.proname)
        imageView = nview.findViewById(R.id.imageprofile)
        txtuseremail!!.setText(email)
        Glide
            .with(getApplicationContext())
            .load(image)
            .centerCrop()
            .placeholder(R.drawable.ic_person)
            .into(imageView!!)


        /*Search_Animal_Fragment search_animal_fragment= new Search_Animal_Fragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.content_frame, search_animal_fragment);
        ft.commit();*/
       /* val search_animal_fragment = Search_List_Fragment()
        val ft: FragmentTransaction = getSupportFragmentManager().beginTransaction()
        ft.replace(R.id.content_frame, search_animal_fragment)
        ft.commit()*/

        /*SecondFragment secondFragment=new SecondFragment();
        FragmentManager fm=getFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.frmid,secondFragment).commit();*/

        //add this line to display menu1 when the activity is loaded
        //displaySelectedScreen(R.layout.fragment_search__list_)
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    override fun onBackPressed() {
        val drawer: DrawerLayout = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            finishAffinity()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       /* when (item.itemId) {
            R.id.logout -> {
                val settings: SharedPreferences =
                    getSharedPreferences("user_session", Context.MODE_PRIVATE)
                val editor: SharedPreferences.Editor = settings.edit()
                editor.remove("email")
                editor.remove("pic")
                editor.commit()
                startActivity(Intent(this@AnimalActivity, LoginActivity::class.java))
                finish()
            }
            R.id.contactus -> {
                val i = Intent(this@AnimalActivity, ContactUsActivity::class.java)
                startActivity(i)
            }
        }*/
        return super.onOptionsItemSelected(item)
    }

    private fun displaySelectedScreen(itemId: Int) {

        //creating fragment object
        var fragment: Fragment? = null
        /* when (itemId) {
            R.id.nav_all_animal -> fragment = All_Video_Fragment()
            R.id.nav_farm_animal -> fragment = Farm_AnimalFragment()
            R.id.nav_birds -> fragment = Birds_animalFragment()
            R.id.nav_water -> fragment = Water_AnimalFragment()
            R.id.nav_insects -> fragment = Insects_Fragment()
            R.id.nav_petanimal -> fragment = PetAnimal_fragment()
            R.id.nav_wildanimal -> fragment = WildAnimal_Fragment()
            R.id.nav_puzzle -> {
                val i = Intent(this@AnimalActivity, Puzzle_List_Activity::class.java)
                startActivity(i)
            }*/
        /* R.id.nav_share -> {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.setType("text/plain")
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Insert Subject here")
                val app_url = " https://play.google.com/store/apps/details?id=my.example.javatpoint"
                shareIntent.putExtra(Intent.EXTRA_TEXT, app_url)
                startActivity(Intent.createChooser(shareIntent, "Share via"))
            }*/

        //replacing the fragment
        if (fragment != null) {
            val ft: FragmentTransaction = getSupportFragmentManager().beginTransaction()
            ft.replace(R.id.content_frame, fragment)
            ft.commit()
        }
        val drawer: DrawerLayout = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        //calling the method displayselectedscreen and passing the id of selected menu
        displaySelectedScreen(item.itemId)
        //make this method blank
        return true
    }
}