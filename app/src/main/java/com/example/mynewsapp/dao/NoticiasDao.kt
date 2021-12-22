package com.example.mynewsapp.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mynewsapp.model.NoticiaModel

@Dao
interface NoticiasDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun agregar(noticiaModel: NoticiaModel)

    @Insert
    fun agregarAll(noticias: List<NoticiaModel>)

    @Query("select id from tabla_noticias")
    fun listar(): LiveData<List<NoticiaModel>>
}
