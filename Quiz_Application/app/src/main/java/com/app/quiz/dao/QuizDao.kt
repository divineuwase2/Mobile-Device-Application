package com.app.quiz.dao

import androidx.room.*
import com.app.quiz.entity.*

@Dao
interface QuizDao {

    @Query("SELECT * FROM Question")
    suspend fun getQuestions(): List<Question>
    @Insert
    suspend fun addQuestions(vararg question: Question)

}