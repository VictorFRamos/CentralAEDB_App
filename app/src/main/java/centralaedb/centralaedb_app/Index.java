package centralaedb.centralaedb_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Index extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
    }

    public void startLogin(View view) {

        Intent log = new Intent(this, Login.class);
        startActivity(log);
    }

    public void startCadastro(View view) {

        Intent cad = new Intent(this, Cadastro.class);
        startActivity(cad);
    }
}
