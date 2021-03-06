package com.example.crud.db

// its repository which gives you indirect access to dao functions
class SubscriberRepository(private val dao: SubscriberDAO) { //takes an instance of dao
    val subscribers = dao.getAllSubscribers() //calls dao
    suspend fun insertSubscriber(subscriber: Subscriber) { // it gets an variable with the type of subscriber
        dao.insertSubscriber(subscriber) // and passes it to the insert function of subscriber
    }

    suspend fun deleteSubscriber(subscriber: Subscriber) { //does the same
        dao.deleteSubscriber(subscriber)
    }

    suspend fun updateSubscriber(subscriber: Subscriber) { //does the same
        dao.updateSubscriber(subscriber)
    }
    suspend fun deleteAll(){
        dao.deleteAll()
    }

}

