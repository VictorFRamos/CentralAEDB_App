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
public class Topico extends AsyncTask<String, Void,List<Topico>> implements Serializable {

    public static int topicoId;
    public static String topicoTitulo;
    public static String topicoTexto;
    public static String topicoData;
    public static int alunoId;
    public static String alunoNome;
    public static int submateriaId;
    public static int topicoVisualizacoes;
    public static String topicoArquivo;
    public static String topicoNomeArquivo;
    public static int qtd_comentario;

    public static int getQtd_comentario() {
        return qtd_comentario;
    }

    public static void setQtd_comentario(int qtd_comentario) {
        Topico.qtd_comentario = qtd_comentario;
    }

    protected List<Topico> doInBackground(String... params) {


       String parametro = params[0].replace(" ", "%20");

        String URL = Model.url +"forum/"+parametro + "/topicos";
        String linha = "";
        Boolean Erro = true;
        List<Topico> listaTopico = new ArrayList<Topico>();
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

                    Topico top = new Topico();

                    top.setTopicoId(Integer.parseInt(finalResult.getJSONObject(i).get("topicoId").toString()));
                    top.setTopicoTitulo(finalResult.getJSONObject(i).get("topicoTitulo").toString());
                    top.setTopicoTexto(finalResult.getJSONObject(i).get("topicoTexto").toString());
                    top.setTopicoData(finalResult.getJSONObject(i).get("topicoData").toString());
                    top.setAlunoNome(finalResult.getJSONObject(i).get("alunoNome").toString());
                    top.setAlunoId(Integer.parseInt(finalResult.getJSONObject(i).get("alunoId").toString()));
                    top.setSubmateriaId(Integer.parseInt(finalResult.getJSONObject(i).get("submateriaId").toString()));
                    top.setTopicoVisualizacoes(Integer.parseInt(finalResult.getJSONObject(i).get("topicoVisualizacoes").toString()));
                    top.setQtd_comentario(Integer.parseInt(finalResult.getJSONObject(i).get("qtd_comentario").toString()));

                    listaTopico.add(top);


                }


            } catch (Exception e) {
                temp1 = null;
            }
        }


        return listaTopico;

    }

    public static String getAlunoNome() {
        return alunoNome;
    }

    public static void setAlunoNome(String alunoNome) {
        Topico.alunoNome = alunoNome;
    }

    public static int getTopicoId() {
        return topicoId;
    }

    public static void setTopicoId(int topicoId) {
        Topico.topicoId = topicoId;
    }

    public static String getTopicoTitulo() {
        return topicoTitulo;
    }

    public static void setTopicoTitulo(String topicoTitulo) {
        Topico.topicoTitulo = topicoTitulo;
    }

    public static String getTopicoTexto() {
        return topicoTexto;
    }

    public static void setTopicoTexto(String topicoTexto) {
        Topico.topicoTexto = topicoTexto;
    }

    public static String getTopicoData() {
        return topicoData;
    }

    public static void setTopicoData(String topicoData) {
        Topico.topicoData = topicoData;
    }

    public static int getAlunoId() {
        return alunoId;
    }

    public static void setAlunoId(int alunoId) {
        Topico.alunoId = alunoId;
    }

    public static int getSubmateriaId() {
        return submateriaId;
    }

    public static void setSubmateriaId(int submateriaId) {
        Topico.submateriaId = submateriaId;
    }

    public static int getTopicoVisualizacoes() {
        return topicoVisualizacoes;
    }

    public static void setTopicoVisualizacoes(int topicoVisualizacoes) {
        Topico.topicoVisualizacoes = topicoVisualizacoes;
    }

    public static String getTopicoArquivo() {
        return topicoArquivo;
    }

    public static void setTopicoArquivo(String topicoArquivo) {
        Topico.topicoArquivo = topicoArquivo;
    }

    public static String getTopicoNomeArquivo() {
        return topicoNomeArquivo;
    }

    public static void setTopicoNomeArquivo(String topicoNomeArquivo) {
        Topico.topicoNomeArquivo = topicoNomeArquivo;
    }
}