package com.example.learnconnect.repositories

import android.util.Log
import com.example.learnconnect.dao.UserDao
import com.example.learnconnect.models.User
import javax.inject.Inject

class UserRepository @Inject constructor(val userDao: UserDao) {
    suspend fun registerUser(username: String, email: String, password: String): Boolean {
        val user = User(username = username, email = email, password = password)
        userDao.insertUser(user)
        return true
    }

    suspend fun loginUser(email: String, password: String): Boolean {
        val user = userDao.getUser(email, password)
        return user != null
    }

    suspend fun getIdbyUser(email: String, password: String): Int? {
        Log.d("REPO dan user id",userDao.getUser(email = email, password = password)?.id.toString() )
        return userDao.getUser(email = email, password = password)?.id
    }
    suspend fun findUserByEmailOrUsername(email: String): User? {
        return userDao.findUserByEmailOrUsername(email)
    }
}