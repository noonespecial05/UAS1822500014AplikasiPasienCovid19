package ac.id.atmaluhur.uas1822500014aplikasipasiencovid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    public void tambahdata(View View) {
        Intent i = new Intent(getApplicationContext(), TambahDataActivity.class);
        startActivity(i);
    }

    public void tampildata(View View) {
        Intent i = new Intent(getApplicationContext(), TampilDataActivity.class);
        startActivity(i);
    }

    public void logout(View View) {
        finish();
    }
}