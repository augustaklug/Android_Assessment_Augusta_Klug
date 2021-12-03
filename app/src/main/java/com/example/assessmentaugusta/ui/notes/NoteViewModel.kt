package com.example.assessmentaugusta.ui.notes

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assessmentaugusta.model.Note

class NoteViewModel : ViewModel() {

    private val _notes = MutableLiveData<List<Note>>().apply {
        value = getStarterNotes()
    }

    private val _text = MutableLiveData<String>().apply {
        value = "Lista de anotações"
    }
    val text: LiveData<String> = _text
    val notes: LiveData<List<Note>> = _notes

    fun editList(list: List<Note>){
        _notes.postValue(list)
    }

    private fun getStarterNotes(): MutableList<Note> {
        return mutableListOf(
            Note(
                "O que é o Lorem Ipsum?",
                "O Lorem Ipsum é um texto modelo da indústria tipográfica e de impressão. " +
                        "O Lorem Ipsum tem vindo a ser o texto padrão usado por estas indústrias desde o ano de 1500," +
                        " quando uma misturou os caracteres de um texto para criar um espécime de livro. " +
                        "Este texto não só sobreviveu 5 séculos, mas também o salto para a tipografia " +
                        "electrónica, mantendo-se essencialmente inalterada. Foi popularizada nos anos 60 " +
                        "com a disponibilização das folhas de Letraset, que continham passagens com Lorem Ipsum, " +
                        "e mais recentemente com os programas de publicação como o Aldus PageMaker que incluem " +
                        "versões do Lorem Ipsum."

            ),
            Note(
                "Porque é que o usamos?",
                "É um facto estabelecido de que um leitor é distraído pelo conteúdo legível " +
                        "de uma página quando analisa a sua mancha gráfica. Logo, o uso de Lorem Ipsum" +
                        " leva a uma distribuição mais ou menos normal de letras, ao contrário do uso de " +
                        "\"Conteúdo aqui, conteúdo aqui\", tornando-o texto legível. Muitas ferramentas de " +
                        "publicação electrónica e editores de páginas web usam actualmente o Lorem Ipsum " +
                        "como o modelo de texto usado por omissão, e uma pesquisa por \"lorem ipsum\" irá " +
                        "encontrar muitos websites ainda na sua infância. Várias versões têm evoluído ao " +
                        "longo dos anos, por vezes por acidente, por vezes propositadamente (como no caso do humor)."
            )
        )
    }
}