import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n========================================");
        System.out.println("      SISTEMA DE NOTIFICAÇÕES");
        System.out.println("========================================\n");
        
        int opcao;
        
        do {
            System.out.println("ESCOLHA UM CANAL DE NOTIFICAÇÃO:");
            System.out.println("--------------------------------");
            System.out.println("1 - E-mail");
            System.out.println("2 - SMS");
            System.out.println("3 - Push Notification");
            System.out.println("4 - WhatsApp");  // ← NOVO CANAL ADICIONADO
            System.out.println("0 - Sair");
            System.out.println("--------------------------------");
            System.out.print("Opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            if (opcao == 0) {
                System.out.println("\nPrograma encerrado! Até mais.\n");
                break;
            }
            
            if (opcao < 1 || opcao > 4) {  // ← ATUALIZADO: agora vai até 4
                System.out.println("\nOpção inválida! Tente novamente.\n");
                continue;
            }
            
            System.out.print("\nDigite a mensagem a ser enviada: ");
            String mensagem = scanner.nextLine();
            
            if (mensagem.trim().isEmpty()) {
                System.out.println("\nMensagem não pode ser vazia!\n");
                continue;
            }
            
            NotificationFactory fabrica = null;
            
            if (opcao == 1) {
                fabrica = new EmailFactory();
                System.out.println("\n>> Processando envio por E-mail...");
            } else if (opcao == 2) {
                fabrica = new SMSFactory();
                System.out.println("\n>> Processando envio por SMS...");
            } else if (opcao == 3) {
                fabrica = new PushFactory();
                System.out.println("\n>> Processando envio por Push Notification...");
            } else if (opcao == 4) {  // ← NOVA CONDIÇÃO ADICIONADA
                fabrica = new WhatsAppFactory();
                System.out.println("\n>> Processando envio por WhatsApp...");
            }
            
            fabrica.sendNotification(mensagem);
            
            System.out.println("Pressione ENTER para continuar...");
            scanner.nextLine();
            
            // Limpa a tela (simples)
            for (int i = 0; i < 40; i++) {
                System.out.println();
            }
            
        } while (opcao != 0);
        
        scanner.close();
    }
}