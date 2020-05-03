package fr.unice.polytech.isa.dd;

//import fr.unice.polytech.isa.dd

import fr.unice.polytech.isa.dd.entities.Customer;
import fr.unice.polytech.isa.dd.exceptions.AlreadyExistingCustomerException;
import fr.unice.polytech.isa.dd.exceptions.UnknownCustomerException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace = "http://www.polytech.unice.fr/si/4a/isa/dd/customerService")
public interface CustomerWebService {

    @WebMethod
    Boolean registerCustomer(@WebParam(name="customer_first_name") String customer_firstName,
                  @WebParam(name="customer_last_name") String customer_lastName,
                  @WebParam(name="customer_adress") String customer_adress) throws AlreadyExistingCustomerException;



    @WebMethod
    @WebResult(name = "customer_find")
    Customer findCustomer(@WebParam(name="customer_name") String customerName) throws UnknownCustomerException;
}
