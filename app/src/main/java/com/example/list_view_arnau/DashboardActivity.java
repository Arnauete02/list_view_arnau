package com.example.list_view_arnau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    public static String EXTRA_TITLE_STORES = "com.example.list_view_arnau.EXTRA_TITLE_STORES";
    public static String EXTRA_IMG_STORES = "com.example.list_view_arnau.EXTRA_IMG_STORES";

    Item zara = new Item(
            "Zara",
            R.drawable.zara_logo,
            "Inditex",
            R.drawable.web,
            "www.zara.com",
            R.drawable.alarma,
            "10:00 - 21:00",
            R.drawable.mapa,
            "Pg. de Gràcia, 16",
            R.drawable.save,
            R.drawable.bookmark);

    Item mango = new Item(
            "Mango",
            R.drawable.mango_logo,
            "Punto Fa",
            R.drawable.web,
            "shop.mango.com/es",
            R.drawable.alarma,
            "10:00 - 21:00",
            R.drawable.mapa,
            "Pg. de Gràcia, 65",
            R.drawable.save,
            R.drawable.bookmark);

    Item hm = new Item(
            "H&M",
            R.drawable.hm_logo,
            "H&M Group",
            R.drawable.web,
            "www2.hm.com",
            R.drawable.alarma,
            "10:00 - 21:00",
            R.drawable.mapa,
            "Pg. de Gràcia, 11",
            R.drawable.save,
            R.drawable.bookmark);

    Item hollister = new Item(
            "Hollister",
            R.drawable.hollister_logo,
            "Hollister Co",
            R.drawable.web,
            "www.hollisterco.com",
            R.drawable.alarma,
            "9:00 - 21:00",
            R.drawable.mapa,
            "c/ Potosí, 2",
            R.drawable.save,
            R.drawable.bookmark);

    Item nike = new Item(
            "Nike",
            R.drawable.nike_logo,
            "Nike Inc.",
            R.drawable.web,
            "www.nike.com",
            R.drawable.alarma,
            "10:00 - 21:00",
            R.drawable.mapa,
            "Pg. de Gràcia, 17",
            R.drawable.save,
            R.drawable.bookmark);

    private ListView listView;
    ArrayList<Item> items = new ArrayList<>();
    CustomAdapter customAdapter = new CustomAdapter(this, items);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        items.add(zara);
        items.add(mango);
        items.add(hm);
        items.add(hollister);
        items.add(nike);

        listView = findViewById(R.id.listView);

        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                displayInfo(position);
            }
        });
    }

    private void displayInfo(int position){
        Intent i = new Intent(getApplicationContext(), ReservaActivity.class);
        i.putExtra(EXTRA_TITLE_STORES, items.get(position).getTitle_stores());
        i.putExtra(EXTRA_IMG_STORES, items.get(position).getImg_stores());
        startActivity(i);
    }

    public class CustomAdapter extends BaseAdapter {
        private Context context;
        private List<Item> items;

        public CustomAdapter(Context context, ArrayList<Item> items) {
            this.context = context;
            this.items = items;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.row_data, null);

            TextView title_stores = view.findViewById(R.id.title_stores);
            title_stores.setText(items.get(i).getTitle_stores());
            ImageView img_stores = view.findViewById(R.id.img_stores);
            img_stores.setImageResource(items.get(i).getImg_stores());
            TextView emp = view.findViewById(R.id.emp);
            emp.setText(items.get(i).getEmp());
            ImageView web = view.findViewById(R.id.web);
            web.setImageResource(items.get(i).getWeb());
            TextView text_web = view.findViewById(R.id.text_web);
            text_web.setText(items.get(i).getText_web());
            ImageView horario = view.findViewById(R.id.horario);
            horario.setImageResource(items.get(i).getHorario());
            TextView text_horario = view.findViewById(R.id.text_horario);
            text_horario.setText(items.get(i).getText_horario());
            ImageView map = view.findViewById(R.id.map);
            map.setImageResource(items.get(i).getMap());
            TextView text_map = view.findViewById(R.id.text_map);
            text_map.setText(items.get(i).getText_map());
            ImageView save = view.findViewById(R.id.save);
            save.setImageResource(items.get(i).getSave());
            ImageView unsave = view.findViewById(R.id.unsave);
            unsave.setImageResource(items.get(i).getUnsave());

            return view;
        }
    }
}