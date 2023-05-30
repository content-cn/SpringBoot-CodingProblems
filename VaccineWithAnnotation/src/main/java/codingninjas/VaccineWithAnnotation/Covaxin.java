package codingninjas.VaccineWithAnnotation;
import org.springframework.stereotype.Component;

@Component("Covaxin")
public class Covaxin implements Vaccine{

    @Override
    public String getType() {
        return "Covaxin";
    }
}
