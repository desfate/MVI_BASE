package com.live.allo.database.databasebean

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
/**
 * 基础账户信息
 */
@Entity(tableName = "userInfo")
data class UserInfoBean (
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
){
    override fun toString() = id
}