package centralaedb.centralaedb_app.fragmentos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MeuFragmentPagerAdapter extends FragmentPagerAdapter {
    // 10 páginas
    final int TOTAL_PAGINAS = 3;
    public MeuFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        // TODO Auto-generated constructor stub

    }
    @Override
    public Fragment getItem(int position) {

        fragmentInicio fragInicio = new fragmentInicio();
        fragmentPerfil fragPerfil = new fragmentPerfil();
        fragmentForum fragForum = new fragmentForum();
        fragmentTopico fragTop = new fragmentTopico();
      //  fragmentMensagem fragMensagem = new fragmentMensagem();
        // Passa a posição do item como
        // parâmetro para o fragment
        Bundle data = new Bundle();

        int pagina = position +1;

        //1 - timeline (inicio)
        //2 - perfil
        //3 - mensagem
        //4 - forum
        //5
        //6
        //7
        //8
        //9
        //10

        data.putInt("pagina_atual", pagina);
        fragInicio.setArguments(data);
        fragPerfil.setArguments(data);
        fragForum.setArguments(data);
       // fragMensagem.setArguments(data);


        if(pagina == 1)
        {
            return fragInicio;
        }
        else if(pagina == 2)
        {
            return fragPerfil;
        }
       // else if(pagina == 3)
       // {
        //    return fragMensagem;
       // }
        else if(pagina == 3)
        {
            return fragForum;
        }
        else
        {
            return fragInicio;
        }


    }
    @Override
    public int getCount() {
        return TOTAL_PAGINAS;
    }
   /*@Override
      public CharSequence getPageTitle(int position) {

             return getPagina(position + 1);

         }

    public String getPagina(int i)
    {

       if(i == 1)
       {
           return "Inicio";
       }
       else if(i ==2)
       {
           return "Perfil";
       }
       else if(i ==3)
       {
           return "Mensagem";
       }
       else if(i ==4)
       {
           return "Fórum";
       }
        else
       {
           return Integer.toString(i);
       }

    }
*/


}
