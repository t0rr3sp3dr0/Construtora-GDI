package systems.singularity.buildware.db;

import systems.singularity.buildware.interfaces.Repository;
import systems.singularity.buildware.models.Person;
import systems.singularity.buildware.models.Phone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public final class PhoneRepository implements Repository<Phone, Integer> {
    PhoneRepository() {
        // Avoid class instantiation
    }

    @Override
    public Phone get(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM PHONE WHERE PHONE_ID = ?");
        statement.setInt(1, integer);
        ResultSet rs = statement.executeQuery();
        if (!rs.next())
            throw new SQLException("Phone Not Found");

        return new Phone()
                .id(rs.getInt(1))
                .person(new Person().id(rs.getInt(2)))
                .number(rs.getString(3));
    }

    @Override
    public Set<Phone> getAll() throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM PHONE");
        ResultSet rs = statement.executeQuery();
        Set<Phone> set = new HashSet<>();
        while (rs.next())
            set.add(
                    new Phone()
                            .id(rs.getInt(1))
                            .person(new Person().id(rs.getInt(2)))
                            .number(rs.getString(3))
            );
        return set;
    }

    @Override
    public boolean exists(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT COUNT(*) FROM PHONE WHERE PHONE_ID = ?");
        statement.setInt(1, integer);
        ResultSet rs = statement.executeQuery();
        rs.next();
        return rs.getInt(1) > 0;
    }

    @Override
    public Integer insert(Phone phone) throws SQLException {
        Connection conn = Database.getConnection();
        {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO PHONE (PHONE_PERSON_ID, PHONE_NUMBER) VALUES (?, ?)");
            statement.setInt(1, phone.getPerson().getId());
            statement.setString(2, phone.getNumber());
            statement.executeUpdate();
        }
        {
            PreparedStatement statement = conn.prepareStatement("SELECT PHONE_SEQ.currval FROM dual");
            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
    }

    @Override
    public void update(Phone phone) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("UPDATE PHONE SET PHONE_PERSON_ID = ?, PHONE_NUMBER = ? WHERE PHONE_ID = ?");
        statement.setInt(1, phone.getPerson().getId());
        statement.setString(2, phone.getNumber());
        statement.setInt(3, phone.getId());
        statement.executeUpdate();
    }

    @Override
    public void remove(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("DELETE FROM PHONE WHERE PHONE_ID = ?");
        statement.setInt(1, integer);
        statement.executeUpdate();
    }
}
