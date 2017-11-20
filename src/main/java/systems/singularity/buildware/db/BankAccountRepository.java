package systems.singularity.buildware.db;

import systems.singularity.buildware.enums.Bank;
import systems.singularity.buildware.interfaces.Repository;
import systems.singularity.buildware.models.BankAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public final class BankAccountRepository implements Repository<BankAccount, Integer> {
    BankAccountRepository() {
        // Avoid class instantiation
    }

    @Override
    public BankAccount get(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM BANK_ACCOUNT WHERE BANK_ACCOUNT_ID = ?");
        statement.setInt(1, integer);
        ResultSet rs = statement.executeQuery();
        if (!rs.next())
            throw new SQLException("Back Account Not Found");

        return new BankAccount()
                .id(rs.getInt(1))
                .number(rs.getString(2))
                .agency(rs.getString(3))
                .bank(Bank.valueOf("_" + rs.getString(4)));
    }

    @Override
    public Set<BankAccount> getAll() throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM BANK_ACCOUNT");
        ResultSet rs = statement.executeQuery();
        Set<BankAccount> set = new HashSet<>();
        while (rs.next())
            set.add(
                    new BankAccount()
                            .id(rs.getInt(1))
                            .number(rs.getString(2))
                            .agency(rs.getString(3))
                            .bank(Bank.valueOf("_" + rs.getString(4)))
            );
        return set;
    }

    @Override
    public boolean exists(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("SELECT COUNT(*) FROM BANK_ACCOUNT WHERE BANK_ACCOUNT_ID = ?");
        statement.setInt(1, integer);
        ResultSet rs = statement.executeQuery();
        rs.next();
        return rs.getInt(1) > 0;
    }

    @Override
    public Integer insert(BankAccount bankAccount) throws SQLException {
        Connection conn = Database.getConnection();
        {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO BANK_ACCOUNT (BANK_ACCOUNT_NUMBER, BANK_ACCOUNT_AGENCY, BANK_ACCOUNT_BANK) VALUES (?, ?, ?)");
            statement.setString(1, bankAccount.getNumber());
            statement.setString(2, bankAccount.getAgency());
            statement.setString(3, bankAccount.getBank().getId());
            statement.executeUpdate();
        }
        {
            PreparedStatement statement = conn.prepareStatement("SELECT BANK_SEQ.currval FROM dual");
            ResultSet rs = statement.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
    }

    @Override
    public void update(BankAccount bankAccount) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("UPDATE BANK_ACCOUNT SET BANK_ACCOUNT_NUMBER = ?, BANK_ACCOUNT_AGENCY = ?, BANK_ACCOUNT_BANK = ? WHERE BANK_ACCOUNT_ID = ?");
        statement.setString(1, bankAccount.getNumber());
        statement.setString(2, bankAccount.getAgency());
        statement.setString(3, bankAccount.getBank().getId());
        statement.setInt(4, bankAccount.getId());
        statement.executeUpdate();
    }

    @Override
    public void remove(Integer integer) throws SQLException {
        Connection conn = Database.getConnection();
        PreparedStatement statement = conn.prepareStatement("DELETE FROM BANK_ACCOUNT WHERE BANK_ACCOUNT_ID = ?");
        statement.setInt(1, integer);
        statement.executeUpdate();
    }
}
