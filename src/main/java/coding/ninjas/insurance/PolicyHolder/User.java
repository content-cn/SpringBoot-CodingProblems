package coding.ninjas.insurance.PolicyHolder;

import coding.ninjas.insurance.Claim.Claim;
import coding.ninjas.insurance.PolicyType.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class User implements UserInterface{

    private String name;

    private Integer age;

    private Claim claim;

    private Policy policy;


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Autowired
    public void setClaim(Claim claim) {
        this.claim = claim;
    }

    @Autowired
    public void setPolicy(Policy policy) {
        this.policy = policy;
    }
    public void printDetails(){

        System.out.println("User name: "+this.name);
        System.out.println("User age: "+this.age);
//        System.out.println("User policy: "+this.policy.policyName());
//        System.out.println("Userclaim: "+this.claim.claimName());

    }
}
