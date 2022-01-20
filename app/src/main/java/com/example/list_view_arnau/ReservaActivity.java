package com.example.list_view_arnau;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ReservaActivity extends AppCompatActivity {

    private Spinner spinner_stores;
    private List<String> stores = new ArrayList<>();

    private DatePickerDialog picker1;
    private DatePickerDialog picker2;
    private EditText entrada_c;
    private EditText sortida_c;

    private Switch switch_subs;
    private RadioGroup newsletter_op;
    private RadioButton o1;
    private RadioButton o2;
    private RadioButton o3;
    private RadioButton o4;

    private Button button_r;
    private TextInputEditText nom_text;
    private TextInputEditText cognom_text;
    private TextInputEditText mail_text;
    private TextInputEditText n_persones_text;

    private ImageView logo_stores_r;

    String selection1 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        spinner_stores = findViewById(R.id.spinner_stores);
        entrada_c = findViewById(R.id.entrada_c);
        sortida_c = findViewById(R.id.sortida_c);
        switch_subs = findViewById(R.id.switch_subs);
        newsletter_op = findViewById(R.id.newsletter_op);
        o1 = findViewById(R.id.o1);
        o2 = findViewById(R.id.o2);
        o3 = findViewById(R.id.o3);
        o4 = findViewById(R.id.o4);
        button_r = findViewById(R.id.button_r);
        nom_text = findViewById(R.id.nom_text);
        cognom_text = findViewById(R.id.cognom_text);
        mail_text = findViewById(R.id.mail_text);
        n_persones_text = findViewById(R.id.n_persones_text);
        logo_stores_r = findViewById(R.id.logo_store_r);

        stores.add(getString(R.string.select));
        stores.add(getString(R.string.zara));
        stores.add(getString(R.string.mango));
        stores.add(getString(R.string.hm));
        stores.add(getString(R.string.hollister));
        stores.add(getString(R.string.nike));

        Intent intent = getIntent();
        String title_stores = intent.getStringExtra(DashboardActivity.EXTRA_TITLE_STORES);
        int img_stores = intent.getIntExtra(DashboardActivity.EXTRA_IMG_STORES, R.drawable.zara_logo);

        logo_stores_r.setImageResource(img_stores);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                stores
        );

        spinner_stores.setAdapter(dataAdapter);

        spinner_stores.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int p = stores.indexOf(title_stores);
                for (String s : stores){
                    if (title_stores.equals(s)){
                        p = stores.indexOf(s);
                    }
                }
                parent.setSelection(p);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        entrada_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                picker1 = new DatePickerDialog(ReservaActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                entrada_c.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker1.show();
            }
        });

        sortida_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                picker2 = new DatePickerDialog(ReservaActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                sortida_c.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker2.show();
            }
        });

        for (int i = 0; i < 4; i++){
            newsletter_op.getChildAt(i).setClickable(false);
            newsletter_op.getChildAt(i).setEnabled(false);
        }

        if (switch_subs != null){
            switch_subs.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        for (int i = 0; i < 4; i++){
                            newsletter_op.getChildAt(i).setClickable(true);
                            newsletter_op.getChildAt(i).setEnabled(true);
                        }
                        newsletter_op.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(RadioGroup group, int checkedId) {
                                int radioSelected1 = group.getCheckedRadioButtonId();
                                RadioButton radioButton;
                                radioButton = findViewById(radioSelected1);
                                selection1 = radioButton.getText() + "";
                            }
                        });
                    } else {
                        for (int i = 0; i < 4; i++){
                            newsletter_op.getChildAt(i).setClickable(false);
                            newsletter_op.getChildAt(i).setEnabled(false);
                        }
                        o4.setChecked(true);
                    }
                }
            });
        }

        button_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);

                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");

                String[] TO = {mail_text.toString()};
                String[] CC = {getString(R.string.mailCC)};

                String switch_checked = "No";
                if (switch_subs.isChecked()){
                    switch_checked = "Si";
                }

                emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                emailIntent.putExtra(Intent.EXTRA_CC, CC);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.subject) + title_stores);
                emailIntent.putExtra(Intent.EXTRA_TEXT,
                        "Nom: " + nom_text.getText().toString() + " " + cognom_text.getText().toString() +
                        "\nTenda: " + title_stores +
                        "\nEntrada: " + entrada_c.getText().toString() +
                        "\nSortida: " + sortida_c.getText().toString() +
                        "\nEmail: "+ mail_text.getText().toString() +
                        "\nNum persones: "+ n_persones_text.getText().toString() +
                        "\nNewsletter: " + switch_checked +
                        "\nTipus: " + selection1);

                try {
                    startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(ReservaActivity.this, "There is no email client installed.",
                            Toast.LENGTH_SHORT).show();
                }
            }

        });

    }
}