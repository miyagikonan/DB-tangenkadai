package app;

import app.record.CompanyRecord;
import app.record.UserRecord;
import app.service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final int MODE_DISPLAY = 1;
    private static final int MODE_NEW = 2;
    private static final int MODE_DELETE = 3;
    private static final int MODE_EXIT = 9;

    private static List<UserRecord> userList;
    private static List<CompanyRecord> companyList;

    public static void main(String[] args) {

        start();

        while(true) {
            var sc = new Scanner(System.in);
            var input = sc.nextInt();

            if(input == MODE_DISPLAY) {
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
            } else if (input == MODE_EXIT) {
                System.out.println("終了します。");
                break;
            } else {
                System.out.println("もう一度入力してください。");
            }

        }
    }

    private static void displayMenu() {

        System.out.println("メニューを選択してください。");
        System.out.println("1：一覧表示");
        System.out.println("2：新規追加");
        System.out.println("3：削除");
        System.out.println("9：終了");
    }

    // 初期化と初期表示
    private static void start() {

        // 会社情報初期化
        companyList = new ArrayList<>();
        companyList.add(new CompanyRecord(1, "株式会社A"));
        companyList.add(new CompanyRecord(2, "株式会社B"));

        // ユーザー情報初期化
        userList = new ArrayList<>();
        userList.add( new UserRecord(1, 1, "AAA", 80));
        userList.add( new UserRecord(2, 2, "BBB", 70));

        System.out.println("------------------------------");
        System.out.println("ユーザー管理システム\n");

        displayMenu();
    }

    private static void displayUserList() {
        for(var user : userList) {
            System.out.println(user);
        }
    }

    private static void addUser() {
        System.out.println("------------------------------");
        System.out.println("ユーザー追加");
        System.out.println("所属企業を選択してください。");

        for(var company : companyList) {
            System.out.println(company.id() + "：" + company.name());
        }
        var sc = new Scanner(System.in);
        var companyId = sc.nextInt();

        System.out.println("");
        System.out.println("名前を入力してください。");

        var sc2 = new Scanner(System.in);
        var name = sc2.nextLine();

        System.out.println("");
        System.out.println("スコアを入力してください。");

        var score = sc.nextInt();

        // 最大のIDを取得する
        var maxId = userList.stream().mapToInt(UserRecord::id).max().orElse(0);

        var newUser = new UserRecord(maxId + 1, companyId, name, score);
        userList.add(newUser);

        System.out.println("以下の内容でユーザーが追加されました。");
        System.out.println("id：" + newUser.id());
        System.out.println("所属企業ID：" + newUser.company_id());
        System.out.println("名前：" + newUser.name());
        System.out.println("スコア：" + newUser.score());
    }

    private static void deleteUser() {
        System.out.println("------------------------------");
        System.out.println("ユーザー削除");
        System.out.println("削除するユーザーのIDを入力してください。");

        var sc = new Scanner(System.in);
        var id = sc.nextInt();

        var targetUser = userList.stream().filter(user -> user.id() == id).findFirst().get();
        userList.remove(targetUser);

        System.out.println("以下のユーザーを削除しました。");
        System.out.println("id：" + targetUser.id());
        System.out.println("所属企業id：" + targetUser.company_id());
        System.out.println("名前：" + targetUser.name());
        System.out.println("スコア：" + targetUser.score());

    }
}