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
public class SubMateria extends AsyncTask<String, Void,List<String>> implements Serializable {

    public static int submateriaId;
    public static String submateriaNome;
    public static int materiaId;
    public String submateriaDescricao;



    protected List<String> doInBackground(String... params) {


        String URL = Model.url +"submateria/"+params[0];
        String linha = "";
        Boolean Erro = true;
        List<SubMateria> listaSubMateria = new ArrayList<SubMateria>();
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

                    SubMateria submateria = new SubMateria();

                    submateria.setSubmateriaId(Integer.parseInt(finalResult.getJSONObject(i).get("submateriaId").toString()));
                    submateria.setSubmateriaNome(finalResult.getJSONObject(i).get("submateriaNome").toString());
                    submateria.setMateriaId(Integer.parseInt(finalResult.getJSONObject(i).get("materiaId").toString()));

                    listaMateria2.add(finalResult.getJSONObject(i).get("submateriaNome").toString());
                    listaSubMateria.add(submateria);

                }


            } catch (Exception e) {
                listaSubMateria = null;
            }
        }

        return listaMateria2;

    }

    public static int getSubmateriaId() {
        return submateriaId;
    }

    public static void setSubmateriaId(int submateriaId) {
        SubMateria.submateriaId = submateriaId;
    }

    public static String getSubmateriaNome() {
        return submateriaNome;
    }

    public static void setSubmateriaNome(String submateriaNome) {
        SubMateria.submateriaNome = submateriaNome;
    }

    public static int getMateriaId() {
        return materiaId;
    }

    public static void setMateriaId(int materiaId) {
        SubMateria.materiaId = materiaId;
    }

    public String getSubmateriaDescricao() {
        return submateriaDescricao;
    }

    public void setSubmateriaDescricao(String submateriaDescricao) {
        this.submateriaDescricao = submateriaDescricao;
    }
}
