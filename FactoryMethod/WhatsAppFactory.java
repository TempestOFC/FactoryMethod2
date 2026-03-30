public class WhatsAppFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new WhatsAppNotification();
    }
}