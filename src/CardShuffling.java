import java.util.Arrays;

public class CardShuffling {
    

    public static void main(String[] args) {
        CardShuffling cardShuffling = new CardShuffling();
        int[] cards = new int[52];
        String abc="abcdefghijklmn";
        for (int i = 0; i <cards.length ; i++)cards[i]=i;
        System.out.println("Initial state of the deck");
        System.out.println(Arrays.toString(cards));
        knuthShuffle(cards);
        System.out.println("After shuffling");
        System.out.println(Arrays.toString(cards));
        System.out.println(abc.substring(0, 0));
        System.out.println(abc.substring(0));
    }
    
    /** Generates a random permutation of the array using Knuth's shuffle algorithm */
    public static void knuthShuffle(int[] a) {
      for (int i = 0; i < a.length; i++) {
        // Pick a random index in i ... a.length-1
        int k = i + (int) (Math.random() * (a.length - i));
        System.out.println(k);
        // Swap.
        int temp = a[i];
        a[i] = a[k];
        a[k] = temp;
      }
    }
}
