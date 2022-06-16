package com.example.myapplication

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {


    companion object {

        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "student.db"
        private const val TBL_STUDENT = "tbl_student"
        private const val ID = "id"
        private const val PRODUCTNAME = "productname"
        private const val PRODUCTPRICE = "productprice"
        private const val PRODUCTEXPLANATION = "productexplanation"


    }


    override fun onCreate(db: SQLiteDatabase?) {

        val createTblStudent = ("CREATE TABLE" + TBL_STUDENT + "("
                + ID + " INTEGER PRIMARY KEY," + PRODUCTNAME + " TEXT,"
                + PRODUCTPRICE + " VALUE" + PRODUCTEXPLANATION + " TEXT" + ")")
        db?.execSQL(createTblStudent)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        db!!.execSQL("DROP TABLE IF EXISTS $TBL_STUDENT")
        onCreate(db)


    }

    fun insertStudent(std: StudentModel): Long {

        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(PRODUCTNAME, std.productname)
        contentValues.put(PRODUCTPRICE, std.productprice)
        contentValues.put(PRODUCTEXPLANATION, std.productexplanation)

        val success = db.insert(TBL_STUDENT, null, contentValues)
        db.close()
        return success

    }

    @SuppressLint("Range")
    fun getAllStudent(): ArrayList<StudentModel> {
        val stdList: ArrayList<StudentModel> = ArrayList()
        val selectQuery = "SELECT * FROM $TBL_STUDENT"
        val db = this.readableDatabase

        val cursor: Cursor?

        try {
            cursor = db.rawQuery(selectQuery, null)


        } catch (e: Exception) {
            e.printStackTrace()
            db.execSQL(selectQuery)
            return ArrayList()

        }

        var id: Int
        var productname: String
        var productprice: String
        var productexplanation: String

        if (cursor.moveToFirst()) {
            do {
                id = cursor.getInt(cursor.getColumnIndex("id"))
                productname = cursor.getString(cursor.getColumnIndex("productname"))
                productprice = cursor.getString(cursor.getColumnIndex("productprice"))
                productexplanation = cursor.getString(cursor.getColumnIndex("productexplanation"))
                val std = StudentModel(id = id,
                    productname = productname,
                    productprice = productprice,
                    productexplanation = productexplanation)
                stdList.add(std)

            } while (cursor.moveToNext())

        }

        return stdList

    }

}
