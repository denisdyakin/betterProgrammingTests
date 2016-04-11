/**
 * Created by denisdyakin on 11/04/16.
 */
public class BetterProgrammerTask1 {

    private static final int CENTS_IN_DOLLARS_CONST = 100;
    private static final int CENTS_IN_QUARTERS_CONST = 25;
    private static final int CENTS_IN_DIMES_CONST = 10;
    private static final int CENTS_IN_NECKELS_CONST = 5;

    public static void main(String[] args) {
        int cents = 164;
        Change change = getCorrectChange(cents);
        System.out.println(String.format("%d cents = %d dollar, %d quarters, %d dime and %d cents", cents, change.getDollars(), change.getQuarters(), change.getDimes(), change.getCents()));
    }

    public static Change getCorrectChange(int cents) {
        /*
          Please implement this method to
          take cents as a parameter
          and return an equal amount in dollars and coins using the minimum number of
          coins possible.
          For example: 164 cents = 1 dollar, 2 quarters, 1 dime and 4 cents.
          Return null if the parameter is negative.

         */

        if (cents < 0)
        {
            return null;
        }

        int tempDollars = 0;
        int tempQuarters = 0;
        int tempDimes = 0;
        int tempNickels = 0;
        int tempCents = 0;

        int temp = cents;

        while (temp > CENTS_IN_DOLLARS_CONST)
        {
            tempDollars++;
            temp -= CENTS_IN_DOLLARS_CONST;
        }

        while (temp > CENTS_IN_QUARTERS_CONST)
        {
            tempQuarters++;
            temp -= CENTS_IN_QUARTERS_CONST;
        }

        while (temp > CENTS_IN_DIMES_CONST)
        {
            tempDimes++;
            temp -= CENTS_IN_DIMES_CONST;
        }

        while (temp > CENTS_IN_NECKELS_CONST)
        {
            tempNickels++;
            temp -= CENTS_IN_NECKELS_CONST;
        }

        tempCents = temp;

        return new Change(tempDollars, tempQuarters, tempDimes, tempNickels, tempCents);
    }


    // Please do not change this class
    static class Change {
        private final int _dollars;
        private final int _quarters; //25 cents
        private final int _dimes; // 10 cents
        private final int _nickels; // 5 cents
        private final int _cents; // 1 cent


        public Change(int dollars, int quarters, int dimes, int nickels, int cents) {
            _dollars = dollars;
            _quarters = quarters;
            _dimes = dimes;
            _nickels = nickels;
            _cents = cents;
        }


        public int getDollars() {
            return _dollars;
        }


        public int getQuarters() {
            return _quarters;
        }


        public int getDimes() {
            return _dimes;
        }


        public int getNickels() {
            return _nickels;
        }


        public int getCents() {
            return _cents;
        }
    }
}
