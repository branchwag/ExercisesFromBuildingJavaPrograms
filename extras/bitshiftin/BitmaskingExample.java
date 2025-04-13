public class BitmaskingExample {
    static final int READ = 1 << 0;   // 0001 = 1
    static final int WRITE = 1 << 1;  // 0010 = 2
    static final int EXECUTE = 1 << 2;// 0100 = 4

    public static void main(String[] args) {
        int permissions = 0;

        // Set permissions
        permissions |= READ;
        permissions |= WRITE;

        // Check permissions
        if ((permissions & READ) != 0) {
            System.out.println("Read permission is set.");
        }

        if ((permissions & EXECUTE) == 0) {
            System.out.println("Execute permission is NOT set.");
        }

        // Remove write permission
        permissions &= ~WRITE;

        // Final permissions
        System.out.println("Final permissions: " + permissions);
    }
}
