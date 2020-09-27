package com.example.roomcrud.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomcrud.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM  user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Update
    suspend fun updateUser(user: User)

}