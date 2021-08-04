package ac.id.atmaluhur.uas1822500014aplikasipasiencovid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
    }

    public void login(View View) {
        String user = username.getText().toString();
        String pass = password.getText().toString();
        if(user.equals("1822500014") && pass.equals("1822500014")) {
            Intent i = new Intent(getApplicationContext(), DashboardActivity.class);
            startActivity(i);
        } else  {
            Toast toast = Toast.makeText(getApplicationContext(), "Username dan Password Salah", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}