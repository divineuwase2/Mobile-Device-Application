package com.app.quiz.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity()
data class Question (val question: String,
                     val answer1: String,
                     val answer2: String,
                     val answer3: String,
                     val answer4: String,
                     val correctAnswer: Int,
                     val quizId: Int):Serializable{
    @PrimaryKey(autoGenerate = true)
    var id:Int =0
}


/*
data class Question(
    val question: String,
    val answer1: String,
    val answer2: String,
    val answer3: String,
    val answer4: String,
    val correctAnswer: Int
)
*/
