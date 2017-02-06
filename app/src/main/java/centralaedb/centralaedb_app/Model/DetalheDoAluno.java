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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DetalheDoAluno extends AsyncTask<Integer, Void, DetalheDoAluno> implements Serializable
{

    public static int alunoId;
    public static String alunoNome;
    public static String alunoMatricula;
    public static String alunoEmail;
    public static int alunoPontuacao;
    public static String alunoStatus;
    public static int cursoId;
    public static String cursoNome;
    public static String anoAno;
    public static String alunoImagem;
    public static String alunoAssinatura;
    public static int anoId;
    public static String alunoConfiguracaoTimeline;



    public static String detalheAlunoNacionalidade;
    public static String detalheAlunoEstadoCivil;
    public static String detalheAlunoDataNascimento;
    public static String detalheAlunoEndereco;
    public static String detalheAlunoNumero;
    public static String detalheAlunoEstado;
    public static String detalheAlunoCidade;
    public static String detalheAlunoBairro;
    public static String detalheAlunoTelefone;
    public static String detalheAlunoCelular;
    public static String detalheAlunoCargo;
    public static String detalheAlunoFormacao;
    public static String detalheAlunoExperienciaProfissional;
    public static String detalheAlunoQualificacaoEAtividadesComplementares;
    public static String detalheAlunoInformacaoAdicional;



    @Override
    protected DetalheDoAluno doInBackground(Integer... params) {


        String URL = Model.url +"detalhe/" + params[0];
        String linha = "";
        Boolean Erro = true;
        DetalheDoAluno detalhe = new DetalheDoAluno();


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
                setAlunoPontuacao(Integer.parseInt(temp1.get("alunoPontuacao").toString()));
                setAlunoStatus(temp1.get("alunoStatus").toString());
                setCursoId(Integer.parseInt(temp1.get("cursoId").toString()));
                setCursoNome(temp1.get("cursoNome").toString());
                setAnoAno(temp1.get("anoAno").toString());
                setAnoId(Integer.parseInt(temp1.get("anoId").toString()));
                setAlunoImagem(temp1.get("alunoImagem").toString());
                setAlunoAssinatura(temp1.get("alunoAssinatura").toString());

                try {
                    setDetalheAlunoNacionalidade(temp1.get("detalheAlunoNacionalidade").toString());
                } catch (Exception e) {
                    e.getMessage();
                }

                setDetalheAlunoEstadoCivil(temp1.get("detalheAlunoEstadoCivil").toString());
                setDetalheAlunoDataNascimento(temp1.get("detalheAlunoDataNascimento").toString());
                setDetalheAlunoEndereco(temp1.get("detalheAlunoEndereco").toString());
                setDetalheAlunoNumero(temp1.get("detalheAlunoNumero").toString());
                setDetalheAlunoEstado(temp1.get("detalheAlunoEstado").toString());
                setDetalheAlunoCidade(temp1.get("detalheAlunoCidade").toString());
                setDetalheAlunoBairro(temp1.get("detalheAlunoBairro").toString());
                setDetalheAlunoTelefone(temp1.get("detalheAlunoTelefone").toString());
                setDetalheAlunoCelular(temp1.get("detalheAlunoCelular").toString());
                setDetalheAlunoCargo(temp1.get("detalheAlunoCargo").toString());
                setDetalheAlunoFormacao(temp1.get("detalheAlunoFormacao").toString());
                setDetalheAlunoExperienciaProfissional(temp1.get("detalheAlunoExperienciaProfissional").toString());
                setDetalheAlunoQualificacaoEAtividadesComplementares(temp1.get("detalheAlunoQualificacaoEAtividadesComplementares").toString());
                setDetalheAlunoInformacaoAdicional(temp1.get("detalheAlunoInformacaoAdicional").toString());



            } catch (Exception e) {
                e.getMessage();
                temp1 = null;
            }
        }

        return detalhe;

    }

    public static int getAlunoId() {
        return alunoId;
    }

    public static void setAlunoId(int alunoId) {
        DetalheDoAluno.alunoId = alunoId;
    }

    public static String getAlunoNome() {
        return alunoNome;
    }

    public static void setAlunoNome(String alunoNome) {
        DetalheDoAluno.alunoNome = alunoNome;
    }

    public static String getAlunoMatricula() {
        return alunoMatricula;
    }

    public static void setAlunoMatricula(String alunoMatricula) {
        DetalheDoAluno.alunoMatricula = alunoMatricula;
    }

    public static String getAlunoEmail() {
        return alunoEmail;
    }

    public static void setAlunoEmail(String alunoEmail) {
        DetalheDoAluno.alunoEmail = alunoEmail;
    }

    public static int getAlunoPontuacao() {
        return alunoPontuacao;
    }

    public static void setAlunoPontuacao(int alunoPontuacao) {
        DetalheDoAluno.alunoPontuacao = alunoPontuacao;
    }

    public static String getAlunoStatus() {
        return alunoStatus;
    }

    public static void setAlunoStatus(String alunoStatus) {
        DetalheDoAluno.alunoStatus = alunoStatus;
    }

    public static int getCursoId() {
        return cursoId;
    }

    public static void setCursoId(int cursoId) {
        DetalheDoAluno.cursoId = cursoId;
    }

    public static String getCursoNome() {
        return cursoNome;
    }

    public static void setCursoNome(String cursoNome) {
        DetalheDoAluno.cursoNome = cursoNome;
    }

    public static String getAnoAno() {
        return anoAno;
    }

    public static void setAnoAno(String anoAno) {
        DetalheDoAluno.anoAno = anoAno;
    }

    public static String getAlunoImagem() {
        return alunoImagem;
    }

    public static void setAlunoImagem(String alunoImagem) {
        DetalheDoAluno.alunoImagem = alunoImagem;
    }

    public static String getAlunoAssinatura() {
        return alunoAssinatura;
    }

    public static void setAlunoAssinatura(String alunoAssinatura) {
        DetalheDoAluno.alunoAssinatura = alunoAssinatura;
    }

    public static int getAnoId() {
        return anoId;
    }

    public static void setAnoId(int anoId) {
        DetalheDoAluno.anoId = anoId;
    }

    public static String getAlunoConfiguracaoTimeline() {
        return alunoConfiguracaoTimeline;
    }

    public static void setAlunoConfiguracaoTimeline(String alunoConfiguracaoTimeline) {
        DetalheDoAluno.alunoConfiguracaoTimeline = alunoConfiguracaoTimeline;
    }

    public static String getDetalheAlunoNacionalidade() {
        return detalheAlunoNacionalidade;
    }

    public static void setDetalheAlunoNacionalidade(String detalheAlunoNacionalidade) {
        DetalheDoAluno.detalheAlunoNacionalidade = detalheAlunoNacionalidade;
    }

    public static String getDetalheAlunoEstadoCivil() {
        return detalheAlunoEstadoCivil;
    }

    public static void setDetalheAlunoEstadoCivil(String detalheAlunoEstadoCivil) {
        DetalheDoAluno.detalheAlunoEstadoCivil = detalheAlunoEstadoCivil;
    }

    public static String getDetalheAlunoDataNascimento() {
        return detalheAlunoDataNascimento;
    }

    public static void setDetalheAlunoDataNascimento(String detalheAlunoDataNascimento) {
        DetalheDoAluno.detalheAlunoDataNascimento = detalheAlunoDataNascimento;
    }

    public static String getDetalheAlunoEndereco() {
        return detalheAlunoEndereco;
    }

    public static void setDetalheAlunoEndereco(String detalheAlunoEndereco) {
        DetalheDoAluno.detalheAlunoEndereco = detalheAlunoEndereco;
    }

    public static String getDetalheAlunoNumero() {
        return detalheAlunoNumero;
    }

    public static void setDetalheAlunoNumero(String detalheAlunoNumero) {
        DetalheDoAluno.detalheAlunoNumero = detalheAlunoNumero;
    }

    public static String getDetalheAlunoEstado() {
        return detalheAlunoEstado;
    }

    public static void setDetalheAlunoEstado(String detalheAlunoEstado) {
        DetalheDoAluno.detalheAlunoEstado = detalheAlunoEstado;
    }

    public static String getDetalheAlunoCidade() {
        return detalheAlunoCidade;
    }

    public static void setDetalheAlunoCidade(String detalheAlunoCidade) {
        DetalheDoAluno.detalheAlunoCidade = detalheAlunoCidade;
    }

    public static String getDetalheAlunoBairro() {
        return detalheAlunoBairro;
    }

    public static void setDetalheAlunoBairro(String detalheAlunoBairro) {
        DetalheDoAluno.detalheAlunoBairro = detalheAlunoBairro;
    }

    public static String getDetalheAlunoTelefone() {
        return detalheAlunoTelefone;
    }

    public static void setDetalheAlunoTelefone(String detalheAlunoTelefone) {
        DetalheDoAluno.detalheAlunoTelefone = detalheAlunoTelefone;
    }

    public static String getDetalheAlunoCelular() {
        return detalheAlunoCelular;
    }

    public static void setDetalheAlunoCelular(String detalheAlunoCelular) {
        DetalheDoAluno.detalheAlunoCelular = detalheAlunoCelular;
    }

    public static String getDetalheAlunoCargo() {
        return detalheAlunoCargo;
    }

    public static void setDetalheAlunoCargo(String detalheAlunoCargo) {
        DetalheDoAluno.detalheAlunoCargo = detalheAlunoCargo;
    }

    public static String getDetalheAlunoFormacao() {
        return detalheAlunoFormacao;
    }

    public static void setDetalheAlunoFormacao(String detalheAlunoFormacao) {
        DetalheDoAluno.detalheAlunoFormacao = detalheAlunoFormacao;
    }

    public static String getDetalheAlunoExperienciaProfissional() {
        return detalheAlunoExperienciaProfissional;
    }

    public static void setDetalheAlunoExperienciaProfissional(String detalheAlunoExperienciaProfissional) {
        DetalheDoAluno.detalheAlunoExperienciaProfissional = detalheAlunoExperienciaProfissional;
    }

    public static String getDetalheAlunoQualificacaoEAtividadesComplementares() {
        return detalheAlunoQualificacaoEAtividadesComplementares;
    }

    public static void setDetalheAlunoQualificacaoEAtividadesComplementares(String detalheAlunoQualificacaoEAtividadesComplementares) {
        DetalheDoAluno.detalheAlunoQualificacaoEAtividadesComplementares = detalheAlunoQualificacaoEAtividadesComplementares;
    }

    public static String getDetalheAlunoInformacaoAdicional() {
        return detalheAlunoInformacaoAdicional;
    }

    public static void setDetalheAlunoInformacaoAdicional(String detalheAlunoInformacaoAdicional) {
        DetalheDoAluno.detalheAlunoInformacaoAdicional = detalheAlunoInformacaoAdicional;
    }
}
