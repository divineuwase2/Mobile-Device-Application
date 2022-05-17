package com.app.quiz

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

import kotlinx.android.synthetic.main.fragment_result.view.*


class ResultFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_result, container, false)

        var bundle = arguments
        if (bundle == null) {
            Log.e("Result", "ResultFragment did not receive answers")
            return view
        }
        val args = ResultFragmentArgs.fromBundle(bundle)
        val result = args.answers
        val totalQuestions = result?.size
        var correctAnswers = 0
        result?.forEach {
            if (it.selectedAnswer == it.correctAnswer) {
                correctAnswers++
            }
        }
        view.total_questions_text_view.text = "Total questions: $totalQuestions"
        view.correct_answers_text_view.text = "Correct answers: $correctAnswers"
        view.wrong_answers_text_view.text = "Wrong answers: ${totalQuestions?.minus(correctAnswers)}"
        view.score_text_view.text = "Your score is: $correctAnswers / $totalQuestions"

        view.try_again_button.setOnClickListener {
            val action = ResultFragmentDirections.resultFragmentToQuizFragment()
            Navigation.findNavController(view).navigate(action)
        }

        view.analysis_button.setOnClickListener {
            val action = ResultFragmentDirections.resultFragmentToAnalysisFragment(args.answers)
            Navigation.findNavController(view).navigate(action)
        }
        return view
    }
}


