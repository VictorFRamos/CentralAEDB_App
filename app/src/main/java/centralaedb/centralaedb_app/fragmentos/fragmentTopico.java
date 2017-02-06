package centralaedb.centralaedb_app.fragmentos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import centralaedb.centralaedb_app.Model.Topico;
import centralaedb.centralaedb_app.R;

/**
 * Created by victo on 13/11/2015.
 */
public class fragmentTopico extends Fragment {

    List<Topico> top = null;

    TextView nomeSub;

    ListView lvTopicos;

    ArrayList<String> listDataHeader = null;
    HashMap<String, String> listDataChild;

    View v;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        // TODO Auto-generated method stub

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_topico);
        // Pega os argumentos do objeto Bundle
        Bundle data = getActivity().getIntent().getExtras();

        top = (List<Topico>)data.get("topicos");


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_topico, container, false);
        return v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {



        nomeSub = (TextView)v.findViewById(R.id.tvSubMateriaNome);

        lvTopicos = (ListView)v.findViewById(R.id.lvTopicos);

        carregarTopicos(top);

        //ListViewAdapterTopico listAdapter = new ListViewAdapterTopico(getActivity(),listDataHeader);

       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.fragment_topico, R.id.tvNomeTopico, listDataHeader);
        //lvTopicos.setAdapter(adapter);


    }

    private void carregarTopicos(List<Topico> top) {

        listDataChild =  new HashMap<String, String>();
        listDataHeader = new ArrayList<String>();

        for(int i = 0; i<top.size(); i++)
        {
            //listDataChild.put(String.valueOf(top.get(0).submateriaId), top.get(i).topicoTitulo + " - " + top.get(i).alunoNome + " - " + top.get(i).topicoData);
             listDataHeader.add(top.get(i).topicoTitulo + " - " + top.get(i).alunoNome + " - " + top.get(i).topicoData);
        }


    }
}
