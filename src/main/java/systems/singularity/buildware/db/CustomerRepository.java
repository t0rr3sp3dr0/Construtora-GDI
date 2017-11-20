package systems.singularity.buildware.db;

import systems.singularity.buildware.enums.CBO;
import systems.singularity.buildware.enums.MaritalStatus;
import systems.singularity.buildware.interfaces.Repository;
import systems.singularity.buildware.models.Customer;
import systems.singularity.buildware.models.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public final class CustomerRepository implements Repository<Customer, Integer> {
    CustomerRepository() {
        // Avoid class instantiation
    }

    @Override
    public Customer get(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = ?");
        statement.setInt(1, integer);
        ResultSet rs = statement.executeQuery();
        if (!rs.next())
            throw new SQLException("Customer Not Found");

        return new Customer()
                .id(rs.getInt(1))
                .person(new Person().id(rs.getInt(2)))
                .email(rs.getString(3))
                .job(rs.getString(4))
                .maritalStatus(MaritalStatus.valueOf("_" + rs.getString(5)));
    }

    @Override
    public Set<Customer> getAll() throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM CUSTOMER");
        ResultSet rs = statement.executeQuery();
        Set<Customer> set = new HashSet<>();
        while (rs.next())
            set.add(
                    new Customer()
                            .id(rs.getInt(1))
                            .person(new Person().id(rs.getInt(2)))
                            .email(rs.getString(3))
                            .job(rs.getString(4))
                            .maritalStatus(MaritalStatus.valueOf("_" + rs.getString(5)))
            );
        return set;
    }

    @Override
    public boolean exists(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT COUNT(*) FROM CUSTOMER WHERE CUSTOMER_ID = ?");
        statement.setInt(1, integer);
        ResultSet rs = statement.executeQuery();
        rs.next();
        return rs.getInt(1) > 0;
    }

    @Override
    public Integer insert(Customer customer) throws SQLException {
        Connection conn = Database.getConnection();
        {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO CUSTOMER (CUSTOMER_PERSON_ID, CUSTOMER_EMAIL, CUSTOMER_JOB, CUSTOMER_MARITAL_STATUS) VALUES (?, ?, ?, ?)");
            statement.setInt(1, customer.getPerson().getId());
            statement.setString(2, customer.getEmail());
            statement.setString(3, customer.getJob());
            statement.setString(4, customer.getMaritalStatus().getId());
            statement.executeUpdate();
        }
        {
            PreparedStatement statement = conn.prepareStatement("SELECT CUSTOMER_SEQ.currval FROM dual");
            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
    }

    @Override
    public void update(Customer customer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("UPDATE CUSTOMER SET CUSTOMER_PERSON_ID = ?, CUSTOMER_EMAIL = ?, CUSTOMER_JOB = ?, CUSTOMER_MARITAL_STATUS = ? WHERE CUSTOMER_ID = ?");
        statement.setInt(1, customer.getPerson().getId());
        statement.setString(2, customer.getEmail());
        statement.setString(3, customer.getJob());
        statement.setString(4, customer.getMaritalStatus().getId());
        statement.setInt(5, customer.getId());
        statement.executeUpdate();
    }

    @Override
    public void remove(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("DELETE FROM CUSTOMER WHERE CUSTOMER_ID = ?");
        statement.setInt(1, integer);
        statement.executeUpdate();
    }
}
