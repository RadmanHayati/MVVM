package com.example.crud.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// the whole class makes the database for you
// it gives you access to an instance which is singleton so it prevents boiler plate code
// so to sum up it turns your table to a database
@Database(entities = [Subscriber::class], version = 1)  // annotates that its a database of the Subscriber table
abstract class SubscriberDatabase : RoomDatabase() { // inherits from RoomDatabase()
    abstract val subscriberDAO: SubscriberDAO   //its an empty immutable variable with type of subscriberDAO(DataAccessObject)
    companion object { // companion object so thing in this block are accessible without making an instance
        @Volatile //visible to other threads
        private var Instance: SubscriberDatabase? = null //an instance of this class which is useless!
        fun getInstance(context: Context): SubscriberDatabase {
            synchronized(this) {
                var instance = Instance //idono why
                if (instance == null) { //singleton
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SubscriberDatabase::class.java, // class name
                        "subscriber_data_database" // database name
                    ).build()
                }
             return instance
            }
        }
    }
}