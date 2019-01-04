public class Program {
    public static void main(String[] args) {
        String lineFormat = "%-16s %-6s %-12s %-4s";
        System.out.println(String.format(lineFormat, "SpaceLine", "Days", "Trip Type", "Cost"));
        System.out.println("==========================================");
        for (int i = 0; i <= 10; i++) {
            System.out.println(Ticket.printTable());
        }
    }
}
