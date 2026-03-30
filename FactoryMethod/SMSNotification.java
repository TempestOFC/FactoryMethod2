public class SMSNotification implements Notification {
    private String phoneNumber;
    
    public SMSNotification() {
        this.phoneNumber = "+55 11 99999-9999";
    }
    
    @Override
    public void send(String message) {
        System.out.println("\n========================================");
        System.out.println("ENVIANDO SMS");
        System.out.println("========================================");
        System.out.println("Número: " + phoneNumber);
        System.out.println("Mensagem: " + message);
        System.out.println("Status: Enviado com sucesso!");
        System.out.println("========================================\n");
    }
    
    @Override
    public String getType() {
        return "SMS";
    }
}