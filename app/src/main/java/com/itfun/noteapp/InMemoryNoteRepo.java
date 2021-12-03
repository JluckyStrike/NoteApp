package com.itfun.noteapp;

import java.util.ArrayList;
import java.util.List;

public class InMemoryNoteRepo implements NotesRepository{

    @Override
    public List<Note> getAllNotes() {
        ArrayList<Note> noteArrayList = new ArrayList<>();

        noteArrayList.add(new Note(R.string.do_homework, R.string.do_homework_desc, R.string.do_homework_date));
        noteArrayList.add(new Note(R.string.go_gym, R.string.go_gym_desc, R.string.go_gym_date));
        noteArrayList.add(new Note(R.string.buy_food, R.string.buy_food_desc, R.string.buy_food_date));

        return noteArrayList;
    }
}
