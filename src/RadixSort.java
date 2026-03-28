
import java.util.HashMap;

public class RadixSort
{
    public static int radixGetMaxLength(String[] strings) {//O(n) time
        int maxLetters = 0;
        for (int i = 0; i < strings.length; i++)//O(n)
            if (strings[i].length() > maxLetters)
                maxLetters = strings[i].length();

        return maxLetters;//O(1)
    }

    public static void radixSort(String[] strings)//O(m * n)
    {
        HashMap<Integer, Bucket> buckets = new HashMap<>();
        for (int i = 0; i < 26; i++)//O(1) time
        {
            buckets.put(i, new Bucket());
        }

        int copyBack = 0;

        int max = radixGetMaxLength(strings);
        int index = 0;
        for(int charIndex = max - 1; charIndex >= 0; charIndex--)//O(m) -> m = maxLength
        {
            for (int i = 0; i < strings.length; i++)//O(n)
            {
                String s = strings[i];
                int bucketIndex;
                if (charIndex >= s.length())
                {
                    bucketIndex = 0;
                }else{
                    bucketIndex = s.charAt(charIndex) - 'a';
                }
                buckets.get(bucketIndex).add(s);
            }

            copyBack = 0;
            for (int i = 0;i < 26; i++)//O(1)
            {
                Bucket b = buckets.get(i);
                String[] bucket = b.getBucket();
                for (int j = 0; j < b.size; j++)
                {
                    strings[copyBack] = bucket[j];
                    copyBack++;
                }
                buckets.get(i).size = 0;
            }
            index++;
        }
    }

    public static void main(String[] args)
    {
        String[] strings = {"google", "gojo", "amazingly", "jogo", "luna", "pup", "solas", "solo", "pupperino", "amaterasu",
                "amazon", "puppy", "hydra", "amazonia", "vueltiao"};
        radixSort(strings);

        for (int i = 0; i < strings.length; i++)
            System.out.println(strings[i]);

    }
}
