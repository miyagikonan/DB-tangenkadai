package app;

import app.record.CompanyRecord;
import app.record.UserDisplayRecord;
import app.record.UserRecord;
import app.service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    private static final int MODE_DISPLAY = 1;
    private static final int MODE_NEW = 2;
    private static final int MODE_DELETE = 3;
    private static final int MODE_UPDATE = 4;
    private static final int MODE_EXIT = 9;

    public static void main(String[] args) {
//        start();
        System.out.println("------------------------------");
        System.out.println("ユーザー管理システム\n");

        displayMenu();

        while (true) {
            var sc = new Scanner(System.in);
            var input = sc.nextInt();

            if (input == MODE_DISPLAY) {
                displayUserList();
                System.out.println("");
                displayMenu();
            } else if (input == MODE_NEW) {
                addUser();
                System.out.println("");
                displayMenu();
            } else if (input == MODE_DELETE) {
                deleteUser();
                System.out.println("");
                displayMenu();
            } else if ((input == MODE_UPDATE)){
                updateuser();
                System.out.println("");
                displayMenu();
            } else if (input == MODE_EXIT) {
                System.out.println("終了します。");
                break;
            } else {
                System.out.println("もう一度入力してください。");
            }

        }
    }

    //メニュー
    private static void displayMenu() {

        System.out.println("メニューを選択してください。");
        System.out.println("1：一覧表示");
        System.out.println("2：新規追加");
        System.out.println("3：削除");
        System.out.println("4：更新");
        System.out.println("9：終了");
    }

    //一覧表
    private static void displayUserList() {
        var Service = new Service();
        var userlist = Service.findList(1);
        userlist.stream().forEach(System.out::println);
    }


    //ユーザーの追加
    private static void addUser() {
        System.out.println("------------------------------");
        System.out.println("ユーザー追加");
        System.out.println("所属企業のidを選択してください。");

        //所属企業を選択
        var Service = new Service();
        var usercompany = Service.findCompany(1);
        usercompany.stream().forEach(System.out::println);
        var sc = new Scanner(System.in);
        var companyId = sc.nextInt();

        //名前を入力
        System.out.println("");
        System.out.println("名前を入力してください。");
        var sc2 = new Scanner(System.in);
        var name = sc2.nextLine();

        //スコアを入力
        System.out.println("");
        System.out.println("スコアを入力してください。");
        var score = sc.nextInt();


        var userinsert = new UserRecord(0,companyId, name, score);
        var insert = Service.insert(userinsert);

        //登録内容を表示
        System.out.println("以下の内容でユーザーが追加されました。");
        var userinsertdisplay = Service.findInsertdisplay(1);
        userinsertdisplay.stream().forEach(System.out::println);

    }

    private static void deleteUser() {
        System.out.println("------------------------------");
        System.out.println("ユーザー削除");
        System.out.println("削除するユーザーのIDを入力してください。");

        var sc = new Scanner(System.in);
        var id = sc.nextInt();

        var Service = new Service();

        System.out.println("以下のユーザーを削除しました。");
        var userdeletedisplay = Service.finddeletedisplay(id);
        userdeletedisplay.stream().forEach(System.out::println);

        var userdelte = Service.delete(id);

    }

    private static void updateuser() {
        System.out.println("------------------------------");
        System.out.println("ユーザー更新");
        System.out.println("更新するユーザーのIDを入力してください。");

        var Service = new Service();

        var sc = new Scanner(System.in);
        var id = sc.nextInt();

        System.out.println("");
        System.out.println("名前を入力してください。");
        var sc2 = new Scanner(System.in);
        var name = sc2.nextLine();

        var usercompany = Service.findCompany(1);
        usercompany.stream().forEach(System.out::println);
        var sc3 = new Scanner(System.in);
        var companyId = sc3.nextInt();

        System.out.println("");
        System.out.println("スコアを入力してください。");
        var sc4 = new Scanner(System.in);
        var score = sc4.nextInt();

        var userupdate = new UserRecord(id,companyId,name,score);
        var update = Service.update(userupdate);
        System.out.println(update);

        System.out.println("以下の内容でユーザーが更新されました。");
        var userinsertdisplay = Service.findInsertdisplay(1);
        userinsertdisplay.stream().forEach(System.out::println);
    }

}




