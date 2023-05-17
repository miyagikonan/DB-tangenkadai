package app.service;
import app.dao.Dao;
import app.record.CompanyRecord;
import app.record.UserRecord;
import app.record.UserDisplayRecord;
import app.util.DBUtil;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
public class Service {

    //users一覧表示
    public List<UserDisplayRecord> findList(int mode){
        try(var connection = DBUtil.getConnection();) {
            var userDao = new Dao(connection);
            return userDao.findList(mode);
        } catch (SQLException e){
            e.printStackTrace();
            return List.of();
        }
    }

    public List<CompanyRecord> findCompany(int com) {
        try(var connection = DBUtil.getConnection();) {
            var userDao = new Dao(connection);
            return userDao.findCompany(com);
        } catch (SQLException e){
            e.printStackTrace();
            return List.of();
        }
    }
}
