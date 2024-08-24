import java.util.Date;
import java.util.Random;

public class Helper {
    static Date getRandomDate(Date baseDate, boolean recent, Random random) {
        long baseMillis = baseDate.getTime();
        long offsetMillis;
        if (recent) {
            // Within 20 days before baseDate
            offsetMillis = (long) (random.nextInt(21) * 24 * 60 * 60 * 1000L);
        } else {
            // Between 21 and 40 days before baseDate
            offsetMillis = (long) ((21 + random.nextInt(20)) * 24 * 60 * 60 * 1000L);
        }

        return new Date(baseMillis - offsetMillis);
    }
}
