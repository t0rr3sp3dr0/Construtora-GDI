package systems.singularity.buildware.db;

import systems.singularity.buildware.interfaces.Repository;
import systems.singularity.buildware.models.Address;
import systems.singularity.buildware.models.Building;
import systems.singularity.buildware.models.Employee;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public final class BuildingRepository implements Repository<Building, Integer> {
    BuildingRepository() {
        // Avoid class instantiation
    }

    @Override
    public Building get(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM BUILDING WHERE BUILDING_ID = ?");
        statement.setInt(1, integer);
        ResultSet rs = statement.executeQuery();
        if (!rs.next())
            throw new SQLException("Building Not Found");

        return new Building()
                .id(rs.getInt(1))
                .name(rs.getString(2))
                .cei(rs.getString(3))
                .beginDate(rs.getDate(4))
                .endDate(rs.getDate(5))
                .address(new Address().id(rs.getInt(6)))
                .manager(new Employee().id(rs.getInt(7)));
    }

    @Override
    public Set<Building> getAll() throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM BUILDING");
        ResultSet rs = statement.executeQuery();
        Set<Building> set = new HashSet<>();
        while (rs.next())
            set.add(
                    new Building()
                            .id(rs.getInt(1))
                            .name(rs.getString(2))
                            .cei(rs.getString(3))
                            .beginDate(rs.getDate(4))
                            .endDate(rs.getDate(5))
                            .address(new Address().id(rs.getInt(6)))
                            .manager(new Employee().id(rs.getInt(7)))
            );
        return set;
    }

    @Override
    public boolean exists(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT COUNT(*) FROM BUILDING WHERE BUILDING_ID = ?");
        statement.setInt(1, integer);
        ResultSet rs = statement.executeQuery();
        rs.next();
        return rs.getInt(1) > 0;
    }

    @Override
    public Integer insert(Building building) throws SQLException {
        Connection conn = Database.getConnection();
        {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO BUILDING (BUILDING_NAME, BUILDING_CEI, BUILDING_BEGIN, BUILDING_END, BUILDING_ADDRESS_ID, BUILDING_MANAGER_ID) VALUES (?, ?, ?, ?, ?, ?)");
            statement.setString(1, building.getName());
            statement.setString(2, building.getCEI());
            statement.setDate(3, (Date) building.getBeginDate());
            statement.setDate(4, (Date) building.getEndDate());
            statement.setInt(5, building.getAddress().getId());
            statement.setInt(6, building.getManager().getId());
            statement.executeUpdate();
        }
        {
            PreparedStatement statement = conn.prepareStatement("SELECT BUILDING_SEQ.currval FROM dual");
            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
    }

    @Override
    public void update(Building building) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("UPDATE BUILDING SET BUILDING_NAME = ?, BUILDING_CEI = ?, BUILDING_BEGIN = ?, BUILDING_END = ?, BUILDING_ADDRESS_ID = ?, BUILDING_MANAGER_ID = ? WHERE BUILDING_ID = ?");
        statement.setString(1, building.getName());
        statement.setString(2, building.getCEI());
        statement.setDate(3, (Date) building.getBeginDate());
        statement.setDate(4, (Date) building.getEndDate());
        statement.setInt(5, building.getAddress().getId());
        statement.setInt(6, building.getManager().getId());
        statement.setInt(6, building.getId());
        statement.executeUpdate();
    }

    @Override
    public void remove(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("DELETE FROM BUILDING WHERE BUILDING_ID = ?");
        statement.setInt(1, integer);
        statement.executeUpdate();
    }
}
