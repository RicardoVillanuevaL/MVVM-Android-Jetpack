package com.example.myapplicationcompose.feature_note.domain.use_case

import com.example.myapplicationcompose.feature_note.domain.model.InvalidNoteException
import com.example.myapplicationcompose.feature_note.domain.model.Note
import com.example.myapplicationcompose.feature_note.domain.repository.NoteRepository
import kotlin.jvm.Throws

class AddNoteUseCase(
    private val repository: NoteRepository
) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note){
        if (note.title.isBlank()){
            throw InvalidNoteException("El titulo de la nota no puede estar vacio")
        }
        if (note.content.isBlank()){
            throw InvalidNoteException("El contenido de la nota no puede estar vacio")
        }
        repository.insertNote(note)
    }
}