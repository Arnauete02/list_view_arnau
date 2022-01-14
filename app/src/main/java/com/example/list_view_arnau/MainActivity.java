package com.example.list_view_arnau;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Item zara = new Item(
            getString(R.string.zara),
            R.drawable.zara_logo,
            getString(R.string.emp1),
            R.drawable.web,
            getString(R.string.web1),
            R.drawable.alarma,
            getString(R.string.horario1),
            R.drawable.mapa,
            getString(R.string.map1),
            R.drawable.save,
            R.drawable.bookmark);

    Item mango = new Item(
            getString(R.string.mango),
            R.drawable.mango_logo,
            getString(R.string.emp2),
            R.drawable.web,
            getString(R.string.web2),
            R.drawable.alarma,
            getString(R.string.horario2),
            R.drawable.mapa,
            getString(R.string.map2),
            R.drawable.save,
            R.drawable.bookmark);

    Item hm = new Item(
            getString(R.string.hm),
            R.drawable.hm_logo,
            getString(R.string.emp3),
            R.drawable.web,
            getString(R.string.web3),
            R.drawable.alarma,
            getString(R.string.horario3),
            R.drawable.mapa,
            getString(R.string.map3),
            R.drawable.save,
            R.drawable.bookmark);

    Item hollister = new Item(
            getString(R.string.hollister),
            R.drawable.hollister_logo,
            getString(R.string.emp4),
            R.drawable.web,
            getString(R.string.web4),
            R.drawable.alarma,
            getString(R.string.horario4),
            R.drawable.mapa,
            getString(R.string.map4),
            R.drawable.save,
            R.drawable.bookmark);

    Item nike = new Item(
            getString(R.string.nike),
            R.drawable.nike_logo,
            getString(R.string.emp5),
            R.drawable.web,
            getString(R.string.web5),
            R.drawable.alarma,
            getString(R.string.horario5),
            R.drawable.mapa,
            getString(R.string.map5),
            R.drawable.save,
            R.drawable.bookmark);

    ArrayList<Item> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items.add(zara);
        items.add(mango);
        items.add(hm);
        items.add(hollister);
        items.add(nike);
    }
}