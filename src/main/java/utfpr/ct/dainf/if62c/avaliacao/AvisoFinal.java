package utfpr.ct.dainf.if62c.avaliacao;

/**
 * IF62C Fundamentos de Programação 2
 * Avaliação parcial.
 * @author  Tomás Abril <tomas@alunos.utfpr.edu.br>
 */
public class AvisoFinal extends Aviso {

    public AvisoFinal(Compromisso compromisso) {
        super(compromisso);
    }
    @Override
    public void run(){
        System.out.println(compromisso.getDescricao() + " começa agora.");
        //agenda.cancela();
        for(Aviso aviso: compromisso.getAvisos()){
            aviso.cancel();
        }
    }
    
}
