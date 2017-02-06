package centralaedb.centralaedb_app.fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import centralaedb.centralaedb_app.Model.ComentarioDaTimeline;
import centralaedb.centralaedb_app.Model.Timeline;
import centralaedb.centralaedb_app.R;


public class fragmentInicio extends Fragment {
    private int mPaginaAtual;
    ExpandableListView expListView;
    List<String> listDataHeader;
    List<Timeline> time;
    ArrayList<ComentarioDaTimeline> coment;
    View v;
    HashMap<String, List<String>> listDataChild;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        // TODO Auto-generated method stub

        super.onCreate(savedInstanceState);
        // Pega os argumentos do objeto Bundle

        //Bundle data = getArguments();
        Bundle data = getActivity().getIntent().getExtras();
        // Pega a página atual passada por parâmetro via Bundle
        mPaginaAtual = data.getInt("pagina_atual", 0);


        time = (List<Timeline>) data.get("timeline");

    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_inicio, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // get the listview
        expListView = (ExpandableListView) v.findViewById(R.id.gvTimeline);

        // preparing list data
        carregarTimeline(time);
        ExpandableListAdapter listAdapter = new ExpandableListAdapter(getActivity(), listDataChild, listDataHeader);


        try{
            expListView.setAdapter(listAdapter);

        }
        catch(Exception e)
        {
            e.getMessage();
        }
        // setting list adapter
        expListView.setAdapter(listAdapter);

    }


    private void carregarTimeline(List<Timeline> time)
    {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        for(int i =0;i < time.size() ; i++)
        {
            listDataHeader.add(time.get(i).alunoNome + " - " + time.get(i).timelineTexto);


            try {
                coment = new ComentarioDaTimeline().execute(String.valueOf(time.get(i).timelineId)).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            List<String> lista = new ArrayList<String>();

            for(int j= 0;j<coment.size() ; j++)
            {
                lista.add(j, coment.get(j).alunoNome + ": " + coment.get(j).comentarioTexto);

            }

            listDataChild.put(time.get(i).timelineTexto, lista );
        }


    }


}

