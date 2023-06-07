import java.util.Comparator;

public class Ordina_Alfabetico implements Comparator<Hotel>
{

    @Override
    public int compare(Hotel o1, Hotel o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
