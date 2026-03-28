import java.util.HashMap;

public class Triplets
{
    public static HashMap<Integer,int[]> palindromeTriplets(String[] strings)//O(n^4)
    {
        HashMap<Integer,int[]> triplets = new HashMap<>();
        int count = 0;

        for (int i = 0; i < strings.length; i++)//(O(n))
        {
            for (int j = 0; j < strings.length; j++)//(O(n)
            {
                if (j == i) continue;

                for (int k = 0; k < strings.length; k++)//O(n)
                {
                    if (k == j || k == i) continue;
                    String combo = strings[i] + strings[j] + strings[k];
                    int left = 0;
                    int right = combo.length() - 1;
                    boolean isPal = true;
                    while (left <= right)//O(n/2)->O(n)
                    {
                        if (combo.charAt(left) != combo.charAt(right))
                        {
                            isPal = false;
                            break;
                        }
                        left++;
                        right--;
                    }
                    if (isPal)
                    {
                        int[] triplet = {i,j,k};
                        triplets.put(count, triplet);
                        count++;
                    }
                }
            }
        }
        return triplets;
    }

    public static void main(String[] args)
    {
        String[] words = {"race", "car", "ecar", ""};
        HashMap<Integer, int[]> triplets = palindromeTriplets(words);
        for (int i = 0; i < words.length; i++)
        {
            System.out.print("'" + words[i] + "'");
            if (i < words.length - 1)
                System.out.print(", ");
        }
        System.out.print("\n[");
        for (int i = 0; i < triplets.size(); i++)
        {
            System.out.print("{");
            for (int j = 0; j < 3; j++)
            {
                System.out.print(triplets.get(i)[j]);
                if (j < 2)
                    System.out.print(", ");
            }
            System.out.print("}");
            if (i < triplets.size() - 1)
                System.out.print(", ");
        }
        System.out.print("]");

    }
}
