package testGeneric;

import java.util.List;

/**
 * 测试CustomerDAO
 */
public class TestCustomerDAO {
    public static void main(String[] args) {
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.add(new Customer());
        customerDAO.get(0);
        List<Customer> list = customerDAO.getForList(3);
        customerDAO.delete(2);
    }
}
