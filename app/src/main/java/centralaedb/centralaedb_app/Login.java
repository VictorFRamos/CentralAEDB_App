package centralaedb.centralaedb_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import centralaedb.centralaedb_app.Model.Aluno;
import centralaedb.centralaedb_app.Model.DetalheDoAluno;
import centralaedb.centralaedb_app.Model.Timeline;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

    }

    public void Logar(View view) throws SQLException, ClassNotFoundException, ExecutionException, InterruptedException {

        EditText mEmail   = (EditText)findViewById(R.id.txtEmail);
        EditText mSenha   = (EditText)findViewById(R.id.txtSenha);

        String email = mEmail.getText().toString();
        String senha = mSenha.getText().toString();
        Aluno autenticado = null;
        List<Timeline> time = null;
        DetalheDoAluno detalhe = null;

        try {
            autenticado =  new Aluno().execute(email, senha).get();
            time = new Timeline().execute(autenticado.alunoConfiguracaoTimeline).get();
            detalhe = new DetalheDoAluno().execute(autenticado.alunoId).get();



        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (ExecutionException e) {
            e.printStackTrace();
        }

        if(autenticado != null)
        {

            Intent log = new Intent(this, Inicio.class);

            try {
                log.putExtra("detalhe", detalhe);
                log.putExtra("timeline", (Serializable) time);
            }
            catch(Exception e)
            {
                e.getMessage();
            }

            startActivity(log);
        }
        else
        {

            Intent log = new Intent(this, Index.class);
            startActivity(log);

        }
    }

}
