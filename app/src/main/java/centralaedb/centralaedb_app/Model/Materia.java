package centralaedb.centralaedb_app.Model;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by victo on 12/11/2015.
 */
public class Materia extends AsyncTask<String, Void,List<String>> implements Serializable {

    public static int materiaId;
    public static String materiaDescricao;
    public static int tipodemateriaId;
    public static String materiaNome;


    protected List<String> doInBackground(String... params) {


        String URL = Model.url +"materia/"+params[0];
        String linha = "";
        Boolean Erro = true;
        List<Materia> listaMateria = new ArrayList<Materia>();
        List<String> listaMateria2 = new ArrayList<String>();
        JSONObject temp1 = null;

        if (params.length > 0) {

            try {

                HttpClient client = new DefaultHttpClient();
                HttpGet requisicao = new HttpGet();
                requisicao.setHeader("Content-Type",
                        "application/json; charset=utf-8");
                requisicao.setURI(new URI(URL));
                HttpResponse resposta = client.execute(requisicao);



                BufferedReader reader = new BufferedReader(new InputStreamReader(resposta.getEntity().getContent(), "UTF-8"));

                String json = reader.readLine();

                JSONTokener tokener = new JSONTokener(json);
                JSONArray finalResult = new JSONArray(tokener);

                int size = finalResult.length();
                for(int i = 0;i< size; i++) {

                    Materia materia = new Materia();

                    materia.setMateriaId(Integer.parseInt(finalResult.getJSONObject(i).get("materiaId").toString()));
                    materia.setTipodemateriaId(Integer.parseInt(finalResult.getJSONObject(i).get("tipodemateriaId").toString()));
                    materia.setMateriaNome(finalResult.getJSONObject(i).get("materiaNome").toString());


                    listaMateria2.add(finalResult.getJSONObject(i).get("materiaNome").toString());
                    listaMateria.add(materia);


                }




            } catch (Exception e) {
                return null;
            }
        }


        return listaMateria2;


    }

    public static int getMateriaId() {
        return materiaId;
    }

    public static void setMateriaId(int materiaId) {
        Materia.materiaId = materiaId;
    }

    public static String getMateriaDescricao() {
        return materiaDescricao;
    }

    public static void setMateriaDescricao(String materiaDescricao) {
        Materia.materiaDescricao = materiaDescricao;
    }

    public static int getTipodemateriaId() {
        return tipodemateriaId;
    }

    public static void setTipodemateriaId(int tipodemateriaId) {
        Materia.tipodemateriaId = tipodemateriaId;
    }

    public static String getMateriaNome() {
        return materiaNome;
    }

    public static void setMateriaNome(String materiaNome) {
        Materia.materiaNome = materiaNome;
    }

}
