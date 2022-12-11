package com.live.allo.database.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.live.allo.database.databasebean.UserInfoBean

@Dao
interface UserInfoDao {
    @Query("SELECT * FROM userInfo WHERE id = :userId")
    fun getUser(userId: Int): LiveData<UserInfoBean>
}