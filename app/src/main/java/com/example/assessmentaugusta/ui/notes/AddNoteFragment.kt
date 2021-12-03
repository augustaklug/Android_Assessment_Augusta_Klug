package com.example.assessmentaugusta.ui.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.assessmentaugusta.R
import com.example.assessmentaugusta.databinding.FragmentAddNoteBinding
import com.example.assessmentaugusta.model.Note

class AddNoteFragment : Fragment() {

    private val noteViewModel: NoteViewModel by activityViewModels()
    private var _binding: FragmentAddNoteBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.buttonNoteSubmit.setOnClickListener {
            addData()
        }

        return root
    }

    private fun addData() {
        val title = binding.editTextNoteTitle.text.toString()
        val description = binding.editTextNoteDescription.text.toString()
        val newNote = Note(title, description)
        val editedList = noteViewModel.notes.value!!.toMutableList()
        editedList.add(newNote)
        noteViewModel.editList(editedList)
        requireView().findNavController()
            .navigate(R.id.noteFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}