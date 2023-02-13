package coding.ninjas.insurance.PolicyType;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("healthCoverage")
public class HealthCoverage implements Policy{

    @Override
    public void showMessage() {
        System.out.println("You have selected HealthCoverage Policy.");
    }
}
