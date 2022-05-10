import com.explicitarch.demo.freelancer_management.application_core.freelancer.domain.Freelancer;
import com.explicitarch.demo.freelancer_management.application_core.freelancer.domain.FreelancerId;
import com.explicitarch.demo.shared_kernel.domain.value_object.Address;
import org.springframework.beans.factory.annotation.Value;

public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Freelancer f = new Freelancer(new FreelancerId("11"), "first", "last", new Address("1","V"));

        FreelancerId id = new FreelancerId("11");
        System.out.println(id.uniqueID);
    }
}
