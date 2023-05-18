package app;

import app.record.UserDisplayRecord;
import app.record.UserRecord;
import app.service.Service;

import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        var Service = new Service();
        var usercompany = Service.findCompany(1);
        usercompany.stream().forEach(System.out::println);


//        var productinsert = new UserRecord(3,1,"CCC",200);
//        var insert = Service.insert(productinsert);
//        System.out.println(insert);

    }
}
