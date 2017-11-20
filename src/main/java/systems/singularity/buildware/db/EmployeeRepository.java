package systems.singularity.buildware.db;

import systems.singularity.buildware.interfaces.Repository;
import systems.singularity.buildware.models.Employee;
import systems.singularity.buildware.models.Person;
import systems.singularity.buildware.models.Title;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public final class EmployeeRepository implements Repository<Employee, Integer> {
    EmployeeRepository() {
        // Avoid class instantiation
    }

    @Override
    public Employee get(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID = ?");
        statement.setInt(1, integer);
        ResultSet rs = statement.executeQuery();
        if (!rs.next())
            throw new SQLException("Employee Not Found");

        return new Employee()
                .id(rs.getInt(1))
                .person(new Person().id(rs.getInt(2)))
                .manager(new Employee().id(rs.getInt(3)))
                .title(new Title().id(rs.getInt(4)))
                .hiringDate(rs.getDate(5))
                .terminationDate(rs.getDate(6));
    }

    @Override
    public Set<Employee> getAll() throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM EMPLOYEE");
        ResultSet rs = statement.executeQuery();
        Set<Employee> set = new HashSet<>();
        while (rs.next())
            set.add(
                    new Employee()
                            .id(rs.getInt(1))
                            .person(new Person().id(rs.getInt(2)))
                            .manager(new Employee().id(rs.getInt(3)))
                            .title(new Title().id(rs.getInt(4)))
                            .hiringDate(rs.getDate(5))
                            .terminationDate(rs.getDate(6))
            );
        return set;
    }

    @Override
    public boolean exists(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT COUNT(*) FROM EMPLOYEE WHERE EMPLOYEE_ID = ?");
        statement.setInt(1, integer);
        ResultSet rs = statement.executeQuery();
        rs.next();
        return rs.getInt(1) > 0;
    }

    @Override
    public Integer insert(Employee employee) throws SQLException {
        Connection conn = Database.getConnection();
        {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO EMPLOYEE (EMPLOYEE_PERSON_ID, EMPLOYEE_MANAGER_ID, EMPLOYEE_TITLE_ID, EMPLOYEE_HIRING, EMPLOYEE_TERMINATION) VALUES (?, ?, ?, ?, ?)");
            statement.setInt(1, employee.getPerson().getId());
            statement.setInt(2, employee.getManager().getId());
            statement.setInt(3, employee.getTitle().getId());
            statement.setDate(4, (Date) employee.getHiringDate());
            statement.setDate(5, (Date) employee.getTerminationDate());
            statement.executeUpdate();
        }
        {
            PreparedStatement statement = conn.prepareStatement("SELECT EMPLOYEE_SEQ.currval FROM dual");
            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
    }

    @Override
    public void update(Employee employee) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("UPDATE EMPLOYEE SET EMPLOYEE_PERSON_ID = ?, EMPLOYEE_MANAGER_ID = ?, EMPLOYEE_TITLE_ID = ?, EMPLOYEE_HIRING = ?, EMPLOYEE_TERMINATION = ? WHERE EMPLOYEE_ID = ?");
        statement.setInt(1, employee.getPerson().getId());
        statement.setInt(2, employee.getManager().getId());
        statement.setInt(3, employee.getTitle().getId());
        statement.setDate(4, (Date) employee.getHiringDate());
        statement.setDate(5, (Date) employee.getTerminationDate());
        statement.setInt(6, employee.getId());
        statement.executeUpdate();
    }

    @Override
    public void remove(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("DELETE FROM EMPLOYEE WHERE EMPLOYEE_ID = ?");
        statement.setInt(1, integer);
        statement.executeUpdate();
    }
}
