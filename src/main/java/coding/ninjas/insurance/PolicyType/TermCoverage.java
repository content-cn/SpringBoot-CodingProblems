package coding.ninjas.insurance.PolicyType;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("termCoverage")
public class TermCoverage implements Policy{

    @Override
    public void showMessage() {
        System.out.println("You have selected TermCoverage Policy.");
    }

}
