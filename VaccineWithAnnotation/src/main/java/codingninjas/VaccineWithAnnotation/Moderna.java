package codingninjas.VaccineWithAnnotation;

import org.springframework.stereotype.Component;

@Component("Moderna")
public class Moderna implements Vaccine{

    @Override
    public String getType() {
        return "Moderna";
    }
}
