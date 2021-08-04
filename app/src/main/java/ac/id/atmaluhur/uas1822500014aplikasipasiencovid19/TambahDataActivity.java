package ac.id.atmaluhur.uas1822500014aplikasipasiencovid19;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TambahDataActivity extends AppCompatActivity {
    Spinner kecamatan, kelurahan;
    EditText editNik, editNama;
    Button buttonAdd;
    String jk = "";
    String gd = "";
    StringBuilder gejala = new StringBuilder();
    CheckBox checkboxbatuk;
    CheckBox checksesak;
    CheckBox checkkepala;
    CheckBox checkdemam;
    CheckBox checkdiare;
    CheckBox checkkonjung;
    CheckBox checkruam;
    CheckBox checkmengecap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);

        editNik = (EditText) findViewById(R.id.edit_nik);
        editNama = (EditText) findViewById(R.id.edit_nama);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);

        kecamatan = findViewById(R.id.kecamatan);
        kelurahan = findViewById(R.id.kelurahan);

        checkboxbatuk = (CheckBox)findViewById(R.id.checkBox8);
        checksesak = (CheckBox)findViewById(R.id.checkBox15);
        checkkepala = (CheckBox)findViewById(R.id.checkBox12);
        checkdemam = (CheckBox)findViewById(R.id.checkBox13);
        checkdiare = (CheckBox)findViewById(R.id.checkBox14);
        checkkonjung = (CheckBox)findViewById(R.id.checkBox9);
        checkruam = (CheckBox)findViewById(R.id.checkBox10);
        checkmengecap = (CheckBox)findViewById(R.id.checkBox11);

        final String data_kecamatan[] = {
                "---Pilih Kecamatan---",
                "Girimaya",
                "Pangkalbalam",
                "Rangkui",
                "Tamansari"
        };

        final String select[] = {"---Pilih Kelurahan --"};

        final String data_kelurahan_girimaya[] = {
                "---Pilih Kelurahan---",
                "Batu Intan",
                "Bukit Besar",
                "Pasir Padi",
                "Semabung Baru",
                "Sriwijaya"
        };

        final String data_kelurahan_pangkalbalam[] = {
                "---Pilih Kelurahan---",
                "Ampui",
                "Ketapang",
                "Lontong Pancur",
                "Pasir Garam",
                "Rejosari"
        };

        final String data_kelurahan_rangkui[] = {
                "---Pilih Kelurahan---",
                "Masjid Jamik",
                "Pintu Air",
                "Keramat",
                "Asam",
                "Melintang",
                "Parit Lalang",
                "Bintang",
                "Gajah Mada"
        };

        final String data_kelurahan_tamansari[] = {
                "---Pilih Kelurahan---",
                "Batin Tikal",
                "Opas Indah",
                "Rawa Bangun",
                "Kejaksaan",
                "Gedung Nasional"
        };

        final ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, data_kecamatan);
        kecamatan.setAdapter(adapter);

        kecamatan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
                String selectedKecamatan = data_kecamatan[i];
                if (i==0) {
                    final ArrayAdapter<String> adapter1;
                    adapter1 = new ArrayAdapter<String>(TambahDataActivity.this, android.R.layout.simple_spinner_dropdown_item, select );
                    kelurahan.setAdapter(adapter1);
                }
                if (i==1) {
                    final ArrayAdapter<String> adapter2;
                    adapter2 = new ArrayAdapter<String>(TambahDataActivity.this, android.R.layout.simple_spinner_dropdown_item, data_kelurahan_girimaya);
                    kelurahan.setAdapter(adapter2);
                }
                if (i==2) {
                    final ArrayAdapter<String> adapter3;
                    adapter3 = new ArrayAdapter<String>(TambahDataActivity.this, android.R.layout.simple_spinner_dropdown_item, data_kelurahan_pangkalbalam);
                    kelurahan.setAdapter(adapter3);
                }
                if (i==3) {
                    final ArrayAdapter<String> adapter4;
                    adapter4 = new ArrayAdapter<String>(TambahDataActivity.this, android.R.layout.simple_spinner_dropdown_item, data_kelurahan_rangkui);
                    kelurahan.setAdapter(adapter4);
                }
                if (i==4) {
                    final ArrayAdapter<String> adapter5;
                    adapter5 = new ArrayAdapter<String>(TambahDataActivity.this, android.R.layout.simple_spinner_dropdown_item, data_kelurahan_tamansari);
                    kelurahan.setAdapter(adapter5);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEmployee();
                finish();
                startActivity(getIntent());
            }
        });

    }

    public void back(View View) {
        finish();
    }

    private void addEmployee(){

        final String nik = editNik.getText().toString().trim();
        final String nama = editNama.getText().toString().trim();

        final RadioGroup rgroup = (RadioGroup)findViewById(R.id.radiogroup1);
        final RadioButton laki = (RadioButton)findViewById(R.id.radioButton);
        final RadioButton perempuan = (RadioButton)findViewById(R.id.radioButton2);

        if (rgroup.getCheckedRadioButtonId() == laki.getId())
        {
            jk = "Laki - Laki";
        }  else if (rgroup.getCheckedRadioButtonId() == perempuan.getId()) {
            jk = "Perempuan";
        }

        final RadioGroup rgroupgol = (RadioGroup)findViewById(R.id.radiogroup2);
        final RadioButton gola = (RadioButton)findViewById(R.id.radioButton3);
        final RadioButton golb = (RadioButton)findViewById(R.id.radioButton4);
        final RadioButton golab = (RadioButton)findViewById(R.id.radioButton5);
        final RadioButton golo = (RadioButton)findViewById(R.id.radioButton6);

        if (rgroupgol.getCheckedRadioButtonId() == gola.getId()) {
            gd = "A";
        } else if (rgroupgol.getCheckedRadioButtonId() == golb.getId()) {
            gd = "B";
        } else if (rgroupgol.getCheckedRadioButtonId() == golab.getId()) {
            gd = "AB";
        } else if (rgroupgol.getCheckedRadioButtonId() == golo.getId()) {
            gd = "O";
        }

        final String dtkecamatan = kecamatan.getSelectedItem().toString().trim();
        final String dtkelurahan = kelurahan.getSelectedItem().toString().trim();

        if (checkboxbatuk.isChecked()) {
            gejala.append("Batuk Kering|");
        }

        if (checksesak.isChecked()) {
            gejala.append("Sesak Nafas|");
        }

        if (checkkepala.isChecked()) {
            gejala.append("Sakit Kepala|");
        }

        if (checkdemam.isChecked()) {
            gejala.append("Demam|");
        }

        if (checkdiare.isChecked()) {
            gejala.append("Diare|");
        }

        if (checkkonjung.isChecked()) {
            gejala.append("Konjungtivitis|");
        }

        if (checkruam.isChecked()) {
            gejala.append("Ruam Di Kulit|");
        }

        if (checkmengecap.isChecked()) {
            gejala.append("Hilang Kemampuan Mengecap|");
        }

        final String dtgejala = gejala.toString();

        class AddEmployee extends AsyncTask<Void,Void,String>{

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(TambahDataActivity.this,"Menambahkan...","Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(TambahDataActivity.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(konfigurasi.KEY_PAS_NIK,nik);
                params.put(konfigurasi.KEY_PAS_NAMA,nama);
                params.put(konfigurasi.KEY_PAS_JENISKELAMIN,jk);
                params.put(konfigurasi.KEY_PAS_GOLDAR,gd);
                params.put(konfigurasi.KEY_PAS_KECAMATAN, dtkecamatan);
                params.put(konfigurasi.KEY_PAS_KELURAHAN, dtkelurahan);
                params.put(konfigurasi.KEY_PAS_GEJALA, dtgejala);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(konfigurasi.URL_ADD, params);
                return res;
            }
        }
        AddEmployee ae = new AddEmployee();
        ae.execute();
    }

}