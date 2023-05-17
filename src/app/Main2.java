package app;

import app.record.CompanyRecord;
import app.record.UserRecord;
import app.service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    private static final int MODE_DISPLAY = 1;
    private static final int MODE_NEW = 2;
    private static final int MODE_DELETE = 3;
    private static final int MODE_EXIT = 9;

    public static void main(String[] args) {
//        start();
        System.out.println("------------------------------");
        System.out.println("ユーザー管理システム\n");

        displayMenu();

        while(true) {
            var sc = new Scanner(System.in);
            var input = sc.nextInt();

            if(input == MODE_DISPLAY) {
                displayUserList();
                System.out.println("");
                displayMenu();
            } else if (input == MODE_NEW) {
//                addUser();
                System.out.println("");
                displayMenu();
            } //else if (input == MODE_DELETE) {
//                deleteUser();
//                System.out.println("");
//                displayMenu();
//            } else if (input == MODE_EXIT) {
//                System.out.println("終了します。");
//                break;
//            } else {
//                System.out.println("もう一度入力してください。");
//            }

        }
    }

    //メニュー
    private static void displayMenu() {

        System.out.println("メニューを選択してください。");
        System.out.println("1：一覧表示");
        System.out.println("2：新規追加");
        System.out.println("3：削除");
        System.out.println("9：終了");
    }

    //一覧表
    private static void displayUserList() {
        var Service = new Service();
        var userlist = Service.findList(1);
        userlist.stream().forEach(System.out::println);
    }



//    private static void addUser() {
//        System.out.println("------------------------------");
//        System.out.println("ユーザー追加");
//        System.out.println("所属企業を選択してください。");
//
//        for(var company : companyList) {
//            System.out.println(company.id() + "：" + company.name());
//        }
//        var sc = new Scanner(System.in);
//        var companyId = sc.nextInt();
//
//        System.out.println("");
//        System.out.println("名前を入力してください。");
//
//        var sc2 = new Scanner(System.in);
//        var name = sc2.nextLine();
//
//        System.out.println("");
//        System.out.println("スコアを入力してください。");
//
//        var score = sc.nextInt();
//
//        // 最大のIDを取得する
//        var maxId = userList.stream().mapToInt(UserRecord::id).max().orElse(0);
//
//        var newUser = new UserRecord(maxId + 1, companyId, name, score);
//        userList.add(newUser);
//
//        System.out.println("以下の内容でユーザーが追加されました。");
//        System.out.println("id：" + newUser.id());
//        System.out.println("所属企業ID：" + newUser.company_id());
//        System.out.println("名前：" + newUser.name());
//        System.out.println("スコア：" + newUser.score());
//    }




}