package systems.singularity.buildware.db;

import systems.singularity.buildware.interfaces.Repository;
import systems.singularity.buildware.models.Customer;
import systems.singularity.buildware.models.Purchase;
import systems.singularity.buildware.models.Unit;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public final class PurchaseRepository implements Repository<Purchase, Integer> {
    PurchaseRepository() {
        // Avoid class instantiation
    }

    @Override
    public Purchase get(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM PURCHASE WHERE PURCHASE_ID = ?");
        statement.setInt(1, integer);
        ResultSet rs = statement.executeQuery();
        if (!rs.next())
            throw new SQLException("Purchase Not Found");

        return new Purchase()
                .id(rs.getInt(1))
                .customer(new Customer().id(rs.getInt(2)))
                .unit(new Unit().id(rs.getInt(3)))
                .date(rs.getDate(4));
    }

    @Override
    public Set<Purchase> getAll() throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM PURCHASE");
        ResultSet rs = statement.executeQuery();
        Set<Purchase> set = new HashSet<>();
        while (rs.next())
            set.add(
                    new Purchase()
                .id(rs.getInt(1))
                .customer(new Customer().id(rs.getInt(2)))
                .unit(new Unit().id(rs.getInt(3)))
                .date(rs.getDate(4))
            );
        return set;
    }

    @Override
    public boolean exists(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT COUNT(*) FROM PURCHASE WHERE PURCHASE_ID = ?");
        statement.setInt(1, integer);
        ResultSet rs = statement.executeQuery();
        rs.next();
        return rs.getInt(1) > 0;
    }

    @Override
    public Integer insert(Purchase purchase) throws SQLException {
        Connection conn = Database.getConnection();
        {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO PURCHASE (PURCHASE_CUSTOMER_ID, PURCHASE_UNIT_ID, PURCHASE_DATE) VALUES (?, ?, ?)");
            statement.setInt(1, purchase.getCustomer().getId());
            statement.setInt(2, purchase.getUnit().getId());
            statement.setDate(3, (Date) purchase.getDate());
            statement.executeUpdate();
        }
        {
            PreparedStatement statement = conn.prepareStatement("SELECT PURCHASE_SEQ.currval FROM dual");
            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
    }

    @Override
    public void update(Purchase purchase) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("UPDATE PURCHASE SET PURCHASE_CUSTOMER_ID = ?, PURCHASE_UNIT_ID = ?, PURCHASE_DATE = ? WHERE PURCHASE_ID = ?");
        statement.setInt(1, purchase.getCustomer().getId());
        statement.setInt(2, purchase.getUnit().getId());
        statement.setDate(3, (Date) purchase.getDate());
        statement.setInt(4, purchase.getId());
        statement.executeUpdate();
    }

    @Override
    public void remove(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("DELETE FROM PURCHASE WHERE PURCHASE_ID = ?");
        statement.setInt(1, integer);
        statement.executeUpdate();
    }
}
