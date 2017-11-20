package systems.singularity.buildware.db;

import systems.singularity.buildware.interfaces.Repository;
import systems.singularity.buildware.models.Bonus;
import systems.singularity.buildware.models.Purchase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public final class BonusRepository implements Repository<Bonus, Integer> {
    BonusRepository() {
        // Avoid class instantiation
    }

    @Override
    public Bonus get(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM BONUS WHERE BONUS_ID = ?");
        statement.setInt(1, integer);
        ResultSet rs = statement.executeQuery();
        if (!rs.next())
            throw new SQLException("Bonus Not Found");

        return new Bonus()
                .id(rs.getInt(1))
                .description(rs.getString(2))
                .purchase(new Purchase().id(rs.getInt(3)));
    }

    @Override
    public Set<Bonus> getAll() throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM BONUS");
        ResultSet rs = statement.executeQuery();
        Set<Bonus> set = new HashSet<>();
        while (rs.next())
            set.add(
                    new Bonus()
                            .id(rs.getInt(1))
                            .description(rs.getString(2))
                            .purchase(new Purchase().id(rs.getInt(3)))
            );
        return set;
    }

    @Override
    public boolean exists(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT COUNT(*) FROM BONUS WHERE BONUS_ID = ?");
        statement.setInt(1, integer);
        ResultSet rs = statement.executeQuery();
        rs.next();
        return rs.getInt(1) > 0;
    }

    @Override
    public Integer insert(Bonus bonus) throws SQLException {
        Connection conn = Database.getConnection();
        {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO BONUS (BONUS_DESCRIPTION, BONUS_PURCHASE_ID) VALUES (?, ?)");
            statement.setString(1, bonus.getDescription());
            statement.setInt(2, bonus.getPurchase().getId());
            statement.executeUpdate();
        }
        {
            PreparedStatement statement = conn.prepareStatement("SELECT BONUS_SEQ.currval FROM dual");
            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
    }

    @Override
    public void update(Bonus bonus) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("UPDATE BONUS SET BONUS_DESCRIPTION = ?, BONUS_PURCHASE_ID = ? WHERE BONUS_ID = ?");
        statement.setString(1, bonus.getDescription());
        statement.setInt(2, bonus.getPurchase().getId());
        statement.setInt(3, bonus.getId());
        statement.executeUpdate();
    }

    @Override
    public void remove(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("DELETE FROM BONUS WHERE BONUS_ID = ?");
        statement.setInt(1, integer);
        statement.executeUpdate();
    }
}
