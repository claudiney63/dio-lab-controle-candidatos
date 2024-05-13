import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        String[] candidatos = { "João", "Maria", "José", "Ana", "Carlos", "Mariana", "Pedro", "Paula" };

        for(String c: candidatos) {
            entrandoEmContato(c);
        }
    }

    static void entrandoEmContato(String candidato) {
        int tentativas = 1;
        boolean continuar = true;
        boolean atendido = false;

        do {
            atendido = atender();
            continuar = !atendido;

            if (continuar) {
                tentativas++;
            } else {
                System.out.println("CONTATO REALIZADO COM SUCESSO!");
            }

        } while (continuar && tentativas < 3);

        if (atendido) {
            System.out.println("CONSEGUIMOS CONTATO COM O CANDIDATO " + candidato + " NA TENTATIVA Nº" + tentativas + "!");
        } else {
            System.out.println("NÃO CONSEGUIMOS CONTATO COM O CANDIDATO " + candidato + ", NUMERO(" +tentativas+") DE TENTATIVAS ESGOTADO!");
        }
    }

    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    static void imprimirSelecionados() {
        String[] candidatos = { "João", "Maria", "José", "Ana", "Carlos" };

        for (int i = 0; i < candidatos.length; i++) {
            System.out.println("Candidato nº " + (i + 1) + " é o(a) " + candidatos[i]);
        }
    }

    static void selecaoCandidatos() {
        String[] candidatos = { "João", "Maria", "José", "Ana", "Carlos", "Mariana", "Pedro", "Paula" };

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000;

        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O Candidato " + candidato + " pretende ganhar R$" + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
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
