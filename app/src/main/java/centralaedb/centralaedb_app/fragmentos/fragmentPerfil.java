package centralaedb.centralaedb_app.fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import org.apache.commons.lang3.StringEscapeUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import centralaedb.centralaedb_app.Model.Aluno;
import centralaedb.centralaedb_app.Model.ComentarioDaTimeline;
import centralaedb.centralaedb_app.Model.DetalheDoAluno;
import centralaedb.centralaedb_app.Model.Timeline;
import centralaedb.centralaedb_app.R;


public class fragmentPerfil extends Fragment {

    View v;

    Aluno logado = null;
    DetalheDoAluno detalhe;
    //ArrayAdapter<DetalheDoAluno> adapter;

    TextView Nome = null;
    TextView CursoAno= null;
    TextView PaisCivilIdade = null;
    TextView EnderecoNumero = null;
    TextView Email= null;
    TextView Tel= null;
    TextView BairroCidUf = null;

    ExpandableListView expListView;
   // TextView detalhePerfil = null;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    //CustomAdapter adapter;



    @Override
    public void onCreate(Bundle savedInstanceState) {

        // TODO Auto-generated method stub

        super.onCreate(savedInstanceState);
        // Pega os argumentos do objeto Bundle


        Bundle data = getActivity().getIntent().getExtras();

        detalhe = (DetalheDoAluno)data.get("detalhe");
        DetalheDoAluno detalhe2 = detalhe;



    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_perfil, container, false);
        return v;
    }




    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        Nome = (TextView)v.findViewById(R.id.tvNome);
        CursoAno= (TextView)v.findViewById(R.id.tvCursoAno);
        PaisCivilIdade = (TextView)v.findViewById(R.id.tvPaisCivilIdade);
        EnderecoNumero = (TextView)v.findViewById(R.id.tvEnderecoNumero);
        Email= (TextView)v.findViewById(R.id.tvEmail);
        Tel= (TextView)v.findViewById(R.id.tvTel);
        BairroCidUf =(TextView)v.findViewById(R.id.tvBairroCidUf);
        expListView = (ExpandableListView) v.findViewById(R.id.elvDetalhe);
        //detalhePerfil =(TextView)v.findViewById(R.id.tv2);


        Nome.setText(detalhe.getAlunoNome());
        CursoAno.setText(detalhe.getCursoNome()+" - " + detalhe.getAnoAno());
        PaisCivilIdade.setText(detalhe.getDetalheAlunoNacionalidade()+", " + detalhe.getDetalheAlunoEstadoCivil());
        EnderecoNumero.setText(detalhe.getDetalheAlunoEndereco()  + ", " + detalhe.getDetalheAlunoNumero());
        Email.setText(detalhe.getAlunoEmail());
        Tel.setText(detalhe.getDetalheAlunoTelefone() + " - " + detalhe.getDetalheAlunoCelular());

        carregarDetalhe(detalhe);

        BairroCidUf.setText(detalhe.getDetalheAlunoBairro() + ", "+ detalhe.getDetalheAlunoCidade() +", " + detalhe.getDetalheAlunoEstado());



        ExpandableListAdapterPerfil listAdapter = new ExpandableListAdapterPerfil(getActivity(), listDataChild, listDataHeader);

        expListView.setAdapter(listAdapter);
    }

    private void carregarDetalhe(DetalheDoAluno detalhe)
    {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        ArrayList<String> principal = new ArrayList<>();

        ArrayList<String> experiencia = new ArrayList<String>();
        ArrayList<String> qualificacao = new ArrayList<String>();
        ArrayList<String> informacao = new ArrayList<String>();

        listDataHeader.add("Pessoas que voce paquerou");
        listDataHeader.add("Experiência Profissional");
        listDataHeader.add("Qualificações e Atividades Complementares");
        listDataHeader.add("Informações Adicionais");



        String [] exp = StringEscapeUtils.unescapeHtml4(detalhe.getDetalheAlunoExperienciaProfissional()).replaceAll("\\<.*?>", "").split(";");

        for(int i=0 ; i < exp.length; i++)
        {
            experiencia.add(exp[i]);

        }

        String [] qualy = StringEscapeUtils.unescapeHtml4(detalhe.getDetalheAlunoQualificacaoEAtividadesComplementares()).replaceAll("\\<.*?>", "").split(";");

        for(int i=0 ; i < qualy.length; i++)
        {
            qualificacao.add(qualy[i]);

        }

        String [] info = StringEscapeUtils.unescapeHtml4(detalhe.getDetalheAlunoInformacaoAdicional()).replaceAll("\\<.*?>", "").split(";");

        for(int i=0 ; i < info.length; i++)
        {
            informacao.add(info[i]);

        }


        listDataChild.put(listDataHeader.get(0).toString(), experiencia);
        listDataChild.put(listDataHeader.get(1).toString(), experiencia);
        listDataChild.put(listDataHeader.get(2).toString(), qualificacao);
        listDataChild.put(listDataHeader.get(3).toString(), informacao);






    }

}
