package systems.singularity.buildware.db;

import systems.singularity.buildware.interfaces.Repository;
import systems.singularity.buildware.models.Building;
import systems.singularity.buildware.models.Unit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public final class UnitRepository implements Repository<Unit, Integer> {
    UnitRepository() {
        // Avoid class instantiation
    }

    @Override
    public Unit get(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM UNIT WHERE UNIT_ID = ?");
        statement.setInt(1, integer);
        ResultSet rs = statement.executeQuery();
        if (!rs.next())
            throw new SQLException("Unit Not Found");

        return new Unit()
                .id(rs.getInt(1))
                .building(new Building().id(rs.getInt(2)))
                .description(rs.getString(3));
    }

    @Override
    public Set<Unit> getAll() throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM UNIT");
        ResultSet rs = statement.executeQuery();
        Set<Unit> set = new HashSet<>();
        while (rs.next())
            set.add(
                    new Unit()
                            .id(rs.getInt(1))
                            .building(new Building().id(rs.getInt(2)))
                            .description(rs.getString(3))
            );
        return set;
    }

    @Override
    public boolean exists(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT COUNT(*) FROM UNIT WHERE UNIT_ID = ?");
        statement.setInt(1, integer);
        ResultSet rs = statement.executeQuery();
        rs.next();
        return rs.getInt(1) > 0;
    }

    @Override
    public Integer insert(Unit unit) throws SQLException {
        Connection conn = Database.getConnection();
        {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO UNIT (UNIT_BUILDING_ID, UNIT_DESCRIPTION) VALUES (?, ?)");
            statement.setInt(1, unit.getBuilding().getId());
            statement.setString(2, unit.getDescription());
            statement.executeUpdate();
        }
        {
            PreparedStatement statement = conn.prepareStatement("SELECT UNIT_SEQ.currval FROM dual");
            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
    }

    @Override
    public void update(Unit unit) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("UPDATE UNIT SET UNIT_BUILDING_ID = ?, UNIT_DESCRIPTION = ? WHERE UNIT_ID = ?");
        statement.setInt(1, unit.getBuilding().getId());
        statement.setString(2, unit.getDescription());
        statement.setInt(3, unit.getId());
        statement.executeUpdate();
    }

    @Override
    public void remove(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("DELETE FROM UNIT WHERE UNIT_ID = ?");
        statement.setInt(1, integer);
        statement.executeUpdate();
    }
}
