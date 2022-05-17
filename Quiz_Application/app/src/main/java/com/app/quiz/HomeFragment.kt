
package com.app.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : BaseFragment()  {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        view.start_quiz.setOnClickListener {
            val action = HomeFragmentDirections.homeFragmentToQuizFragment()
            Navigation.findNavController(view).navigate(action)
        }
        return view
    }


}
