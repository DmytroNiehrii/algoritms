package multithreading.countDownLatch;

import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * Created by dmitriyn on 1/27/16.
 */
public class Race {
    private Random rand = new Random();

    private int distance = rand.nextInt(100);
    private CountDownLatch start;
    private CountDownLatch finish;

    public static void main(String[] args) throws InterruptedException {
        Race race = new Race("Horse1", "Horse2");
        race.run();
    }

    private List<String> horses = new ArrayList<>();

    public Race(String... names) {
        this.horses.addAll(Arrays.asList(names));
    }

    public void run() throws InterruptedException {
        System.out.println("And the horses are stepping up to the gate...");
        final CountDownLatch start = new CountDownLatch(1);
        final CountDownLatch finish = new CountDownLatch(horses.size());
        final List<String> places = Collections.synchronizedList(new ArrayList<String>());

        for (final String horse : horses)
        {
            new Thread(new Runnable() {
                public void run() {
                    try
                    {
                        System.out.println(horse + " stepping up to the gate...");
                        start.await();

                        int traveled = 0;
                        while (traveled < distance)
                        {
                            // через 0-2 секунды....
                            Thread.sleep(rand.nextInt(3) * 1000);

                            // ... лошадь проходит дистанцию 0-14 пунктов
                            traveled += rand.nextInt(15);
                            System.out.println(horse + " advanced to " + traveled + "!");
                        }
                        finish.countDown();
                        System.out.println(horse + " crossed the finish!");
                        places.add(horse);
                    } catch (InterruptedException intEx) {
                        System.out.println("ABORTING RACE!!!");
                        intEx.printStackTrace();
                    }
                }
            }).start();
        }

        System.out.println("And... they're off!");
        start.countDown();

        finish.await();
        System.out.println("And we have our winners!");
        System.out.println(places.get(0) + " took the gold...");
        System.out.println(places.get(1) + " got the silver...");
        System.out.println("and " + places.get(2) + " took home the bronze.");
    }

    public int getDistance() {
        return distance;
    }
}
