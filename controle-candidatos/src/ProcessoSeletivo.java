import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        imprimirSelecionados();
    }

    static void imprimirSelecionados() {
        String [] candidatos = {"João", "Maria", "José", "Ana", "Carlos"};

        for(int i = 0; i < candidatos.length; i++) {
            System.out.println("Candidato nº " + (i+1) + " é o(a) " + candidatos[i]);
        }
    }

    static void selecaoCandidatos() {
        String [] candidatos = {"João", "Maria", "José", "Ana", "Carlos", "Mariana", "Pedro", "Paula"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000;

        while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O Candidato " + candidato + " pretende ganhar R$" + salarioPretendido);
            if(salarioBase >= salarioPretendido) {
                System.out.println("O candidato" + candidato + " foi selecionado");
                candidatosSelecionados++;
            }

            candidatoAtual++;
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioOferecido) {
        double salarioBase = 2000;

        if (salarioBase < salarioOferecido) {
            System.out.println("LIGAR PARA CANIDATO");
        } else if (salarioBase == salarioOferecido) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
}
