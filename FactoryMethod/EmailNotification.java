public class EmailNotification implements Notification {
    private String recipient;
    
    public EmailNotification() {
        this.recipient = "cliente@email.com";
    }
    
    @Override
    public void send(String message) {
        System.out.println("\n========================================");
        System.out.println("ENVIANDO E-MAIL");
        System.out.println("========================================");
        System.out.println("Para: " + recipient);
        System.out.println("Mensagem: " + message);
        System.out.println("Status: Enviado com sucesso!");
        System.out.println("========================================\n");
    }
    
    @Override
    public String getType() {
        return "E-mail";
    }
}