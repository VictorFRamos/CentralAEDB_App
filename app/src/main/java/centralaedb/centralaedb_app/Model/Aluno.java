package centralaedb.centralaedb_app.Model;


import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.net.URI;

public class Aluno  extends AsyncTask<String, Void, Aluno> implements Serializable
{

    public static int alunoId;
    public static String alunoNome;
    public static String alunoSenha ;
    public static String alunoMatricula;
    public static String alunoEmail;
    public int alunoPontuacao;
    public static String alunoStatus;
    public int cursoId;

    public String getAnoAno() {
        return anoAno;
    }

    public void setAnoAno(String anoAno) {
        this.anoAno = anoAno;
    }

    public  String anoAno;

    public String getCursoNome() {
        return cursoNome;
    }

    public void setCursoNome(String cursoNome) {
        this.cursoNome = cursoNome;
    }

    public String cursoNome;
    public int anoId;
    public static String alunoImagem;
    public static String alunoAssinatura;
    public static String alunoConfiguracaoTimeline;



    public static boolean alunoLiberacao;




    public Aluno() {

    }

    @Override
    protected Aluno doInBackground(String... params) {


            String URL = Model.url +params[0]+"/"+params[1];
            String linha = "";
            Boolean Erro = true;
             Aluno autenticado = new Aluno();
        JSONObject temp1 = null;

            if (params.length > 0) {

                try {

                    HttpClient client = new DefaultHttpClient();
                    HttpGet requisicao = new HttpGet();
                    requisicao.setHeader("Content-Type",
                            "application/json; charset=utf-8");
                    requisicao.setURI(new URI(URL));
                    HttpResponse resposta = client.execute(requisicao);

                    String json_string = EntityUtils.toString(resposta.getEntity());
                    temp1 = new JSONObject(json_string);

                    setAlunoId(Integer.parseInt(temp1.get("alunoId").toString()));
                    setAlunoNome(temp1.get("alunoNome").toString());
                    setAlunoMatricula(temp1.get("alunoMatricula").toString());
                    setAlunoEmail(temp1.get("alunoEmail").toString());

                    setAlunoConfiguracaoTimeline(temp1.get("alunoConfiguracaoTimeline").toString());

                } catch (Exception e) {
                    temp1 = null;
                }
            }

            return autenticado;

    }

    public static boolean isAlunoLiberacao() {
        return alunoLiberacao;
    }

    public static void setAlunoLiberacao(boolean alunoLiberacao) {
        Aluno.alunoLiberacao = alunoLiberacao;
    }

    public static int getAlunoId() {
        return alunoId;
    }

    public static void setAlunoId(int alunoId) {
        Aluno.alunoId = alunoId;
    }

    public static String getAlunoNome() {
        return alunoNome;
    }

    public static void setAlunoNome(String alunoNome) {
        Aluno.alunoNome = alunoNome;
    }

    public static String getAlunoSenha() {
        return alunoSenha;
    }

    public static void setAlunoSenha(String alunoSenha) {
        Aluno.alunoSenha = alunoSenha;
    }

    public static String getAlunoMatricula() {
        return alunoMatricula;
    }

    public static void setAlunoMatricula(String alunoMatricula) {
        Aluno.alunoMatricula = alunoMatricula;
    }

    public static String getAlunoEmail() {
        return alunoEmail;
    }

    public static void setAlunoEmail(String alunoEmail) {
        Aluno.alunoEmail = alunoEmail;
    }

    public int getAlunoPontuacao() {
        return alunoPontuacao;
    }

    public void setAlunoPontuacao(int alunoPontuacao) {
        this.alunoPontuacao = alunoPontuacao;
    }

    public static String getAlunoStatus() {
        return alunoStatus;
    }

    public static void setAlunoStatus(String alunoStatus) {
        Aluno.alunoStatus = alunoStatus;
    }

    public int getCursoId() {
        return cursoId;
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }

    public int getAnoId() {
        return anoId;
    }

    public void setAnoId(int anoId) {
        this.anoId = anoId;
    }

    public static String getAlunoImagem() {
        return alunoImagem;
    }

    public static void setAlunoImagem(String alunoImagem) {
        Aluno.alunoImagem = alunoImagem;
    }

    public static String getAlunoAssinatura() {
        return alunoAssinatura;
    }

    public static void setAlunoAssinatura(String alunoAssinatura) {
        Aluno.alunoAssinatura = alunoAssinatura;
    }

    public static String getAlunoConfiguracaoTimeline() {
        return alunoConfiguracaoTimeline;
    }

    public static void setAlunoConfiguracaoTimeline(String alunoConfiguracaoTimeline) {
        Aluno.alunoConfiguracaoTimeline = alunoConfiguracaoTimeline;
    }


}
