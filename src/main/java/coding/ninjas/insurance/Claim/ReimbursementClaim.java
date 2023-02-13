package coding.ninjas.insurance.Claim;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("reimbursementClaim")
public class ReimbursementClaim implements Claim{

    @Override
    public void showMessage() {
        System.out.println("You have selected ReimbursementClaim");
    }
}
