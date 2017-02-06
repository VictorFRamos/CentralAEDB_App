package centralaedb.centralaedb_app.Model;

import android.media.Image;
import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.net.URI;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.binary.Base64;


public class Timeline extends AsyncTask<String, Void,List<Timeline>> implements Serializable {

    public int timelineId;
    public String timelineTexto;
    public int alunoId;



    public Image alunoImagem;
    public String alunoNome;
    public String timelineData;
    public int publicarNoCurso;
    public String timelineArquivo;
    public String timelineNomeArquivo;

    private String timeline;
    private List<Timeline> mArrayChildren;

    public String getTitle() {
        return timeline;
    }

    public void setTitle(String title) {
        timeline = title;
    }

    public List<Timeline> getArrayChildren() {
        return mArrayChildren;
    }

    public void setArrayChildren(List<Timeline> arrayChildren) {
        mArrayChildren = arrayChildren;
    }

    public Timeline() {

    }

    File file = null;

    @Override
    protected List<Timeline> doInBackground(String... params) {


        String URL = Model.url+"timeline/" +params[0];
        String linha = "";
        Boolean Erro = true;
        List<Timeline> time = new ArrayList<Timeline>();

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


                    Timeline oTime = new Timeline();

                    oTime.setTimelineId(Integer.parseInt(finalResult.getJSONObject(i).get("timelineId").toString()));
                    oTime.setTimelineTexto(finalResult.getJSONObject(i).get("timelineTexto").toString());
                    oTime.setAlunoNome(finalResult.getJSONObject(i).get("alunoNome").toString());
                    oTime.setAlunoId(Integer.parseInt(finalResult.getJSONObject(i).get("alunoId").toString()));
                    oTime.setTimelineData(finalResult.getJSONObject(i).get("timelineData").toString());
                    oTime.setPublicarNoCurso(Integer.parseInt(finalResult.getJSONObject(i).get("publicarNoCurso").toString()));
                    oTime.setTimelineArquivo(finalResult.getJSONObject(i).get("timelineArquivo").toString());
                    oTime.setTimelineNomeArquivo(finalResult.getJSONObject(i).get("timelineNomeArquivo").toString());

                    time.add(oTime);
                }

            } catch (Exception e) {
                time = null;
            }
        }

        return time;

    }

    public static String encodeImage(byte[] imageByteArray) {
        return Base64.encodeBase64URLSafeString(imageByteArray);
    }

    public static byte[] decodeImage(String imageDataString) {
        return Base64.decodeBase64(imageDataString);
    }
    public int getTimelineId() {
        return timelineId;
    }
    public Image getAlunoImagem() {
        return alunoImagem;
    }

    public void setAlunoImagem(Image alunoImagem) {
        this.alunoImagem = alunoImagem;
    }


    public void setTimelineId(int timelineId) {
        this.timelineId = timelineId;
    }
    public String getAlunoNome() {
        return alunoNome;
    }

    public void setAlunoNome(String alunoNome) {
        this.alunoNome = alunoNome;
    }
    public String getTimelineTexto() {
        return timelineTexto;
    }

    public void setTimelineTexto(String timelineTexto) {
        this.timelineTexto = timelineTexto;
    }

    public int getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
    }

    public String getTimelineData() {
        return timelineData;
    }

    public void setTimelineData(String timelineData) {
        this.timelineData = timelineData;
    }

    public int getPublicarNoCurso() {
        return publicarNoCurso;
    }

    public void setPublicarNoCurso(int publicarNoCurso) {
        this.publicarNoCurso = publicarNoCurso;
    }

    public String getTimelineArquivo() {
        return timelineArquivo;
    }

    public void setTimelineArquivo(String timelineArquivo) {
        this.timelineArquivo = timelineArquivo;
    }

    public String getTimelineNomeArquivo() {
        return timelineNomeArquivo;
    }

    public void setTimelineNomeArquivo(String timelineNomeArquivo) {
        this.timelineNomeArquivo = timelineNomeArquivo;
    }



}
