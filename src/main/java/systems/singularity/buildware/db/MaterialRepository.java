package systems.singularity.buildware.db;

import systems.singularity.buildware.interfaces.Repository;
import systems.singularity.buildware.models.Material;
import systems.singularity.buildware.models.Provider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public final class MaterialRepository implements Repository<Material, Integer> {
    MaterialRepository() {
        // Avoid class instantiation
    }

    @Override
    public Material get(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM MATERIAL WHERE MATERIAL_ID = ?");
        statement.setInt(1, integer);
        ResultSet rs = statement.executeQuery();
        if (!rs.next())
            throw new SQLException("Material Not Found");

        return new Material()
                .id(rs.getInt(1))
                .name(rs.getString(2))
                .manufacturer(rs.getString(3))
                .price(rs.getDouble(4))
                .provider(new Provider().id(rs.getInt(5)));
    }

    @Override
    public Set<Material> getAll() throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM MATERIAL");
        ResultSet rs = statement.executeQuery();
        Set<Material> set = new HashSet<>();
        while (rs.next())
            set.add(
                    new Material()
                            .id(rs.getInt(1))
                            .name(rs.getString(2))
                            .manufacturer(rs.getString(3))
                            .price(rs.getDouble(4))
                            .provider(new Provider().id(rs.getInt(5)))
            );
        return set;
    }

    @Override
    public boolean exists(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT COUNT(*) FROM MATERIAL WHERE MATERIAL_ID = ?");
        statement.setInt(1, integer);
        ResultSet rs = statement.executeQuery();
        rs.next();
        return rs.getInt(1) > 0;
    }

    @Override
    public Integer insert(Material material) throws SQLException {
        Connection conn = Database.getConnection();
        {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO MATERIAL (MATERIAL_NAME, MATERIAL_MANUFACTURER, MATERIAL_PRICE, MATERIAL_PROVIDER_ID) VALUES (?, ?, ?, ?)");
            statement.setString(1, material.getName());
            statement.setString(2, material.getManufacturer());
            statement.setDouble(3, material.getPrice());
            statement.setInt(4, material.getProvider().getId());
            statement.executeUpdate();
        }
        {
            PreparedStatement statement = conn.prepareStatement("SELECT MATERIAL_SEQ.currval FROM dual");
            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
    }

    @Override
    public void update(Material material) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("UPDATE MATERIAL SET MATERIAL_NAME = ?, MATERIAL_MANUFACTURER = ?, MATERIAL_PRICE = ?, MATERIAL_PROVIDER_ID = ? WHERE MATERIAL_ID = ?");
        statement.setString(1, material.getName());
        statement.setString(2, material.getManufacturer());
        statement.setDouble(3, material.getPrice());
        statement.setInt(4, material.getProvider().getId());
        statement.setInt(5, material.getId());
        statement.executeUpdate();
    }

    @Override
    public void remove(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("DELETE FROM MATERIAL WHERE MATERIAL_ID = ?");
        statement.setInt(1, integer);
        statement.executeUpdate();
    }
}
