package systems.singularity.buildware.db;

import systems.singularity.buildware.interfaces.Repository;
import systems.singularity.buildware.models.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public final class AddressRepository implements Repository<Address, Integer> {
    AddressRepository() {
        // Avoid class instantiation
    }

    @Override
    public Address get(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM ADDRESS WHERE ADDRESS_ID = ?");
        statement.setInt(1, integer);
        ResultSet rs = statement.executeQuery();
        if (!rs.next())
            throw new SQLException("Address Not Found");

        return new Address()
                .id(rs.getInt(1))
                .street(rs.getString(2))
                .number(Integer.toString(rs.getInt(3)))
                .complement(rs.getString(4))
                .neighborhood(rs.getString(5))
                .zipCode(rs.getString(6))
                .city(rs.getString(7))
                .state(rs.getString(8));
    }

    @Override
    public Set<Address> getAll() throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM ADDRESS");
        ResultSet rs = statement.executeQuery();
        Set<Address> set = new HashSet<>();
        while (rs.next())
            set.add(
                    new Address()
                            .id(rs.getInt(1))
                            .street(rs.getString(2))
                            .number(Integer.toString(rs.getInt(3)))
                            .complement(rs.getString(4))
                            .neighborhood(rs.getString(5))
                            .zipCode(rs.getString(6))
                            .city(rs.getString(7))
                            .state(rs.getString(8))
            );
        return set;
    }

    @Override
    public boolean exists(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT COUNT(*) FROM ADDRESS WHERE ADDRESS_ID = ?");
        statement.setInt(1, integer);
        ResultSet rs = statement.executeQuery();
        rs.next();
        return rs.getInt(1) > 0;
    }

    @Override
    public Integer insert(Address address) throws SQLException {
        Connection conn = Database.getConnection();
        {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO ADDRESS (ADDRESS_STREET, ADDRESS_NUMBER, ADDRESS_COMPLEMENT, ADDRESS_NEIGHBORHOOD, ADDRESS_CEP, ADDRESS_CITY, ADDRESS_STATE) VALUES (?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, address.getStreet());
            statement.setInt(2, Integer.parseInt(address.getNumber()));
            statement.setString(3, address.getComplement());
            statement.setString(4, address.getNeighborhood());
            statement.setString(5, address.getZipCode());
            statement.setString(6, address.getCity());
            statement.setString(7, address.getState());
            statement.executeUpdate();
        }
        {
            PreparedStatement statement = conn.prepareStatement("SELECT ADDRESS_SEQ.currval FROM dual");
            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
    }

    @Override
    public void update(Address address) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("UPDATE ADDRESS SET ADDRESS_STREET = ?, ADDRESS_NUMBER = ?, ADDRESS_COMPLEMENT = ?, ADDRESS_NEIGHBORHOOD = ?, ADDRESS_CEP = ?, ADDRESS_CITY = ?, ADDRESS_STATE = ? WHERE ADDRESS_ID = ?");
        statement.setString(1, address.getStreet());
        statement.setInt(2, Integer.parseInt(address.getNumber()));
        statement.setString(3, address.getComplement());
        statement.setString(4, address.getNeighborhood());
        statement.setString(5, address.getZipCode());
        statement.setString(6, address.getCity());
        statement.setString(7, address.getState());
        statement.setInt(8, address.getId());
        statement.executeUpdate();
    }

    @Override
    public void remove(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("DELETE FROM ADDRESS WHERE ADDRESS_ID = ?");
        statement.setInt(1, integer);
        statement.executeUpdate();
    }
}
