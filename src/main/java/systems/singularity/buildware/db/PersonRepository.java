package systems.singularity.buildware.db;

import systems.singularity.buildware.enums.Gender;
import systems.singularity.buildware.interfaces.Repository;
import systems.singularity.buildware.models.Address;
import systems.singularity.buildware.models.Person;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public final class PersonRepository implements Repository<Person, Integer> {
    PersonRepository() {
        // Avoid class instantiation
    }

    @Override
    public Person get(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM PERSON WHERE PERSON_ID = ?");
        statement.setInt(1, integer);
        ResultSet rs = statement.executeQuery();
        if (!rs.next())
            throw new SQLException("Person Not Found");

        return new Person()
                .id(rs.getInt(1))
                .name(rs.getString(2))
                .cpf(rs.getString(3))
                .birthdate(rs.getDate(4))
                .gender(Gender.valueOf("_" + rs.getString(5)))
                .address(new Address().id(rs.getInt(6)));
    }

    @Override
    public Set<Person> getAll() throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM PERSON");
        ResultSet rs = statement.executeQuery();
        Set<Person> set = new HashSet<>();
        while (rs.next())
            set.add(
                    new Person()
                            .id(rs.getInt(1))
                            .name(rs.getString(2))
                            .cpf(rs.getString(3))
                            .birthdate(rs.getDate(4))
                            .gender(Gender.valueOf("_" + rs.getString(5)))
                            .address(new Address().id(rs.getInt(6)))
            );
        return set;
    }

    @Override
    public boolean exists(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM PERSON WHERE PERSON_ID = ?");
        statement.setInt(1, integer);
        ResultSet rs = statement.executeQuery();
        rs.next();
        return rs.getInt(1) > 0;
    }

    @Override
    public Integer insert(Person person) throws SQLException {
        Connection conn = Database.getConnection();
        {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO PERSON (PERSON_NAME, PERSON_CPF, PERSON_BIRTHDATE, PERSON_GENDER, PERSON_ADDRESS_ID) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, person.getName());
            statement.setString(2, person.getCPF());
            statement.setDate(3, (Date) person.getBirthdate());
            statement.setString(4, person.getGender().getId());
            statement.setInt(5, person.getAddress().getId());
            statement.executeUpdate();
        }
        {
            PreparedStatement statement = conn.prepareStatement("SELECT PERSON_SEQ.currval FROM dual");
            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
    }

    @Override
    public void update(Person person) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("UPDATE PERSON SET PERSON_NAME = ?, PERSON_CPF = ?, PERSON_BIRTHDATE = ?, PERSON_GENDER = ?, PERSON_ADDRESS_ID = ? WHERE PERSON_ID = ?");
        statement.setString(1, person.getName());
        statement.setString(2, person.getCPF());
        statement.setDate(3, (Date) person.getBirthdate());
        statement.setString(4, person.getGender().getId());
        statement.setInt(5, person.getAddress().getId());
        statement.setInt(6, person.getId());
        statement.executeUpdate();
    }

    @Override
    public void remove(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("DELETE FROM PERSON WHERE PERSON_ID = ?");
        statement.setInt(1, integer);
        statement.executeUpdate();
    }
}
