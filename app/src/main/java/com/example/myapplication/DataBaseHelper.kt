package com.example.myapplication

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val database_name = "Veritabanim"
val table_name = "Products"
val col_productname = "Productname"
val col_productprice = "Productprice"
val col_productexplanation = "Productexplanation"
val col_id = "id"


class DataBaseHelper (var context: Context):SQLiteOpenHelper(context,
database_name,null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        var createTable = " CREATE TABLE "+ table_name+"("+
                col_id +" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                col_productname +" VARCHAR(256),"+
                col_productexplanation +" VARCHAR(256),"+
                col_productprice +" INTEGER)"
        db?.execSQL(createTable)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }


    fun insertData(kullanici: Kullanici){
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(col_productname,kullanici.ProductName)
        cv.put(col_productprice,kullanici.ProductPrice)
        cv.put(col_productexplanation,kullanici.ProductExplanation)
        var sonuc = db.insert(table_name,null,cv)
        if (sonuc == (-1).toLong()) {
            Toast.makeText(context,"Hatalı",Toast.LENGTH_LONG).show()

        }else{
            Toast.makeText(context,"Başarılı",Toast.LENGTH_LONG).show()


        }
    }



    @SuppressLint("Range")
    fun readData(): MutableList<Kullanici> {
        var liste:MutableList<Kullanici> = ArrayList()
        val db = this.readableDatabase
        var sorgu = "Select * from "+ table_name
        var sonuc = db.rawQuery(sorgu,null)
        if (sonuc.moveToFirst()){
            do {
                var kullanici = Kullanici()
                kullanici.id = sonuc.getString(sonuc.getColumnIndex(col_id)).toInt()
                kullanici.ProductName = sonuc.getString(sonuc.getColumnIndex(col_productname))
                kullanici.ProductPrice = sonuc.getString(sonuc.getColumnIndex(col_productprice)).toInt()
                kullanici.ProductExplanation = sonuc.getString(sonuc.getColumnIndex(col_productexplanation))
                liste.add(kullanici)

            }while (sonuc.moveToNext())
        }


        sonuc.close()
        db.close()
        return liste


    }


}








