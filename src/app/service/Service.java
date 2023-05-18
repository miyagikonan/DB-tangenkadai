package app.service;
import app.dao.Dao;
import app.record.CompanyRecord;
import app.record.UserRecord;
import app.record.UserDisplayRecord;
import app.util.DBUtil;

import java.sql.DriverManager;
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

    public int insert(UserRecord p) {
        try(var connection = DBUtil.getConnection();) {
            var insertDao = new Dao(connection);
            return insertDao.insert(p);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<UserDisplayRecord> findInsertdisplay(int dis){
        try(var connection = DBUtil.getConnection();) {
            var userDao = new Dao(connection);
            return userDao.findInsertdisplay(dis);
        } catch (SQLException e){
            e.printStackTrace();
            return List.of();
        }
    }

    public int delete(int p) {
        try(var connection = DBUtil.getConnection();) {
            var productDao = new Dao(connection);
            return productDao.delete(p);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<UserDisplayRecord> finddeletedisplay(int p){
        try(var connection = DBUtil.getConnection();) {
            var userDao = new Dao(connection);
            return userDao.finddeletedisplay(p);
        } catch (SQLException e){
            e.printStackTrace();
            return List.of();
        }
    }

    public int update(UserRecord p) {
        try(var connection = DBUtil.getConnection();) {
            var productDao = new Dao(connection);
            return productDao.update(p);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
