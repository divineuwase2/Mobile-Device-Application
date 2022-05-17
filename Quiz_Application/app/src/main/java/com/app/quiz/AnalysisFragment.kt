package com.app.quiz

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.fragment_analysis.view.*
import kotlinx.android.synthetic.main.fragment_analysis.view.home_button

class AnalysisFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_analysis, container, false)

        var bundle = arguments
        if (bundle == null) {
            Log.e("Result", "ResultFragment did not receive answers")
            return view
        }
        val args = AnalysisFragmentArgs.fromBundle(bundle)
        val result = args.answers.toCollection(ArrayList())

        view.recycler_view.layoutManager = LinearLayoutManager(activity)
        view.recycler_view.adapter = QuizResultAdapter(result)

        view.home_button.setOnClickListener {
            val action = AnalysisFragmentDirections.analysisFragmentToHomeFragment()
            Navigation.findNavController(view).navigate(action)
        }
        return view
    }
}