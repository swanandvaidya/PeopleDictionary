package com.swanandvaidya.peopledictionary.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserTable")
data class User(

    @ColumnInfo(name = "user_name")
    val name: String?,

    @ColumnInfo(name = "mobile_number")
    val mobileNumber: String?
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var userId: Int? = null
}
