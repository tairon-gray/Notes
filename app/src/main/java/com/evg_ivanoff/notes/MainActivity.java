package com.evg_ivanoff.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.ItemTouchUIUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewNotes;
    public static final ArrayList<Note> notes = new ArrayList<>();
    private NoteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewNotes = findViewById(R.id.recyclerViewNotes);
        if (notes.isEmpty()) {
            notes.add(new Note("Стоматолог", "Вылечить зубы", "понедельник", 2));
            notes.add(new Note("Парикмахер", "Сделать прическу", "среда", 3));
            notes.add(new Note("Строитель", "Построить дом", "воскресенье", 2));
            notes.add(new Note("Учитель", "Выучить уроки", "вторник", 2));
            notes.add(new Note("Тренер", "Потренироваться", "понедельник", 1));
            notes.add(new Note("Визажист", "Сделать макияж", "суббота", 3));
            notes.add(new Note("Мотиватор", "Получить мотивацию", "пятница", 3));
            notes.add(new Note("Стоматолог", "Вылечить зубы", "понедельник", 2));
            notes.add(new Note("Парикмахер", "Сделать прическу", "среда", 3));
            notes.add(new Note("Строитель", "Построить дом", "воскресенье", 2));
            notes.add(new Note("Учитель", "Выучить уроки", "вторник", 2));
        }
        adapter = new NoteAdapter(notes);
        recyclerViewNotes.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerViewNotes.setAdapter(adapter);
        adapter.setOnNoteClickListener(new NoteAdapter.OnNoteClickListener() {
            @Override
            public void onNoteClick(int position) {
                Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(int position) {
                removeNote(position);
            }
        });
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                removeNote(viewHolder.getAdapterPosition());
            }
        });
        itemTouchHelper.attachToRecyclerView(recyclerViewNotes);

    }

    private void removeNote(int position){
        notes.remove(position);
        adapter.notifyDataSetChanged();
    }

    public void onClickNewNote(View view) {
        Intent intent = new Intent(this, AddNote.class);
        startActivity(intent);
    }
}