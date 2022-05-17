package com.app.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.app.quiz.database.QuizDatabase
import com.app.quiz.entity.Question
import com.app.quiz.entity.QuizResult

import kotlinx.android.synthetic.main.fragment_quiz.*
import kotlinx.android.synthetic.main.fragment_quiz.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers
import java.io.IOException
import java.io.InputStream

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [QuizFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuizFragment : BaseFragment() {
    // TODO: Rename and change types of parameters
    var currentQuizIndex = 0
    var answers = Array<QuizResult?>(0) { null }
    private var quiz= ArrayList<Question>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_quiz, container, false)
        currentQuizIndex = 0

        launch {
            context?.let {
                var db1 = QuizDatabase(it, CoroutineScope(Dispatchers.IO))
                quiz.addAll(db1.getQuizDao().getQuestions())
            }

            answers = Array(quiz.size) { null }
            showQuiz(currentQuizIndex, view)
        }
        view.next_button.setOnClickListener {
            val radioButtonId = answer_radio_group.checkedRadioButtonId
            if (radioButtonId == -1) {
                Toast.makeText(this.context, "You need to select an answer.", Toast.LENGTH_LONG).show()
            } else {
                if (currentQuizIndex < quiz.size - 1) {
                    val selectedAnswer =
                        view.findViewById<RadioButton>(answer_radio_group.checkedRadioButtonId).text.toString()
                    val result = QuizResult(quiz[currentQuizIndex], selectedAnswer)
                    answers[currentQuizIndex] = result
                    currentQuizIndex++
                    showQuiz(currentQuizIndex, view)
                } else {
                    val selectedAnswer =
                        view.findViewById<RadioButton>(answer_radio_group.checkedRadioButtonId).text.toString()
                    val result = QuizResult(quiz[currentQuizIndex], selectedAnswer)
                    answers[currentQuizIndex] = result
                    val arrayList = arrayListOf<QuizResult>()
                    arrayList.addAll(answers.filterNotNull())
                    val action =
                        QuizFragmentDirections.quizFragmentToResultFragment(arrayList.toTypedArray())
                    Navigation.findNavController(view).navigate(action)
                }
            }
        }
            view.home_button.setOnClickListener {
                val action = QuizFragmentDirections.quizFragmentToHomeFragment()
                Navigation.findNavController(view).navigate(action)
            }
        return view
    }

    private fun showQuiz(index: Int, view: View) {
        val quiz = quiz[index]
        view.answer_radio_group.clearCheck()
        view.question_text_view.text = quiz.question
        view.answer_1_radio_button.text = quiz.answer1
        view.answer_2_radio_button.text = quiz.answer2
        view.answer_3_radio_button.text = quiz.answer3
        view.answer_4_radio_button.text = quiz.answer4
    }
}