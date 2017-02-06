package centralaedb.centralaedb_app.fragmentos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.TextView;

import org.apache.commons.lang3.StringEscapeUtils;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import centralaedb.centralaedb_app.Index;
import centralaedb.centralaedb_app.Inicio;
import centralaedb.centralaedb_app.Model.Aluno;
import centralaedb.centralaedb_app.Model.ComentarioDoTopico;
import centralaedb.centralaedb_app.Model.DetalheDoAluno;
import centralaedb.centralaedb_app.Model.Materia;
import centralaedb.centralaedb_app.Model.SubMateria;
import centralaedb.centralaedb_app.Model.Timeline;
import centralaedb.centralaedb_app.Model.TipoDeMateria;
import centralaedb.centralaedb_app.Model.Topico;
import centralaedb.centralaedb_app.R;



public class fragmentForum extends Fragment {


    View v;

    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    GridView gv;


    //forum
    //List<TipoDeMateria> tipo = null;
    List<String> mat;
    List<String> sub;





    ExpandableListView expListView2;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        try {
            mat = new Materia().execute("null").get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_forum, container, false);
        return v;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        expListView2 = (ExpandableListView) v.findViewById(R.id.gvForum);

        carregarForum(mat);

        ExpandableListAdapterForum listAdapter = new ExpandableListAdapterForum(getActivity(), listDataChild, listDataHeader);

        expListView2.setAdapter(listAdapter);
    }

    private void carregarForum(List<String> materia)
    {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        int mat;



        for(int i = 0; i< materia.size() ; i++)
        {
            listDataHeader.add(i + 1 + " - " + materia.get(i).toString());


            try {

                sub = new SubMateria().execute(materia.get(i).toString()).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            //mat = materia.get(i).materiaId;

            List<String> listaSub = new ArrayList<String>();



            for(int j = 0; j<sub.size() ; j++)
            {
                listaSub.add(j,i + 1 + "." + (j+1) + " - " + sub.get(j).toString());
            }

            listDataChild.put(listDataHeader.get(i).toString(), listaSub);
            }
        }






    }

