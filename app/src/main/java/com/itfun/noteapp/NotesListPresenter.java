package com.itfun.noteapp;

import java.util.List;

public class NotesListPresenter {
    private NotesListView view;

    private NotesRepository repository;

    public NotesListPresenter(NotesListView view, NotesRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void refresh(){
        List<Note> noteList = repository.getAllNotes();
        view.showNotes(noteList);
    }
}
