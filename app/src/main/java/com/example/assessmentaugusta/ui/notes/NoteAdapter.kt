package com.example.assessmentaugusta.ui.notes

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assessmentaugusta.R
import com.example.assessmentaugusta.model.Note

class NoteAdapter(
    private val context: Context,
    private val setAlarmInterface: SetAlarmInterface,
    private val deleteInterface: DeleteInterface
) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    private val allNotes = ArrayList<Note>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.idTVNote)
        val description: TextView = itemView.findViewById(R.id.idTVDescription)
        val alarmButton: ImageButton = itemView.findViewById(R.id.idIBAlarm)
        val deleteButton: ImageButton = itemView.findViewById(R.id.idIBDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.note_rv_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = allNotes[position]
        holder.title.text = note.title
        holder.description.text = note.description
        holder.alarmButton.setOnClickListener {
            setAlarmInterface.onAlarmButtonClick(allNotes[position])
        }
        holder.deleteButton.setOnClickListener {
            deleteInterface.onDeleteButtonClick(allNotes[position])
        }
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: List<Note>) {
        allNotes.clear()
        allNotes.addAll(newList.reversed())
        notifyDataSetChanged()
    }

    interface SetAlarmInterface {
        fun onAlarmButtonClick(note: Note)
    }

    interface DeleteInterface {
        fun onDeleteButtonClick(note: Note)
    }

}

