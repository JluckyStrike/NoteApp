package com.itfun.noteapp.detail;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.itfun.noteapp.Note;
import com.itfun.noteapp.R;

public class NoteDetailsFragment extends Fragment {
    private static final String ARG_NOTE = "ARG_NOTE";

    public static NoteDetailsFragment newInstance(Note note){
        NoteDetailsFragment fragment = new NoteDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_NOTE, note);
        fragment.setArguments(args);

        return fragment;
    }

    public NoteDetailsFragment() {
        super(R.layout.fragment_note_details);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Note note = requireArguments().getParcelable(ARG_NOTE);

        TextView noteTitle = view.findViewById(R.id.notes_title);
        noteTitle.setText(note.getTitle());

        TextView descTitle = view.findViewById(R.id.notes_desc);
        descTitle.setText(note.getDescription());

        TextView dateTitle = view.findViewById(R.id.notes_date);
        dateTitle.setText(note.getDate());
    }
}
