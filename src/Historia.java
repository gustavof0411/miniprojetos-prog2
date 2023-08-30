import java.util.Scanner;
import java.util.HashMap;

public class Historia {
        public static void main(String[] args) throws Exception {
                Scanner continuar = new Scanner(System.in);
                HashMap<String, Personagem> personagens = ObterDadosDeArquivo.carregarPersonagem();
                HashMap<String, Capitulo> capitulos = ObterDadosDeArquivo.carregarCapitulo(personagens, continuar);
                Capitulo inicial;

                if (ObterDadosDeArquivo.verificaSave()) {
                        System.out.println("Foi detectado um progresso já existente. Deseja carregar o progresso?");
                        System.out.println("CARREGAR - DIGITE \"s\"");
                        System.out.println("INICIAR NOVO JOGO - DIGITE \"n\"");
                        System.out.print("Digite aqui:");
                        String querCarregar = continuar.nextLine();
                        while (!querCarregar.equalsIgnoreCase("s") && !querCarregar.equalsIgnoreCase("n")) {
                                System.out.println("Certifique-se se digitou corretamente.");
                                System.out.print("Digite novamente aqui:");
                                querCarregar = continuar.nextLine();
                        }
                        if (querCarregar.equalsIgnoreCase("s")) {
                                Capitulo capituloSave = ObterDadosDeArquivo
                                                .desserializadorDeCapitulo("rsc/saves/capituloSave.txt");
                                inicial = capitulos.get(capituloSave.getNome());
                                inicial.executar(continuar, capitulos);
                        } else {
                                inicial = capitulos.get("[CAPÍTULO 1 - O INÍCIO]");
                                inicial.executar(continuar, capitulos);
                        }
                } else {
                        inicial = capitulos.get("[CAPÍTULO 1 - O INÍCIO]");
                        inicial.executar(continuar, capitulos);

                }
        }
}