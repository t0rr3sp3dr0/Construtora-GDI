package systems.singularity.buildware.db;

import systems.singularity.buildware.interfaces.Repository;
import systems.singularity.buildware.models.BankAccount;
import systems.singularity.buildware.models.Provider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public final class ProviderRepository implements Repository<Provider, Integer> {
    ProviderRepository() {
        // Avoid class instantiation
    }

    @Override
    public Provider get(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM PROVIDER WHERE PROVIDER_ID = ?");
        statement.setInt(1, integer);
        ResultSet rs = statement.executeQuery();
        if (!rs.next())
            throw new SQLException("Provider Not Found");

        return new Provider()
                .id(rs.getInt(1))
                .name(rs.getString(2))
                .cnpj(rs.getString(3))
                .bankAccount(new BankAccount().id(rs.getInt(4)))
                .email(rs.getString(5));
    }

    @Override
    public Set<Provider> getAll() throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM PROVIDER");
        ResultSet rs = statement.executeQuery();
        Set<Provider> set = new HashSet<>();
        while (rs.next())
            set.add(
                    new Provider()
                            .id(rs.getInt(1))
                            .name(rs.getString(2))
                            .cnpj(rs.getString(3))
                            .bankAccount(new BankAccount().id(rs.getInt(4)))
                            .email(rs.getString(5))
            );
        return set;
    }

    @Override
    public boolean exists(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT COUNT(*) FROM PROVIDER WHERE PROVIDER_ID = ?");
        statement.setInt(1, integer);
        ResultSet rs = statement.executeQuery();
        rs.next();
        return rs.getInt(1) > 0;
    }

    @Override
    public Integer insert(Provider provider) throws SQLException {
        Connection conn = Database.getConnection();
        {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO PROVIDER (PROVIDER_NAME, PROVIDER_CNPJ, PROVIDER_BANK_ACCOUNT_ID, PROVIDER_EMAIL) VALUES (?, ?, ?, ?)");
            statement.setString(1, provider.getName());
            statement.setString(2, provider.getCNPJ());
            statement.setInt(3, provider.getBankAccount().getId());
            statement.setString(4, provider.getEmail());
            statement.executeUpdate();
        }
        {
            PreparedStatement statement = conn.prepareStatement("SELECT PROVIDER_SEQ.currval FROM dual");
            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
    }

    @Override
    public void update(Provider provider) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("UPDATE PROVIDER SET PROVIDER_NAME = ?, PROVIDER_CNPJ = ?, PROVIDER_BANK_ACCOUNT_ID = ?, PROVIDER_EMAIL = ? WHERE PROVIDER_ID = ?");
        statement.setString(1, provider.getName());
        statement.setString(2, provider.getCNPJ());
        statement.setInt(3, provider.getBankAccount().getId());
        statement.setString(4, provider.getEmail());
        statement.setInt(5, provider.getId());
        statement.executeUpdate();
    }

    @Override
    public void remove(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("DELETE FROM PROVIDER WHERE PROVIDER_ID = ?");
        statement.setInt(1, integer);
        statement.executeUpdate();
    }
}
