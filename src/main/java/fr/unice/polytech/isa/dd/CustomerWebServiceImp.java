package fr.unice.polytech.isa.dd;

import fr.unice.polytech.isa.dd.entities.Customer;
import fr.unice.polytech.isa.dd.CustomerFinder;
import fr.unice.polytech.isa.dd.CustomerRegistration;
import fr.unice.polytech.isa.dd.exceptions.AlreadyExistingCustomerException;
import fr.unice.polytech.isa.dd.exceptions.UnknownCustomerException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

@WebService(targetNamespace = "http://www.polytech.unice.fr/si/4a/isa/dd/customerService")
@Stateless(name = "CustomerWS")
public class CustomerWebServiceImp implements CustomerWebService {

    @EJB
    private CustomerFinder customerFinder;
    @EJB
    private CustomerRegistration customerRegistration;

    @Override
    public Boolean registerCustomer(String customer_firstName, String customer_lastName, String customer_adress) throws AlreadyExistingCustomerException {
        System.out.println("registerCustomer");
        return customerRegistration.registerCustomer(customer_firstName, customer_lastName, customer_adress);
    }

    @Override
    public Customer findCustomer(String customerName) throws UnknownCustomerException {
        System.out.println("findCustomer");
        return customerFinder.findCustomerByName(customerName);
    }

    @Override
    public boolean deleteAll() {
        System.out.println("deleteAll");
        return customerFinder.deleteAll();
    }

}
