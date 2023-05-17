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



}
