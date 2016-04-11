import java.util.ArrayList;
import java.util.List;

/**
 * Created by denisdyakin on 11/04/16.
 */
public class BetterProgrammerTask2 {

    public static void main(String[] args) {
        System.out.println(countPowerfulNumbers(4,16));
    }

    public static int countPowerfulNumbers(int from, int to)
    {

        /*
          A powerful number is a positive integer m that for every prime number p dividing m, p*p also divides m.

          (a prime number (or a prime) is a natural number that has exactly two (distinct) natural number divisors,
          which are 1 and the prime number itself, the first prime numbers are: 2, 3, 5, 7, 11, 13, ...)

          The first powerful numbers are: 1, 4, 8, 9, 16, 25, 27, 32, 36, ...

          Please implement this method to
          return the count of powerful numbers in the range [from..to] inclusively.
         */

        int countOfPowerful = 0;

        for(int i = from; i <= to; i++)
        {
            List<Integer> primeNumbers = allPrimesFrom(2, i);

            for(Integer integer : primeNumbers)
            {

                if(integer.compareTo(1) == -1)
                {
                    continue;
                }

                int m = integer * integer;

                if(i % integer.intValue() == 0 && i%m == 0)
                {
                    countOfPowerful++;
                }

            }
        }

        return countOfPowerful;

    }

    private static List<Integer> allPrimesFrom(int from, int to)
    {

        List<Integer> result = new ArrayList<Integer>();

        for (int tempN = from; tempN <= to; ++tempN)
        {

            boolean isPrime = true;

            for (int i = 2; i <= tempN / 2; i++)
            {
                if (tempN % i == 0)
                {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime)
            {
                result.add(tempN);
            }
        }

        return result;
    }
}
