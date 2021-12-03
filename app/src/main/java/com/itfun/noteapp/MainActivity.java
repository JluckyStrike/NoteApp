package com.itfun.noteapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import com.itfun.noteapp.detail.NoteDetailsActivity;
import com.itfun.noteapp.detail.NoteDetailsFragment;

public class MainActivity extends AppCompatActivity  {

    private Note selectedNote;
    private static final String ARG_NOTE = "ARG_NOTE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null && savedInstanceState.containsKey(ARG_NOTE)) {
            selectedNote = savedInstanceState.getParcelable(ARG_NOTE);

            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                showDetails();
            }
        }

        getSupportFragmentManager()
        .setFragmentResultListener(NotesListFragment.RESULT_KEY, this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                selectedNote = result.getParcelable(NotesListFragment.ARG_NOTE);

                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    showDetails();
                } else {
                    Intent intent = new Intent(MainActivity.this, NoteDetailsActivity.class);
                    intent.putExtra(NoteDetailsActivity.EXTRA_NOTE, selectedNote);
                    startActivity(intent);
                }
            }
        });

        findViewById(R.id.about_apps).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, new AboutAppFragment())
                        .commit();
            }
        });

        findViewById(R.id.list_notes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, new NotesListFragment())
                        .commit();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        if (selectedNote != null) {
            outState.putParcelable(ARG_NOTE, selectedNote);
        }
    }

    private void showDetails() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.details_container, NoteDetailsFragment.newInstance(selectedNote))
                .commit();
    }
}