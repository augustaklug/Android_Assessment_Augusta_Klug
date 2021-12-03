package com.example.assessmentaugusta.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.assessmentaugusta.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    private lateinit var aboutViewModel: AboutViewModel
    private var _binding: FragmentAboutBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        aboutViewModel =
            ViewModelProvider(this).get(AboutViewModel::class.java)

        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val aboutTextView: TextView = binding.titleAbout
        val descriptionTextView: TextView = binding.descriptionAbout

        aboutViewModel.titleText.observe(viewLifecycleOwner, Observer {
            aboutTextView.text = it
        })

        aboutViewModel.descriptionText.observe(viewLifecycleOwner, Observer {
            descriptionTextView.text = it
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}