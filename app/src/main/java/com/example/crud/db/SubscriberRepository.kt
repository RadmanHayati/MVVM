package com.example.crud.db

class SubscriberRepository(private val dao: SubscriberDAO) {
    fun getAllSubscribers() = dao.getAllSubscribers()
    suspend fun insertSubscriber(subscriber: Subscriber) {
        dao.insertSubscriber(subscriber)
    }

    suspend fun deleteSubscriber(subscriber: Subscriber) {
        dao.deleteSubscriber(subscriber)
    }

    suspend fun updateSubscriber(subscriber: Subscriber) {
        dao.updateSubscriber(subscriber)
    }

}

