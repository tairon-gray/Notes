package com.evg_ivanoff.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewNotes;
    private ArrayList<Note> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewNotes = findViewById(R.id.recyclerViewNotes);
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

        NoteAdapter adapter = new NoteAdapter(notes);
        recyclerViewNotes.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerViewNotes.setAdapter(adapter);
    }
}