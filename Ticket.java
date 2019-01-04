import java.util.concurrent.ThreadLocalRandom;

import com.sun.tools.classfile.StackMapTable_attribute.stack_map_frame;

public class Ticket {
    String spaceline;
    Integer speed;
    double days;
    double price;
    boolean isRoundTrip;

    public Ticket(String spaceline, Integer speed, boolean isRoundTrip) {
        this.spaceline = spaceline;
        this.speed = speed;
        this.isRoundTrip = isRoundTrip;
        this.days = computeDays(speed, isRoundTrip);
        this.price = computePrice(speed, isRoundTrip);
    }

    public static Ticket randomTicket() {
        return new Ticket(randomSpaceline(), randomSpeed(), randomIsRoundTrip());
    }

    public static Integer computeDays(Integer speed, Boolean isRoundTrip) {
        if (isRoundTrip == true) {
            return randomSpeed() * 2;
        } else {
            return randomSpeed();
        }
    }

    public static Integer computePrice(Integer speed, Boolean isRoundTrip) {
        if (isRoundTrip == true) {
            return (speed + 20) * 2;
        } else {
            return speed + 20;
        }
    }

    public static String randomSpaceline() {
        Integer randomName = ThreadLocalRandom.current().nextInt(0, 3);
        if (randomName.equals(0)) {
            return "SpaceX";
        } else if (randomName.equals(1)) {
            return "Space Adventures";
        } else if (randomName.equals(2)) {
            return "Virgin Galactic";
        } else {
            return null;
        }
    }

    public static Integer randomSpeed() {
        Integer kilometersToMars = 62100000;
        Integer minSpeed = 16;
        Integer maxSpeed = 30;
        Integer secondsPerDay = 24 * 60 * 60;
        Integer randomSpeed = ThreadLocalRandom.current().nextInt(minSpeed, maxSpeed);
        Integer seconds = kilometersToMars / randomSpeed;
        Integer days = seconds / secondsPerDay;
        return days;
    }

    public static boolean randomIsRoundTrip() {
        return ThreadLocalRandom.current().nextBoolean();
    }

    public String printTable() {
        String lineFormat = "%-16s %4s %12s   $%-6s";
        return String.format(lineFormat, this.spaceline, this.days, this.isRoundTrip, this.price);
    }
}
