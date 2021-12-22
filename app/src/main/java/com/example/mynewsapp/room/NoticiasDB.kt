package com.example.mynewsapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mynewsapp.dao.NoticiasDao
import com.example.mynewsapp.model.Article

@Database(entities = [Article::class], version = 1)
abstract    class NoticiasDB: RoomDatabase() {
    abstract fun noticiasDao() : NoticiasDao
    companion object{
        @Volatile
        private var instance : NoticiasDB?=null
        fun getDataBase (context: Context):NoticiasDB {
            if (instance == null) {
                synchronized(this)
                {
                    instance =
                        Room.databaseBuilder(context, NoticiasDB::class.java, "noticias_db")
                            .build()
                }
            }
            return instance!!
        }
    }
}
