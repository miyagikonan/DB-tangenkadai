package app.dao;

import app.record.UserDisplayRecord;
import app.record.UserRecord;
import app.record.UserDisplayRecord;
import app.record.CompanyRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao {
    private Connection connection;

    public Dao(Connection connection) {
        this.connection = connection;
    }

    //users一覧表示
    public List<UserDisplayRecord> findList(int mode){
        final var SQL = "SELECT u.id,c.name AS company_name,u.name AS user_name,u.score FROM users u JOIN companies c ON u.company_id = c.id";
        var UserDisplayRecord = new ArrayList<UserDisplayRecord>();

        try (PreparedStatement stmt = this.connection.prepareStatement(SQL)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                var user = new UserDisplayRecord(rs.getInt("id"), rs.getString("company_name"), rs.getString("user_name"), rs.getInt("score"));
                UserDisplayRecord.add(user);            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return UserDisplayRecord;
    }

    //所属企業
    public List<CompanyRecord> findCompany(int com) {
        final var SQL = "SELECT * FROM companies ORDER BY id";
        var CompanyRecord = new ArrayList<CompanyRecord>();

        try(PreparedStatement stmt = this.connection.prepareStatement(SQL)) {
            ResultSet rs = stmt.executeQuery();

            while ((rs.next())){
                var company = new CompanyRecord(rs.getInt("id"), rs.getString("name"));
                CompanyRecord.add(company);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } ;
        return CompanyRecord;
    }

    //レコードの追加
    public int insert(UserRecord p) {
        final var INSERT_SQL = "INSERT INTO users (name,company_id,score) VALUES ('" + p.name() + "',"  + p.company_id() + ", " + p.score() +  ")";
        int result = 0;
        try (PreparedStatement stmt = connection.prepareStatement(INSERT_SQL);) {
            result = stmt.executeUpdate();
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //追加したレコードの表示
    public List<UserDisplayRecord> findInsertdisplay(int dis) {
        final var SQL = "SELECT u.id,c.name AS company_name,u.name AS user_name,u.score FROM users u JOIN companies c ON u.company_id = c.id ORDER BY u.id DESC LIMIT 1";
        var UserDisplayRecord = new ArrayList<UserDisplayRecord>();

        try(PreparedStatement stmt = this.connection.prepareStatement(SQL)) {
            ResultSet rs = stmt.executeQuery();

            while ((rs.next())){
                var company = new UserDisplayRecord(rs.getInt("id"), rs.getString("company_name"), rs.getString("user_name"), rs.getInt("score"));
                UserDisplayRecord.add(company);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } ;
        return UserDisplayRecord;
    }

    //デリート
    public int delete(int p) {
        final var SQL = "DELETE FROM users WHERE id = " + p;
        int result = 0;
        try (PreparedStatement stmt = connection.prepareStatement(SQL);) {
            result = stmt.executeUpdate();
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    //デリートするレコードを表示
    public List<UserDisplayRecord> finddeletedisplay(int p) {
        final var SQL = "SELECT u.id,c.name AS company_name,u.name AS user_name,u.score FROM users u JOIN companies c ON u.company_id = c.id WHERE u.id =" + p ;
        var UserDisplayRecord = new ArrayList<UserDisplayRecord>();

        try(PreparedStatement stmt = this.connection.prepareStatement(SQL)) {
            ResultSet rs = stmt.executeQuery();

            while ((rs.next())){
                var company = new UserDisplayRecord(rs.getInt("id"), rs.getString("company_name"), rs.getString("user_name"), rs.getInt("score"));
                UserDisplayRecord.add(company);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } ;
        return UserDisplayRecord;
    }

    //アップデート
    public int update(UserRecord p) {
        final var SQL = "UPDATE users SET company_id = " + p.company_id() + ", name = '" + p.name() + "',score = " + p.score() + " WHERE id = " + p.id() ;
        int result = 0;
        try (PreparedStatement stmt = connection.prepareStatement(SQL);) {
            result = stmt.executeUpdate();
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
