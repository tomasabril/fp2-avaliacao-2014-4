package utfpr.ct.dainf.if62c.avaliacao;

import java.util.TimerTask;

/**
 * IF62C Fundamentos de Programação 2 Avaliação parcial.
 *
 * @author Tomás Abril <tomas@alunos.utfpr.edu.br>
 */
public class Aviso extends TimerTask {

    protected final Compromisso compromisso;

    public Aviso(Compromisso compromisso) {
        this.compromisso = compromisso;
    }

    @Override
    public void run() {
        System.out.println(compromisso.getDescricao() + " começa em " + (compromisso.getData().getTime() - System.currentTimeMillis())/1000 + "s.");

    }

}
