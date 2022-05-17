package com.app.quiz.entity

import android.os.Parcelable
import com.app.quiz.entity.Question
import kotlinx.android.parcel.Parcelize

@Parcelize
data class QuizResult(val question: String, val selectedAnswer: String, val correctAnswer: String) :
    Parcelable {

    constructor(question: Question, selectedAnswer: String) : this(
        question.question,
        selectedAnswer,
        arrayOf(question.answer1, question.answer2, question.answer3, question.answer4)[question.correctAnswer]
    )

}