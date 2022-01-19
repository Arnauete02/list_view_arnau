package com.example.list_view_arnau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

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