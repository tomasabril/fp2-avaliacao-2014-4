package utfpr.ct.dainf.if62c.avaliacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

/**
 * IF62C Fundamentos de Programação 2 Avaliação parcial.
 *
 * @author Tomás Abril <tomas@alunos.utfpr.edu.br>
 */
public class Agenda {

    private final String descricao;
    private final List<Compromisso> compromissos = new ArrayList<>();
    private final Timer timer;

    public Agenda(String descricao) {
        this.descricao = descricao;
        timer = new Timer(descricao);
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Compromisso> getCompromissos() {
        return compromissos;
    }

    public void novoCompromisso(Compromisso compromisso) {
        compromissos.add(compromisso);
        Aviso aviso = new AvisoFinal(compromisso);
        compromisso.registraAviso(aviso);
        // com a classe Aviso devidamente implementada, o erro de compilação
        // deverá desaparecer
        timer.schedule(aviso, compromisso.getData());
    }

    public void novoAviso(Compromisso compromisso, int antecedencia) {
        Aviso aviso = new Aviso(compromisso);
        compromisso.registraAviso(aviso);
        timer.schedule(aviso, compromisso.getData().getTime() - (antecedencia * 1000) - System.currentTimeMillis());
    }

    public void novoAviso(Compromisso compromisso, int antecedencia, int intervalo) {
        Aviso aviso = new Aviso(compromisso);
        compromisso.registraAviso(aviso);
        timer.schedule(aviso, compromisso.getData().getTime() - (antecedencia * 1000) - System.currentTimeMillis(), intervalo * 1000);
    }

    public void cancela(Compromisso compromisso) {

        this.compromissos.remove(compromisso);
    }

    public void cancela(Aviso aviso) {
        aviso.cancel();
    }

    public void destroi() {
        timer.cancel();
    }
}
