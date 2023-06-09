package com.example.sqliteex

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.view.Display.Mode

class DbHelper(var context:Context) :SQLiteOpenHelper(context, DB_NAME,null, DB_VERSION)
{
    companion object
    {
        var DB_NAME="user.db"
        var TABLE_NAME="info"
        var ID="id"
        var NAME="name"
        var NUMBER ="number"
        var DB_VERSION=1

    }

    override fun onCreate(db: SQLiteDatabase?)
    {
        var query ="CREATE TABLE " + TABLE_NAME + "("+ ID + " INTEGER PRIMARY KEY," + NAME + " TEXT,"+ NUMBER + " TEXT" + ")"
        db!!.execSQL(query)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int)
    {
        var upquery = "DROP TABLE IF EXISTS "+ TABLE_NAME
        db!!.execSQL(upquery)
        onCreate(db)
    }

    fun savedata(m:Model):Long
    {
        //insert data
        var db = writableDatabase
        var values = ContentValues()
        values.put(NAME,m.name)
        values.put(NUMBER,m.num)
        var id = db.insert(TABLE_NAME,ID,values)
        return id

    }

    fun viewdata():ArrayList<Model>
    {
        //insert data
        var db = readableDatabase
        var arraylist = ArrayList<Model>()
        var col = arrayOf(ID, NAME, NUMBER)
        var cursor:Cursor = db.query(TABLE_NAME,col,null,null,null,null,null,null)

        while(cursor.moveToNext())
        {
            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var number = cursor.getString(2)

            var m = Model()
            m.id=id
            m.name=name
            m.num=number

            arraylist.add(m)
        }

        return  arraylist

    }
    fun deletedata(id:Int)
    {
        //insert data
        var db = writableDatabase
        var deletequery = ID+" ="+id
        db.delete(TABLE_NAME,deletequery,null)

    }
    fun updatedata(m:Model)
    {
        //insert data
        var db = writableDatabase
        var values = ContentValues()
        values.put(ID,m.id)
        values.put(NAME,m.name)
        values.put(NUMBER,m.num)
        var updatequery = ID+" ="+m.id
        db.update(TABLE_NAME,values,updatequery,null)
    }


}