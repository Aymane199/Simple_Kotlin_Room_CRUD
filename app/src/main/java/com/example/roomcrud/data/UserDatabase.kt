package com.example.roomcrud.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomcrud.model.User

@Database(entities = [User::class],version = 1, exportSchema = false)
abstract class UserDatabase :RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object{
        @Volatile
        private var INSTANCE :UserDatabase?=null

        fun getDatabase(context: Context) :UserDatabase{
            val tempsInstance = INSTANCE
            if(tempsInstance!=null)
                return tempsInstance
            synchronized(this){
                val instance =  Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build()
                INSTANCE=instance
                return instance
            }
        }
    }
}