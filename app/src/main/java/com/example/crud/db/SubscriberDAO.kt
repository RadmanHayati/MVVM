package com.example.crud.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SubscriberDAO {
    /*
    suspend modifier is used because room doesn't support database access
    on the main thread because it may locks the ui for a long time
    therefore we execute these functions in the background thread
    to handle these we can use sth like rx java but coroutines is better
    since room provides direct support for the kotlin coroutines
    and suspend fun is a function that can be paused and resume later
 */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSubscriber(subscriber: Subscriber): Long //can return the id

    @Update
    suspend fun updateSubscriber(subscriber: Subscriber)

    @Delete
    suspend fun deleteSubscriber(subscriber: Subscriber)

    @Query("SELECT * FROM subscriber_data_table")
    fun getAllSubscribers(): LiveData<List<Subscriber>>

    //we didn't use suspend because LiveData by default works in background thread
    @Query("DELETE FROM SUBSCRIBER_DATA_TABLE")
    suspend fun deleteAll()
}