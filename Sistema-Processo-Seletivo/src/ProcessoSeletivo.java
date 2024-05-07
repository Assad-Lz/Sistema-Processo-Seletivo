
/**
 * @author Yssaky Assad Luz
 * @version 0.0.1
 *          Sistema desenvolvido em Java para gerenciar e retornar media dos
 *          alunos em um processo seletivo,
 *          sistema feito para fins de estudo do BootCamp Java Santander
 * 
 */
import java.util.Scanner;
import java.util.Locale;
import java.util.ArrayList;
import java.util.InputMismatchException;

// Classe que contem o método principal
public class ProcessoSeletivo {
    private static final String[] cargos = null;

    public static void main(String[] args) {
        // Inicialização do Obj Scanner e do ArrayList de Cargos
        Scanner read = new Scanner(System.in).useLocale(Locale.US);

        ArrayList<String> cargos = new ArrayList<String>();

        // Montagem do Array
        cargos.add("Agente Penitenciário");
        cargos.add("Agente de Saúde");
        cargos.add("Auxiliar Administrativo");
        cargos.add("Técnico de Enfermagem");
        cargos.add("Inspetor de Trânsito");
        cargos.add("Bombeiro Militar");
        cargos.add("Analista de Finanças");
        cargos.add("Auditor Fiscal");
        cargos.add("Defensor Público");
        cargos.add("Delegado de Polícia");
        cargos.add("Engenheiro Civil");
        cargos.add("Professor");
        cargos.add("Médico");
        cargos.add("Psicólogo");
        cargos.add("Contador");

        boolean continuar = true;

        System.out.println(
                "Seja Bem-Vindo ao sistema de notas do concurso público, se você realizou a última prova em maio de 2024, insira no sistema as notas de Ciencias Naturais, Matematica e Conhecimentos Gerais\n\n");
        do {
            spaceLine();
            System.out.println("\n\nQual ação deseja efetuar?\n\n");
            System.out.println("1 - Ver lista de Cargos 2024\n");
            System.out.println("2 - Consultar Resultado\n");
            System.out.println("3 - Sair\n");

            int selecionarAcao = read.nextInt();
            System.out.println("\n\nVoce escolheu a ação: " + selecionarAcao + "\n\n");

            switch (selecionarAcao) {
                case 1:
                    System.out.println("Lista de Cargos Públicos: \n\n");
                    for (String cargo : cargos) {
                        System.out.println("- " + cargo);
                    }
                    break;
                case 2:
                    double notaCiencia = readNota(read, "Ciencia");
                    double notaMatematica = readNota(read, "Matematica");
                    double notaConGeral = readNota(read, "Conhecimentos Gerais");
                    double media = calcularMedia(notaCiencia, notaMatematica, notaConGeral);
                    System.out.println("\n\nSua média é: " + media);
                    if (media > 680) {
                        System.out.println("\n\nVoce esta aprovado, agora aguarde nossa equipe entrar em contato para marcar a entrevista tecnica");
                    } else {
                        System.out.println("\n\nInfelizmente, você não foi aprovado. Por favor, tente novamente.");
                    }
                    break;
                case 3:
                    System.out.println("\n\nSaindo do sistema...");
                    continuar = false;
                    break;
                default:
                    System.out.println("\n\nAção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        } while (continuar);

        read.close();
    }

    // Pilha de metodos
    static double calcularMedia(double notaDeCiencia, double notaDeMatematica, double notaDeConhecGerais) {
        return (notaDeCiencia + notaDeMatematica + notaDeConhecGerais) / 3;
    }

    static void spaceLine() {
        for (int i = 0; i < 50; i++) {
            System.out.print("_");
        }
    }

    static double readNota(Scanner read, String subject) {
        System.out.println("\n\nDigite sua nota de " + subject + ": ");
        return read.nextDouble();
    }
}
