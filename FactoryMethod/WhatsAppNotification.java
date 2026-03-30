public class WhatsAppNotification implements Notification {
    private String phoneNumber;
    private String contactName;
    
    public WhatsAppNotification() {
        this.phoneNumber = "+55 11 98888-7777";
        this.contactName = "Cliente WhatsApp";
    }
    
    @Override
    public void send(String message) {
        System.out.println("\n========================================");
        System.out.println("💬 ENVIANDO WHATSAPP");
        System.out.println("========================================");
        System.out.println("Para: " + contactName);
        System.out.println("Número: " + phoneNumber);
        System.out.println("Mensagem: " + message);
        System.out.println("Status: ✅ Mensagem entregue com sucesso!");
        System.out.println("Ícones: 📱 ✓✓ (duplo check azul)");
        System.out.println("========================================\n");
    }
    
    @Override
    public String getType() {
        return "WhatsApp";
    }
}