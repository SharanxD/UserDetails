package com.example.userdetails


import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    /**
     * onCreate method to create database
     */
    override fun onCreate(db: SQLiteDatabase) {
        // below is a sqlite query, where column names
        // along with their data types is given
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + USER_ID + " INTEGER PRIMARY KEY, " +
                USER_NAME + " TEXT," +
                USER_age + " TEXT," +
                USER_PHONE + " TEXT," +
                USER_HOBBY + " TEXT" + ")")

        // we are calling sqlite
        // method for executing our query
        db.execSQL(query)
    }

    /**
     * On upgrading DB
     */
    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {

        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    /**
     * Add friend to slambook db
     */
    fun addFriendToUserDetails(name: String, age: String, phone: String, hobby: String) {

        val values = ContentValues()
        values.put(USER_NAME, name)
        values.put(USER_age, age)
        values.put(USER_PHONE, phone)
        values.put(USER_HOBBY, hobby)

        val db = this.writableDatabase

        db.insert(TABLE_NAME, null, values)

        db.close()
    }

    /**
     * Get all friends from db
     */
    fun getFriendsFromUserDetails(): Cursor? {

        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)

    }


    fun deletedata(){

    }

    companion object {
        private const val DATABASE_NAME = "User_Details"

        //DB Version
        private const val DATABASE_VERSION = 1

        const val TABLE_NAME = "slab_book" //table name

        const val USER_ID = "id"

        const val USER_NAME = "name"
        const val USER_age = "age"
        const val USER_PHONE = "phone"
        const val USER_HOBBY = "hobby"
    }
}