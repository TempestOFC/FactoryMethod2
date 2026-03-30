public class PushNotification implements Notification {
    private String deviceId;
    
    public PushNotification() {
        this.deviceId = "Device-ABC-123";
    }
    
    @Override
    public void send(String message) {
        System.out.println("\n========================================");
        System.out.println("ENVIANDO PUSH NOTIFICATION");
        System.out.println("========================================");
        System.out.println("Dispositivo: " + deviceId);
        System.out.println("Mensagem: " + message);
        System.out.println("Status: Notificação push enviada!");
        System.out.println("========================================\n");
    }
    
    @Override
    public String getType() {
        return "Push Notification";
    }
}