package com.example.userdetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class UserListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        val users=findViewById<RecyclerView>(R.id.rvlist)




        val UserList= arrayListOf<User>()
        val dbhelper= DBHelper(this,null)
        val cursor= dbhelper.getFriendsFromUserDetails()
        if(cursor!=null){
            cursor.moveToFirst()
            while(cursor.moveToNext()){
                val name : String = cursor.getString(cursor.getColumnIndex(DBHelper.USER_NAME))
                val age : String = cursor.getString(cursor.getColumnIndex(DBHelper.USER_age))
                val phone : String = cursor.getString(cursor.getColumnIndex(DBHelper.USER_PHONE))
                val hobby : String = cursor.getString(cursor.getColumnIndex(DBHelper.USER_HOBBY))
                val user= User(name,age,phone,hobby);
                UserList.add(user)
            }

        }
        users.adapter = UsersAdapter(UserList,this)


    }
}