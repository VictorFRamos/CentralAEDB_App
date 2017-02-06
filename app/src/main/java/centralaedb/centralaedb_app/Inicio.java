package centralaedb.centralaedb_app;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import android.telephony.SmsMessage;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import centralaedb.centralaedb_app.Model.Aluno;
import centralaedb.centralaedb_app.Model.ComentarioDoTopico;
import centralaedb.centralaedb_app.Model.DetalheDoAluno;
import centralaedb.centralaedb_app.Model.Materia;
import centralaedb.centralaedb_app.Model.SubMateria;
import centralaedb.centralaedb_app.Model.Timeline;
import centralaedb.centralaedb_app.Model.TipoDeMateria;
import centralaedb.centralaedb_app.Model.Topico;
import centralaedb.centralaedb_app.fragmentos.MeuFragmentPagerAdapter;
import centralaedb.centralaedb_app.fragmentos.fragmentForum;
import centralaedb.centralaedb_app.fragmentos.fragmentInicio;
import centralaedb.centralaedb_app.fragmentos.fragmentPerfil;
import centralaedb.centralaedb_app.fragmentos.fragmentTopico;


public class Inicio extends FragmentActivity {
    ExpandableListView expListView;
    ExpandableListView expListView2;
    //Iniciando variaveis
    List<Timeline> time = null;
    Aluno logado = null;
    DetalheDoAluno detalhe = null;

    //forum
    List< TipoDeMateria> tipo = null;
    List< Materia> materia = null;
    List<SubMateria> sub = null;
    List<Topico> topic = null;
    List<ComentarioDoTopico> comentTopic = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        Bundle data = new Bundle();

        //instancia as paginas fragmentadas
        fragmentInicio timeline = new fragmentInicio();
        fragmentPerfil perfil = new fragmentPerfil();
        fragmentForum forum = new fragmentForum();

        //carrega todos os dados a serem passados entre telas
        carregaDados();

        Intent fragInicio = new Intent(this,fragmentInicio.class);
        Intent fragPerfil = new Intent(this,fragmentPerfil.class);
        Intent fragForum = new Intent(this,fragmentForum.class);

        fragInicio.putExtra("timeline", (Serializable) time);
        fragPerfil.putExtra("detalhe",detalhe);

        fragForum.putExtra("tipoMateria", (Serializable) tipo);
        fragForum.putExtra("Materia",(Serializable) materia);
        fragForum.putExtra("subMateria",(Serializable) sub);
        fragForum.putExtra("topico",(Serializable) topic);
        fragForum.putExtra("comentarioTopico",(Serializable) comentTopic);

        data.get("timeline");

        timeline.setArguments(data);

        // Pega a referência do ViewPager
        ViewPager viewPager =(ViewPager) findViewById(R.id.pager);
        expListView = (ExpandableListView)findViewById(R.id.gvTimeline);
        expListView2 = (ExpandableListView)findViewById(R.id.gvForum);

        FragmentManager fm = getSupportFragmentManager();
        // Instancioa o FragmentPagerAdapter
        MeuFragmentPagerAdapter adapter = new MeuFragmentPagerAdapter(fm);
        // Seta o adapter do ViewPager
        viewPager.setAdapter(adapter);

    }



    private void carregaDados()
    {
        this.detalhe = (DetalheDoAluno) getIntent().getSerializableExtra("detalhe");
        this.time = (List<Timeline>) getIntent().getSerializableExtra("timeline");

    }

    public void selecionarTopicos(View view) {

        TextView submateriaNome = (TextView)  findViewById(R.id.tvSubMateria);

        String subNome = submateriaNome.getText().toString();

        int index = subNome.indexOf("-") + 2;

        String sub = subNome.substring(index,subNome.length());

        List<Topico> top = null;

        fragmentTopico fragTop = new fragmentTopico();

        try {

            top = new Topico().execute(sub).get();

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (ExecutionException e) {
            e.printStackTrace();
        }

        Intent log = new Intent(this, fragmentTopico.class);

        try {
            log.putExtra("topicos", (Serializable) top);

        }
        catch(Exception e)
        {
            e.getMessage();
        }

        startActivity(log);



    }
}
