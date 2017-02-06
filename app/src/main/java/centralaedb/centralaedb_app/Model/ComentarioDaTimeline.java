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


public class ComentarioDaTimeline extends AsyncTask<String, Void,ArrayList<ComentarioDaTimeline>> implements Serializable{

    public String comentarioTexto;
    public String anoAno;
    public String cursoNome;
    public String alunoNome;
    public int timelineId;
    public int comentarioId;
    public String timelinecomentarioData;
    public int alunoId;
    public int anoId;
    public String alunoImagem;
    public String comentarioArquivo;
    public String comentarioNomeArquivo;

    public ComentarioDaTimeline() {

    }

    @Override
    protected ArrayList<ComentarioDaTimeline> doInBackground(String... params) {


        String URL = Model.url+"timeline/comentario/" +params[0];
        String linha = "";
        Boolean Erro = true;
        ArrayList<ComentarioDaTimeline> timeComent = new ArrayList<ComentarioDaTimeline>();

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


                    ComentarioDaTimeline oComent = new ComentarioDaTimeline();

                    oComent.setTimelineId(Integer.parseInt(finalResult.getJSONObject(i).get("timelineId").toString()));
                    oComent.setComentarioId(Integer.parseInt(finalResult.getJSONObject(i).get("comentarioId").toString()));
                    oComent.setAnoAno(finalResult.getJSONObject(i).get("anoAno").toString());
                    oComent.setAnoId(Integer.parseInt(finalResult.getJSONObject(i).get("anoId").toString()));
                    oComent.setComentarioTexto(finalResult.getJSONObject(i).get("comentarioTexto").toString());
                    oComent.setAlunoNome(finalResult.getJSONObject(i).get("alunoNome").toString());
                    oComent.setAlunoId(Integer.parseInt(finalResult.getJSONObject(i).get("alunoId").toString()));
                    oComent.setTimelinecomentarioData(finalResult.getJSONObject(i).get("timelinecomentarioData").toString());
                    oComent.setCursoNome(finalResult.getJSONObject(i).get("cursoNome").toString());


                    timeComent.add(oComent);
                }

            } catch (Exception e) {
                timeComent = null;
            }
        }

        return timeComent;

    }

    public String getComentarioTexto() {
        return comentarioTexto;
    }

    public void setComentarioTexto(String comentarioTexto) {
        this.comentarioTexto = comentarioTexto;
    }

    public String getAnoAno() {
        return anoAno;
    }

    public void setAnoAno(String anoAno) {
        this.anoAno = anoAno;
    }

    public String getCursoNome() {
        return cursoNome;
    }

    public void setCursoNome(String cursoNome) {
        this.cursoNome = cursoNome;
    }

    public String getAlunoNome() {
        return alunoNome;
    }

    public void setAlunoNome(String alunoNome) {
        this.alunoNome = alunoNome;
    }

    public int getTimelineId() {
        return timelineId;
    }

    public void setTimelineId(int timelineId) {
        this.timelineId = timelineId;
    }

    public int getComentarioId() {
        return comentarioId;
    }

    public void setComentarioId(int comentarioId) {
        this.comentarioId = comentarioId;
    }

    public String getTimelinecomentarioData() {
        return timelinecomentarioData;
    }

    public void setTimelinecomentarioData(String timelinecomentarioData) {
        this.timelinecomentarioData = timelinecomentarioData;
    }

    public int getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
    }

    public int getAnoId() {
        return anoId;
    }

    public void setAnoId(int anoId) {
        this.anoId = anoId;
    }

    public String getAlunoImagem() {
        return alunoImagem;
    }

    public void setAlunoImagem(String alunoImagem) {
        this.alunoImagem = alunoImagem;
    }

    public String getComentarioArquivo() {
        return comentarioArquivo;
    }

    public void setComentarioArquivo(String comentarioArquivo) {
        this.comentarioArquivo = comentarioArquivo;
    }

    public String getComentarioNomeArquivo() {
        return comentarioNomeArquivo;
    }

    public void setComentarioNomeArquivo(String comentarioNomeArquivo) {
        this.comentarioNomeArquivo = comentarioNomeArquivo;
    }


}
