package com.live.allo.database

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class MMigrations(startVersion: Int, endVersion: Int): Migration(startVersion, endVersion) {
    override fun migrate(database: SupportSQLiteDatabase) {
        if(startVersion == 1 && endVersion == 2){

        }
    }
}