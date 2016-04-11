import java.util.ArrayList;

public class BetterProgrammerTask4 {

    static final int PENNY_CONST = 1;
    static final int NICKEL_CONST = 5;
    static final int DIME_CONST = 10;
    static final int QUARTER_CONST = 25;
    static final int HALFDOLLAR_CONST = 50;

    public static void main(String[] args) {
        System.out.println(countWaysToProduceGivenAmountOfMoney(11));
    }

    public static int countWaysToProduceGivenAmountOfMoney(int cents)
    {
        /*
          Please implement this method to
          return the number of different combinations of US coins
          (penny: 1c, nickel: 5c, dime: 10c, quarter: 25c, half-dollar: 50c)
          which may be used to produce a given amount of money.

          For example, 11 cents can be produced with
          one 10-cent coin and one 1-cent coin,
          two 5-cent coins and one 1-cent coin,
          one 5-cent coin and six 1-cent coins,
          or eleven 1-cent coins.
          So there are four unique ways to produce 11 cents.
          Assume that the cents parameter is always positive.
         */

        if (cents <= 0)
        {
            return 0;
        }

        int count = 1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(NICKEL_CONST);
        list.add(DIME_CONST);
        list.add(QUARTER_CONST);
        list.add(HALFDOLLAR_CONST);

        Integer temp = cents;
        int cNickels = getCountOfNickels(temp);
        if (cNickels > 0)
        {
            count += cNickels;
        }
        int cDimes = getCountOfDime(temp);
        if (cDimes > 0)
        {
            for (int i = 0; i < cDimes; i++)
            {
                count++;
                count += countUDime(temp - (i+1) * DIME_CONST);
            }
        }
        int cQuarter = getCountOfQuarters(temp);
        if (cQuarter > 0)
        {
            for (int i = 0; i < cQuarter; i++)
            {
                count++;
                count += countUQuarter(temp - (i+1) * QUARTER_CONST);
            }
        }
        int cHalfDollar = getCountOfHalfDollars(temp);
        if (cHalfDollar > 0)
        {
            for (int i = 0; i < cHalfDollar; i++)
            {
                count++;
                count += countUHalfDollar(temp - (i+1) * HALFDOLLAR_CONST);
            }
        }

        return count;
    }

    private static int getCountOfHalfDollars(Integer temp)
    {
        return temp / HALFDOLLAR_CONST;
    }

    private static int getCountOfQuarters(Integer temp)
    {
        return temp / QUARTER_CONST;
    }

    private static int getCountOfNickels(Integer integer)
    {
        return integer / NICKEL_CONST;
    }

    private static int getCountOfDime(Integer integer)
    {
        return integer / DIME_CONST;
    }

    private static int countUQuarter(Integer temp)
    {
        int count = 0;
        int cNickels = getCountOfNickels(temp);
        if (cNickels > 0)
        {
            count += cNickels;
        }
        int cDimes = getCountOfDime(temp);
        if (cDimes > 0)
        {
            for (int i = 0; i < cDimes; i++)
            {
                count++;
                count += countUDime(temp - i * DIME_CONST);
            }
        }
        return count;
    }

    private static int countUDime(Integer temp)
    {
        int count = 0;
        int cNickels = getCountOfNickels(temp);
        if (cNickels > 0)
        {
            count += cNickels;
        }
        return count;
    }

    private static int countUHalfDollar(Integer temp)
    {
        int count = 0;
        int cNickels = getCountOfNickels(temp);
        if (cNickels > 0)
        {
            count += cNickels;
        }
        int cDimes = getCountOfDime(temp);
        if (cDimes > 0)
        {
            for (int i = 0; i < cDimes; i++)
            {
                count++;
                count += countUDime(temp - i * DIME_CONST);
            }
        }
        int cQuarter = getCountOfQuarters(temp);
        if (cQuarter > 0)
        {
            for (int i = 0; i < cQuarter; i++)
            {
                count++;
                count += countUQuarter(temp - i * QUARTER_CONST);
            }
        }
        return count;
    }

}






