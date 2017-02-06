package centralaedb.centralaedb_app.Model;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
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
public class TipoDeMateria extends AsyncTask<String, Void,List<TipoDeMateria>> implements Serializable {

    public static int tipodemateriaId;
    public static String tipodemateriaNome;
    public static String tipodemateriaDescricao;



    protected List<TipoDeMateria> doInBackground(String... params) {


        String URL = Model.url +"tipodemateria/"+params[0];
        String linha = "";
        Boolean Erro = true;
        List<TipoDeMateria> listaTipoMateria = new ArrayList<TipoDeMateria>();
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


                    TipoDeMateria materia = new TipoDeMateria();

                    materia.setTipodemateriaId(Integer.parseInt(finalResult.getJSONObject(i).get("tipodemateriaId").toString()));
                    materia.setTipodemateriaNome(finalResult.getJSONObject(i).get("tipodemateriaNome").toString());

                    listaTipoMateria.add(materia);





                }


            } catch (Exception e) {
                temp1 = null;
            }
        }

        return listaTipoMateria;

    }

    public static int getTipodemateriaId() {
        return tipodemateriaId;
    }

    public static void setTipodemateriaId(int tipodemateriaId) {
        TipoDeMateria.tipodemateriaId = tipodemateriaId;
    }

    public static String getTipodemateriaNome() {
        return tipodemateriaNome;
    }

    public static void setTipodemateriaNome(String tipodemateriaNome) {
        TipoDeMateria.tipodemateriaNome = tipodemateriaNome;
    }

    public static String getTipodemateriaDescricao() {
        return tipodemateriaDescricao;
    }

    public static void setTipodemateriaDescricao(String tipodemateriaDescricao) {
        TipoDeMateria.tipodemateriaDescricao = tipodemateriaDescricao;
    }
}
