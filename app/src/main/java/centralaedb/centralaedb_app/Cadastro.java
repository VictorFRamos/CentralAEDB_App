package centralaedb.centralaedb_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Cadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }

    public void startCadastro(View view) {

        Intent cad = new Intent(this, Cadastro.class);
        startActivity(cad);
    }

    public void Cadastrar(View view)
    {
        Intent log = new Intent(this, detalheCadastro.class);
        startActivity(log);
    }


}
