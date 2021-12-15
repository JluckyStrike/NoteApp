package com.itfun.noteapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    private ArrayList<Note> data = new ArrayList<>();
    private OnClick onClick;
// 1:12
    public void setData(Collection<Note> notes){
        data.clear();
        data.addAll(notes);
    }

    public OnClick getOnClick() {
        return onClick;
    }

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }

    interface OnClick{
        void onClick(Note note);
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notes, parent, false);

        return new NotesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        Note note = data.get(position);
        holder.getCityTitle().setText(note.getTitle());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class NotesViewHolder extends RecyclerView.ViewHolder{

        private TextView cityTitle;


        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            cityTitle = itemView.findViewById(R.id.note_title);

            itemView.findViewById(R.id.card).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Note note = data.get(getAdapterPosition());

                    if (getOnClick() != null){
                        getOnClick().onClick(note);
                    }
                }
            });

        }

        public TextView getCityTitle() {
            return cityTitle;
        }

        public void setCityTitle(TextView cityTitle) {
            this.cityTitle = cityTitle;
        }
    }
}
