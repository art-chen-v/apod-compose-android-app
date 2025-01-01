package com.artemchen.android.apodcompose.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.artemchen.android.apodcompose.data.Item

@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class ApodDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao

    companion object {
        @Volatile
        private var Instance: ApodDatabase? = null

        fun getDatabase(context: Context): ApodDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, ApodDatabase::class.java, "apod_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also {
                        Instance = it
                    }
            }
        }
    }
}