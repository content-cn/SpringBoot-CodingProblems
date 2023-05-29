package codingninjas.VaccineWithAnnotation;

import org.springframework.stereotype.Component;

@Component("Covishield")
public class Covishield implements Vaccine{
    @Override
    public String getType() {
        return "Covishield";
    }
}
