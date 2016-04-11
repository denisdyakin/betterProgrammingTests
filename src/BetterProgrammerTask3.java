import java.util.ArrayList;

/**
 * Created by denisdyakin on 11/04/16.
 */
public class BetterProgrammerTask3 {

    // Please do not change this interface
    interface ListNode {
        int getItem();
        ListNode getNext();
        void setNext(ListNode next);
    }


    public static ListNode reverse(ListNode node) {
        /*
          Please implement this method to
          reverse a given linked list.
         */
        if (node == null)
        {
            return null;
        }

        ArrayList<ListNode> list = new ArrayList<ListNode>();

        ListNode beg = node;

        list.add(beg);
        while (beg.getNext() != null)
        {
            beg = beg.getNext();
            list.add(beg);
        }



        for (int i = list.size() - 1; i > 0; i--)
        {
            list.get(i).setNext(list.get(i-1));
        }
        ListNode newBeg = list.get(list.size() - 1);
        list.get(0).setNext(null);

        return newBeg;
    }

}
