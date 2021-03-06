package com.example.assessmentaugusta.ui.notes

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assessmentaugusta.R
import com.example.assessmentaugusta.databinding.FragmentNoteBinding
import com.example.assessmentaugusta.model.Note


class NoteFragment : Fragment(), NoteAdapter.SetAlarmInterface, NoteAdapter.DeleteInterface {

    private val noteViewModel: NoteViewModel by activityViewModels()
    private var _binding: FragmentNoteBinding? = null
    var recyclerView: RecyclerView? = null
    var recyclerViewAdapter: NoteAdapter? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteBinding.inflate(inflater, container, false)
        val root: View = binding.root

        recyclerView = binding.notesRV
        recyclerViewAdapter = NoteAdapter(container!!.context, this, this)
        recyclerView!!.layoutManager = LinearLayoutManager(container.context)
        recyclerView!!.adapter = recyclerViewAdapter

        noteViewModel.notes.observe(viewLifecycleOwner, { list ->
            list?.let {
                recyclerViewAdapter?.updateList(list)
            }
        })

        binding.fab.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(R.id.addNoteFragment)
        }

        val textView: TextView = binding.textHome

        noteViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("QueryPermissionsNeeded")
    override fun onAlarmButtonClick(note: Note) {
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, note.title)
        }
        if (intent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(intent)
        }
    }

    override fun onDeleteButtonClick(note: Note) {
        val editedList = noteViewModel.notes.value!!.toMutableList()
        editedList.remove(note)
        noteViewModel.editList(editedList)
        Toast.makeText(
            activity,
            "A anota????o \"${note.title}\" foi exclu??da",
            Toast.LENGTH_SHORT
        ).show()
    }
}




