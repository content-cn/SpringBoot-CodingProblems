package coding.ninjas.insurance.Claim;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Component
@Qualifier("instantClaim")
public class InstantClaim implements Claim {

    @Override
    public void showMessage() {
        System.out.println("You have selected InstantClaim.");
    }
}
