package systems.singularity.buildware.db;

import systems.singularity.buildware.interfaces.Repository;
import systems.singularity.buildware.models.Title;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public final class TitleRepository implements Repository<Title, Integer> {
    TitleRepository() {
        // Avoid class instantiation
    }

    @Override
    public Title get(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM TITLE WHERE TITLE_ID = ?");
        statement.setInt(1, integer);
        ResultSet rs = statement.executeQuery();
        if (!rs.next())
            throw new SQLException("Title Not Found");

        return new Title()
                .id(rs.getInt(1))
                .name(rs.getString(2))
                .salary(rs.getDouble(3));
    }

    @Override
    public Set<Title> getAll() throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM TITLE");
        ResultSet rs = statement.executeQuery();
        Set<Title> set = new HashSet<>();
        while (rs.next())
            set.add(
                    new Title()
                            .id(rs.getInt(1))
                            .name(rs.getString(2))
                            .salary(rs.getDouble(3))
            );
        return set;
    }

    @Override
    public boolean exists(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT COUNT(*) FROM TITLE WHERE TITLE_ID = ?");
        statement.setInt(1, integer);
        ResultSet rs = statement.executeQuery();
        rs.next();
        return rs.getInt(1) > 0;
    }

    @Override
    public Integer insert(Title title) throws SQLException {
        Connection conn = Database.getConnection();
        {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO TITLE (TITLE_NAME, TITLE_SALARY) VALUES (?, ?)");
            statement.setString(1, title.getName());
            statement.setDouble(2, title.getSalary());
            statement.executeUpdate();
        }
        {
            PreparedStatement statement = conn.prepareStatement("SELECT TITLE_SEQ.currval FROM dual");
            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
    }

    @Override
    public void update(Title title) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("UPDATE TITLE SET TITLE_NAME = ?, TITLE_SALARY = ? WHERE TITLE_ID = ?");
        statement.setString(1, title.getName());
        statement.setDouble(2, title.getSalary());
        statement.setInt(3, title.getId());
        statement.executeUpdate();
    }

    @Override
    public void remove(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("DELETE FROM TITLE WHERE TITLE_ID = ?");
        statement.setInt(1, integer);
        statement.executeUpdate();
    }
}
