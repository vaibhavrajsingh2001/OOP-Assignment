import java.util.Random;

class Even extends Thread {
    int num;

    Even(int n) {
        num = n;
    }

    public void run() {
        final int square = (int) Math.pow(num, 2);
        System.out.println("Since the random number " + num + " is even, it's square is= " + square);
    }
}

class Odd extends Thread {
    int num;

    Odd(int n) {
        num = n;
    }

    public void run() {
        final int cube = (int) Math.pow(num, 3);
        System.out.println("Since the random number " + num + " is odd, it's cube is= " + cube);
    }
}

class RandomGenerator extends Thread {
    public void run() {
        Random rnd = new Random();

        while (true) {

            int num = rnd.nextInt(1000);
            Even e = new Even(num);
            Odd o = new Odd(num);
            if (num % 2 == 0) {
                e.start();
            } else {
                o.start();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }

    }
}

public class Second {
    public static void main(String[] args) {
        RandomGenerator r = new RandomGenerator();
        r.start();
    }

}