import java.util.Comparator;

public class Rate_Compare implements Comparator<Hotel>
{

    @Override
    public int compare(Hotel o1, Hotel o2) {
        if(o1.getRate()< o2.getRate())
        {
            return -1;
        }
        else if(o1.getRate()>o2.getRate())
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}

