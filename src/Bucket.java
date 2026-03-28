public class Bucket
{
    public int size;
    public String[] strings;

    public Bucket()
    {
        size = 0;
        strings = new String[4];
    }

    public void add(String item)
    {
        if (size >= strings.length)
        {
            String[] temp = new String[size * 2];
            for (int i = 0; i < strings.length; i++)
                temp[i] = strings[i];
            strings = temp;
        }
        strings[size] = item;
        size++;
    }

    public String[] getBucket()
    {
        return strings;
    }
}
