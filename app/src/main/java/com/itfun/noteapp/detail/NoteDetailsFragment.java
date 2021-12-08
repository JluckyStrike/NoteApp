package com.itfun.noteapp.detail;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.itfun.noteapp.Note;
import com.itfun.noteapp.NotesListFragment;
import com.itfun.noteapp.R;

public class NoteDetailsFragment extends Fragment {
    private static final String ARG_NOTE = "ARG_NOTE";
    public static final String KEY_RESULT = "CityDetailsFragment_KEY_RESULT";

    TextView noteTitle;
    TextView descTitle;
    TextView dateTitle;
    ImageView noteImage;

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

        noteTitle = view.findViewById(R.id.notes_title);
        noteTitle.setText(note.getTitle());

        descTitle = view.findViewById(R.id.notes_desc);
        descTitle.setText(note.getDescription());

        dateTitle = view.findViewById(R.id.notes_date);
        dateTitle.setText(note.getDate());

        noteImage = view.findViewById(R.id.note_image);
        noteImage.setImageResource(note.getImage());
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

}
