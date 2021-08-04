package ac.id.atmaluhur.uas1822500014aplikasipasiencovid19;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class TampilDataActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    private ListView listView;

    private String JSON_STRING;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_data);
        listView = (ListView)findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
        getJSON();
    }

    private void showEmployee() {
        JSONObject jsonObject = null;
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);

            for (int i = 0; i<result.length(); i++) {
                JSONObject jo = result.getJSONObject(i);
                String nik = jo.getString(konfigurasi.TAG_NIK);
                String nama = jo.getString(konfigurasi.TAG_NAMA);
                String jenis_kelamin = jo.getString(konfigurasi.TAG_JENISKELAMIN);
                String golongan_darah = jo.getString(konfigurasi.TAG_GOLDAR);
                String kecamatan = jo.getString(konfigurasi.TAG_KECAMATAN);
                String kelurahan = jo.getString(konfigurasi.TAG_KELURAHAN);
                String gejala_pasien = jo.getString(konfigurasi.TAG_GEJALA);

                HashMap<String,String> employees = new HashMap<>();
                employees.put(konfigurasi.TAG_NIK, nik);
                employees.put(konfigurasi.TAG_NAMA, nama);
                employees.put(konfigurasi.TAG_JENISKELAMIN, jenis_kelamin);
                employees.put(konfigurasi.TAG_GOLDAR, golongan_darah);
                employees.put(konfigurasi.TAG_KECAMATAN, kecamatan);
                employees.put(konfigurasi.TAG_KELURAHAN, kelurahan);
                employees.put(konfigurasi.TAG_GEJALA, gejala_pasien);
                list.add(employees);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ListAdapter adapter = new SimpleAdapter(
                TampilDataActivity.this, list, R.layout.list_item,
                new String[]{konfigurasi.TAG_NIK,konfigurasi.TAG_NAMA,konfigurasi.TAG_JENISKELAMIN,konfigurasi.TAG_GOLDAR,konfigurasi.TAG_KECAMATAN,konfigurasi.TAG_KELURAHAN,konfigurasi.TAG_GEJALA},
                new int[]{R.id.nik, R.id.nama, R.id.jenis_kelamin, R.id.golongan_darah, R.id.tkecamatan, R.id.tkelurahan, R.id.gejala_pasien}
        );
        listView.setAdapter(adapter);
    }

    private void getJSON() {
        class GetJSON extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(TampilDataActivity.this, "Mengambil Data", "Mohon Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showEmployee();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_ALL);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}