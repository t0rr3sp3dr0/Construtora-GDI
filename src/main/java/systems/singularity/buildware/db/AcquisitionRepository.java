package systems.singularity.buildware.db;

import systems.singularity.buildware.interfaces.Repository;
import systems.singularity.buildware.models.Acquisition;
import systems.singularity.buildware.models.Building;
import systems.singularity.buildware.models.Material;
import systems.singularity.buildware.models.Provider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public final class AcquisitionRepository implements Repository<Acquisition, Integer> {
    AcquisitionRepository() {
        // Avoid class instantiation
    }

    @Override
    public Acquisition get(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM ACQUISITION WHERE ACQUISITION_ID = ?");
        statement.setInt(1, integer);
        ResultSet rs = statement.executeQuery();
        if (!rs.next())
            throw new SQLException("Acquisition Not Found");

        return new Acquisition()
                .id(rs.getInt(1))
                .material(new Material().id(rs.getInt(2)))
                .provider(new Provider().id(rs.getInt(3)))
                .building(new Building().id(rs.getInt(4)));
    }

    @Override
    public Set<Acquisition> getAll() throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM ACQUISITION ");
        ResultSet rs = statement.executeQuery();
        Set<Acquisition> set = new HashSet<>();
        while (rs.next())
            set.add(
                    new Acquisition()
                            .id(rs.getInt(1))
                            .material(new Material().id(rs.getInt(2)))
                            .provider(new Provider().id(rs.getInt(3)))
                            .building(new Building().id(rs.getInt(4)))
            );
        return set;
    }

    @Override
    public boolean exists(Integer integer) throws SQLException {        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT COUNT(*) FROM ACQUISITION WHERE ACQUISITION_ID = ?");
        statement.setInt(1, integer);
        ResultSet rs = statement.executeQuery();
        rs.next();
        return rs.getInt(1) > 0;
    }

    @Override
    public Integer insert(Acquisition acquisition) throws SQLException {
        Connection conn = Database.getConnection();
        {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO ACQUISITION (ACQUISITION_MATERIAL_ID, ACQUISITION_PROVIDER_ID, ACQUISITION_BUILDING_ID) VALUES (?, ?, ?)");
            statement.setInt(1, acquisition.getMaterial().getId());
            statement.setInt(2, acquisition.getProvider().getId());
            statement.setInt(3, acquisition.getBuilding().getId());
            statement.executeUpdate();
        }
        {
            PreparedStatement statement = conn.prepareStatement("SELECT ACQUISITION_SEQ.currval FROM dual");
            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
    }

    @Override
    public void update(Acquisition acquisition) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("UPDATE ACQUISITION SET ACQUISITION_MATERIAL_ID = ?, ACQUISITION_PROVIDER_ID = ?, ACQUISITION_BUILDING_ID = ? WHERE ACQUISITION_ID = ?");
        statement.setInt(1, acquisition.getMaterial().getId());
        statement.setInt(2, acquisition.getProvider().getId());
        statement.setInt(3, acquisition.getBuilding().getId());
        statement.setInt(4, acquisition.getId());
        statement.executeUpdate();
    }

    @Override
    public void remove(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("DELETE FROM ACQUISITION WHERE ACQUISITION_ID = ?");
        statement.setInt(1, integer);
        statement.executeUpdate();
    }
}
