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
public class ComentarioDoTopico extends AsyncTask<String, Void,List<ComentarioDoTopico>> implements Serializable {

    public int comentarioId;
    public static String comentarioTexto;
    public int alunoId;
    //public int materiaId { get; set; }
    public static String alunoNome;
    // public string alunoImagem { get; set; }
    //public string materiaNome { get; set; }
    public static int submateriaId;
    // public string submateriaNome { get; set; }
    // public int tipodemateriaId { get; set; }
    // public string tipodemateriaNome { get; set; }
    public static int topicoId;
    public static String topicocomentarioData;
    //  public string comentarioArquivo { get; set; }
    // public string comentarioNomeArquivo { get; set; }


    protected List<ComentarioDoTopico> doInBackground(String... params) {


        String URL = Model.url + "/forum/" + params[0]+"/comentarios";
        String linha = "";
        Boolean Erro = true;

        List<ComentarioDoTopico> coment = new ArrayList<>();

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

                    ComentarioDoTopico comentario = new ComentarioDoTopico();

                    comentario.setComentarioId(Integer.parseInt(finalResult.getJSONObject(i).get("comentarioId").toString()));
                    comentario.setTopicoId(Integer.parseInt(finalResult.getJSONObject(i).get("topicoId").toString()));
                    comentario.setComentarioTexto(finalResult.getJSONObject(i).get("comentarioTexto").toString());
                    comentario.setAlunoId(Integer.parseInt(finalResult.getJSONObject(i).get("alunoId").toString()));
                    comentario.setAlunoNome(finalResult.getJSONObject(i).get("alunoNome").toString());
                    comentario.setTopicocomentarioData(finalResult.getJSONObject(i).get("topicocomentarioDta").toString());



                    coment.add(comentario);

                }



            } catch (Exception e) {
                temp1 = null;
            }
        }

        return coment;

    }

    public int getComentarioId() {
        return comentarioId;
    }

    public void setComentarioId(int comentarioId) {
        this.comentarioId = comentarioId;
    }

    public static String getComentarioTexto() {
        return comentarioTexto;
    }

    public static void setComentarioTexto(String comentarioTexto) {
        ComentarioDoTopico.comentarioTexto = comentarioTexto;
    }

    public int getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
    }

    public static String getAlunoNome() {
        return alunoNome;
    }

    public static void setAlunoNome(String alunoNome) {
        ComentarioDoTopico.alunoNome = alunoNome;
    }

    public static int getSubmateriaId() {
        return submateriaId;
    }

    public static void setSubmateriaId(int submateriaId) {
        ComentarioDoTopico.submateriaId = submateriaId;
    }

    public static int getTopicoId() {
        return topicoId;
    }

    public static void setTopicoId(int topicoId) {
        ComentarioDoTopico.topicoId = topicoId;
    }

    public static String getTopicocomentarioData() {
        return topicocomentarioData;
    }

    public static void setTopicocomentarioData(String topicocomentarioData) {
        ComentarioDoTopico.topicocomentarioData = topicocomentarioData;
    }
}