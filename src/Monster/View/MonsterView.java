package Monster.View;

import Monster.Controller.MemberController;
import Monster.Controller.MonsterController;
import Monster.Model.Dto.EventDto;
import Monster.Model.Dto.MonsterDto;

import java.util.ArrayList;
import java.util.Scanner;

public class MonsterView {
    private MonsterView(){};
    private static MonsterView monsterView=new MonsterView();
    public static MonsterView getInstance(){return monsterView;}
    Scanner scanner=new Scanner(System.in);
    public void gauge(int state,String m ){
        for (int i = 0; i < (state % 10 > 4 ? state / 10 + 1 : state / 10); i++) {
            System.out.print(m);
        }
        for (int i = 0; i < 10 - (state % 10 > 4 ? state / 10 + 1 : state / 10); i++) {
            System.out.print("⬛");
        }
    }
    public void run(){
        int mno= MemberController.getInstance().logMno;// 회원번호 불러와야함
        boolean result= MonsterController.getInstance().monsterExistence(mno); //몬스터 보유 여부 메소드
        boolean monname=true;
        String nickName="";
        if(result){
            while (monname) {
                System.out.println("\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠠⡐⠐⠠⢄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠔⠁⠄⠠⠐⠀⠄⠈⠢⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⣔⢏⠂⠁⠀⠄⠐⠀⠐⢈⢜⢜⢦⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⢠⢺⠸⠀⡀⠂⠁⠀⠂⠁⠈⢰⢱⠱⡱⡱⡄⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⢠⠇⠃⢁⠠⡀⡐⠈⠀⡁⢀⠁⠐⡕⡕⡕⡕⢝⡄⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⢀⠃⠀⢐⢰⢸⢸⢸⢑⡁⠀⡀⢀⠁⠈⠪⡊⡎⡎⡺⢀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⢠⠃⠀⡈⡔⡕⡕⡕⢕⢕⡂⠠⠀⠠⠀⠂⠠⠀⠐⠈⠀⠘⡄⠀⠀⠀\n" +
                        "⠀⠀⠀⡆⠐⠀⡀⢎⢎⢎⢪⢪⢢⠃⠀⠐⢀⠐⡈⡄⡔⡅⡄⠁⠐⢸⠀⠀⠀\n" +
                        "⠀⠀⢰⢁⠀⠁⢀⠱⡱⡱⡱⡱⠁⠐⠈⠀⢄⢆⢇⢇⢇⢇⢇⠌⠀⡈⡆⠀⠀\n" +
                        "⠀⢀⢯⢒⠀⠁⡀⢀⠁⠊⡈⠀⠄⠁⡀⠁⡎⡎⡪⡢⡣⡱⡱⠀⠠⠀⢸⠀⠀\n" +
                        "⠀⢰⢕⠕⠀⠁⢀⠀⠄⠂⠀⠐⠀⠄⠀⠂⡕⡕⡕⡕⢕⢕⠁⠠⠐⠀⠄⡇⠀\n" +
                        "⠀⡎⠂⠠⠀⢁⣀⠠⡀⠄⠁⢈⠀⠐⠈⠀⠑⢕⢜⠜⠜⠀⠠⠀⠐⢀⠀⢱⠀\n" +
                        "⠀⡇⠀⠐⢠⢣⢒⢍⢖⢔⠈⠀⡀⢈⠀⡈⠠⠀⠠⠀⠄⠂⠠⠈⠀⠄⠠⢸⠀\n" +
                        "⠀⢃⠀⢁⠸⡘⡜⡜⢜⢜⠬⠀⠠⠀⠠⠀⡀⠂⠐⠀⠠⠐⠀⡀⠁⠠⠀⡸⠀\n" +
                        "⠀⠸⡀⠠⠘⢜⢜⢜⢜⢔⠭⠀⠂⠐⠀⠄⢀⠐⠀⢁⠠⠐⠀⡀⠈⡀⠄⠇⠀\n" +
                        "⠀⠀⢣⠀⠐⠈⠪⠢⡣⠣⠃⢀⠁⡀⠁⠠⠀⠠⡈⡔⡔⡜⡔⡔⡀⢀⡜⠀⠀\n" +
                        "⠀⠀⠀⠣⡀⢁⠀⠂⢀⠐⠀⠄⠀⠄⠈⡀⠄⡕⡜⡜⢜⢜⠜⡜⢠⠜⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠘⠤⡀⢈⠀⠀⠂⡀⠁⡀⠂⠀⢸⢨⢪⢪⢪⢢⢣⠝⠁⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠈⠒⢄⣁⠠⠀⠄⠠⠀⢁⠨⢪⢪⢢⡣⠓⠁⠀⠀⠀⠀⠀⠀\n" +
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠒⠒⠒⠒⠒⠒⠊⠈⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀\n");
                System.out.print("몬스터 이름을 생성해주세요.\n->");
                nickName = scanner.nextLine();
                monname=MonsterController.getInstance().monstername(nickName);
                if(monname){
                    System.out.println("<안내>몬스터의 이름을 정해주세요");
                }
            }
            System.out.println("\t\t"+nickName);
            System.out.println("알을 깨워주세요. \n*enter 5번을 눌러주세요*");
            scanner.nextLine();     System.out.print("1");
            scanner.nextLine();     System.out.print("2");
            scanner.nextLine();     System.out.print("3");
            scanner.nextLine();     System.out.print("4");
            scanner.nextLine();     System.out.print("5");

            // 이름 보내면서 난수 생성하고 그걸로 몬스터 정해주기
            boolean go=MonsterController.getInstance().monsterRandom(nickName,mno);
            System.out.println("몬스터 이름"+nickName);
            if(go){
                System.out.println(nickName+"이(가) 깨어나고 있습니다.");
                try {
                    System.out.print("\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠠⠄⠠⠠⠄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡔⠁⢀⠐⠀⠄⠐⠈⢢⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⣔⠳⠀⠂⠀⠄⠂⠀⠂⢐⢔⠝⣆⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⢀⢎⢖⠁⠂⠈⡀⠄⠂⠁⠈⢰⢱⢱⢱⢱⡀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⢠⠣⠃⠁⠠⡈⣀⠀⠄⠀⠂⠁⠐⡕⢕⢕⢱⠱⡄⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⡁⠀⠄⡜⡜⡜⡜⢬⠀⡈⢀⠈⢀⠈⠪⡪⡪⡪⡚⠄⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⢠⠁⠠⠐⡸⡸⡨⡪⡪⡪⡂⢀⠠⠀⠄⠐⠀⡀⠄⠂⠠⠘⠄⠀⠀⠀\n" +
                            "⠀⠀⠀⣾⢷⡄⠀⡇⡇⡕⡕⡜⡜⠔⢀⠀⠠⠀⡂⡡⡠⡢⡀⠂⢀⢱⠀⠀⠀\n" +
                            "⠀⠀⢰⠻⣟⣿⢦⢑⢕⢕⠕⡕⢅⣮⡿⣧⣔⢜⢜⢜⢜⢜⣼⡮⡀⠀⡆⠀⠀\n" +
                            "⠀⠀⡗⡕⠈⠫⣿⢷⣁⠑⢁⣖⣿⠓⠛⡿⣾⢷⣕⡕⣕⣽⡾⣟⣷⡄⢸⠀⠀\n" +
                            "⠀⢰⢕⠕⠀⠂⠈⠛⡿⣶⣻⡯⠃⠀⠄⠈⡝⢿⢽⣟⣾⣳⠃⠉⠫⠿⣶⡆⠀\n" +
                            "⠀⡘⠠⠀⠂⢐⢀⢄⠈⠹⠋⠀⡀⠂⢀⠁⠸⢸⢩⠫⠿⠅⠀⠄⠂⠀⡈⢡⠀\n" +
                            "⠀⡇⠀⠐⢠⠣⡣⢣⠣⢥⠐⠀⠠⠐⠀⠀⠂⢀⠀⠄⠂⠐⠀⠄⠂⠠⠀⢸⠀\n" +
                            "⠀⢂⠀⡁⢸⢸⢸⢸⢸⢑⢕⠀⠂⠀⠂⠁⠈⠀⡀⠄⠐⠀⠂⠠⠐⠀⠐⡈⠀\n" +
                            "⠀⠘⡀⠀⡘⢜⢌⢎⢪⠪⡪⠀⡀⠁⠄⠁⢈⠀⡀⠠⠐⠀⠁⠠⠀⠂⢁⠃⠀\n" +
                            "⠀⠀⢡⠀⠄⠈⠪⠪⡪⠪⠊⠀⡀⠐⢀⠈⠀⡀⡠⡰⡢⡣⡣⡢⠐⠀⡜⠀⠀\n" +
                            "⠀⠀⠀⠡⡐⠈⠀⠄⠀⠂⡀⠁⡀⠐⠀⡀⢁⢔⢕⢕⢱⢑⢕⢕⢁⠎⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠈⠢⡀⠂⠁⠠⠀⠄⠠⠀⠁⡀⢸⢨⢢⢣⢣⠣⡣⠕⠁⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠈⠢⢌⡀⠄⠂⠀⠂⠁⠀⡐⢕⢕⢕⠕⠓⠁⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠑⠚⠐⠐⠁⠒⠈⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n");
                    Thread.sleep(1000);
                    System.out.println("\n" +
                            "⣿⣿⣿⣮⡊⡪⡻⣿⣿⣿⣿⣿⣿⣷⡄⠀⠙⣿⣧⠀⠠⠀⢻⣧⠀⠨⣿⣿⣗⠕⡍⣿⣿⣿⡯⡊⡾⣿⣿⣿⣿⠇⢀⣿⡿⠀⠠⠀⢠⡟⠀⢠⣾⣿⣿⣿⣿⣿⡟⢇⣷⣿⣿⣿⣿⣿⣿⣿\n" +
                            "⣷⣿⣷⡿⣿⣬⢊⢎⢿⣿⢿⣾⣿⣽⣷⡌⠀⡈⢿⡆⠐⠈⠀⢿⡂⢀⢹⣿⣿⡸⡨⣻⣿⣿⡇⡇⡿⣿⣷⡿⣿⠐⣼⣿⠅⠀⠂⢈⡜⡀⢄⣿⣿⣿⣿⣟⡷⢏⣪⣾⣿⣿⣿⣿⣟⣷⣿⡷\n" +
                            "⠿⣿⣾⣿⣿⣿⣷⣕⠔⡝⣿⣿⣾⣿⡿⣿⡄⢀⠈⢿⡄⠈⡀⠈⢷⡀⠐⣿⣿⣧⢊⢮⣿⣿⢕⠜⣾⣿⣷⣿⣟⢰⣿⡏⠀⡈⠠⡺⠁⢠⣾⣿⣿⡿⣿⢟⢍⣾⣾⣿⣿⢿⣿⢿⣿⡟⡇⣇\n" +
                            "⠀⢈⠙⢿⣿⣷⡿⣯⣷⡜⢔⠻⣿⣿⡿⣿⣿⣆⠠⠘⢷⡀⠐⠈⠈⣧⠀⣻⣿⣿⡢⢣⣿⣿⢸⢨⣿⣿⣿⣿⣗⣿⡿⠀⠄⢀⡾⠁⣰⣿⣿⣻⣾⡿⡫⣪⣾⣿⣿⣿⣾⣿⡿⡿⡙⣬⣾⣿\n" +
                            "⣷⣄⠠⠀⡈⠳⣿⣿⣿⣿⣧⣣⢙⢿⣿⣿⣷⣿⣧⡀⠘⣧⢀⠁⠄⢚⣆⢸⣿⣿⡧⡑⣯⣿⢰⢱⣿⣿⣿⣿⣷⣿⠇⠀⢂⣼⠃⣴⣿⣿⣯⣿⠯⡣⣾⣿⣿⣿⣿⣷⣿⢗⡫⣶⣿⣿⡿⠟\n" +
                            "⠈⠙⠷⣆⡀⠄⠀⠛⢿⣯⣿⣿⣮⡢⡛⣿⣿⣿⡿⣿⣄⠘⣧⠀⠄⠀⢻⡔⣿⣟⣿⡌⣿⣿⢨⣺⣿⣯⣷⣿⣟⡿⠀⢁⣼⠇⣼⣿⣾⢿⣿⢫⣱⣿⣿⣷⡿⣷⣿⢟⣕⣷⣿⣿⠯⠃⢁⣴\n" +
                            "⣷⣦⣄⠈⠙⠶⣡⠐⠀⠙⢻⣾⣿⣿⣮⡎⢿⣿⣿⣿⣿⣦⡹⣧⠀⡁⠈⣿⣾⣿⣿⡧⣻⡯⡢⣿⣿⣯⣿⣯⣿⠃⡀⣾⢏⣾⣿⣿⣾⡿⣱⣵⣿⣿⣿⣷⣿⢟⣵⣿⣿⠿⠋⢁⣄⣮⣿⠟\n" +
                            "⠛⠿⣿⣷⣥⡠⠈⠙⠦⣌⠀⠉⢿⣿⣽⣿⣧⡝⣿⣿⣿⣿⣷⣿⣧⠀⠐⢸⣿⣿⣿⣿⣼⡯⣪⣿⣿⣿⣿⣿⡟⢀⣾⡿⣿⣿⣿⣿⢏⣾⣟⣿⣟⣿⣿⣯⣷⣿⣿⠛⢈⣠⣾⡾⠟⠋⢁⢀\n" +
                            "⣦⣀⠂⠙⠻⢿⣷⣦⣀⠈⡙⢶⣀⠙⢯⣿⣾⣿⣷⣻⣿⣿⣿⣽⣿⣧⠁⠀⢿⣿⣿⣿⣷⣏⣺⣽⣿⣿⣿⣿⢃⣾⣟⣿⣟⣿⡿⣵⣿⣿⣿⣻⣟⣿⣾⣿⠟⢋⣠⣶⠿⠛⠁⢂⣨⣴⣾⣿\n" +
                            "⢿⣿⣿⣶⣤⣠⠈⠛⢿⣷⣤⡀⠈⠛⢦⣝⣿⣿⣻⣯⣿⣿⣽⣿⣿⣿⣷⡁⠸⣿⣟⣯⣿⣇⣿⣿⣿⣽⡿⣏⣼⣿⣿⣿⣿⣯⣿⡿⣿⢿⣿⣿⣿⡿⢫⣡⣶⠿⠛⠈⣀⣥⣾⣿⣾⢿⣻⡿\n" +
                            "⡕⡍⢞⢛⠿⣿⣿⣶⣦⣌⡙⢿⣷⣬⡀⠉⠻⢿⣿⣻⣽⣾⣿⣿⣿⣿⣿⣷⡌⣻⣿⢿⣿⣷⣿⣿⣿⣽⣿⣟⣿⣿⣿⣿⣿⣿⣽⣿⡿⣿⣿⢟⣭⣶⠿⠋⡈⣄⣶⣿⣿⣿⣿⠷⠛⠋⢁⢄\n" +
                            "⣿⣿⣾⣬⣪⡊⡎⣛⠻⡿⣿⣷⣾⣽⣿⣷⣦⣀⠙⠻⣿⣿⣿⣻⣿⣟⣿⣿⣿⣜⣿⣿⣿⣯⣿⡿⣿⣿⣷⣿⣿⡿⣿⣻⣿⣻⣿⣾⣿⣿⣵⠿⢋⣡⣦⣷⣿⣿⡿⠟⡋⣉⣤⣴⣵⣿⣿⣿\n" +
                            "⠻⠿⢿⢿⣿⡿⣿⣶⣧⣕⣕⢝⠻⠿⣯⣿⣟⣿⣿⣦⣌⠹⢿⣟⣷⣿⡿⣿⣿⣿⣿⣿⣷⣿⣟⣿⣿⣿⣿⣿⣿⡿⣿⣟⣿⣿⣿⣿⢟⣏⣴⣾⡿⣟⡿⢟⣫⣥⣶⣷⣿⣿⣷⣿⣿⣿⣿⣿\n" +
                            "⣷⣯⣮⣎⣆⣫⠫⡫⡻⠿⣿⣿⣿⣷⣮⣮⣻⡻⣿⣿⣿⣿⣶⣭⡻⣿⣿⣿⣿⣿⣿⣿⣿⣾⣿⣟⣿⣿⢿⣿⡿⣿⣿⣿⣯⣿⣫⣶⣿⣿⣿⣯⣯⣷⣿⣿⣿⣿⣿⣿⣿⣾⣿⣾⣿⣿⣿⣿\n" +
                            "⣯⣿⣯⣿⣿⣿⣿⣿⣾⣷⣷⣮⣽⣽⣻⣿⣿⣿⣷⣿⣯⣿⢿⣿⣿⣾⣿⣾⣷⣿⣾⢿⣿⣿⣿⣿⣿⣻⣿⣻⣿⣿⣿⣿⣿⣿⣻⣿⣻⣽⣿⣿⣿⣿⣿⣯⣿⣯⣿⣿⣿⣿⣿⣿⣯⣿⣯⣿\n" +
                            "⠽⠻⠽⡿⣾⣿⣿⣿⣿⣿⣾⣿⣯⣿⣿⣿⣿⣿⣿⣽⣾⣿⣿⣿⣿⣿⣿⣿⢷⣿⣟⣿⣿⣿⣿⣿⣟⣿⣻⣿⣽⣿⣿⣿⣿⣟⣿⣽⣿⣿⣿⣿⣿⣿⣿⣽⣷⣿⣯⣿⣿⡿⡿⡷⢿⢻⠾⡻\n" +
                            "⣶⣷⣷⣾⣶⣾⣾⣿⣻⣿⣿⣿⣿⣿⣽⣿⣽⣟⣿⣿⣿⣿⣿⣽⣿⣽⣿⣾⣿⣿⣿⣿⣿⣽⣾⡿⣿⣿⣿⣿⣿⣿⣽⣿⣾⣿⣿⣿⣿⣿⣾⡿⣯⣿⣻⣽⣽⣭⣵⣕⣦⣧⣵⣱⣕⣥⣧⣵\n" +
                            "⠛⠛⠛⠛⠋⠋⠋⠋⠋⠋⡋⢋⢋⣋⣋⣫⣫⣯⣿⣿⣿⣿⣿⣯⣿⣽⣾⣿⣿⣿⣿⣿⣯⣿⣯⣿⣿⣿⣿⣿⣿⣷⣿⣷⡿⣿⣿⣿⣿⣿⣯⣿⣿⣟⣿⣿⣿⣿⣿⣿⣟⣷⣿⣿⣿⣿⣿⣿\n" +
                            "⣴⣬⣦⣶⣶⣷⣷⣷⣿⣿⡾⡿⡿⣿⣿⣿⣿⣿⣟⣿⣟⣿⣻⣿⣿⣿⣿⣿⣻⣿⢿⣻⣿⣿⣿⣿⣟⣿⣟⣿⣟⣿⣾⣿⣿⣿⣟⣿⣟⣿⣿⣿⣿⣿⣿⢿⡿⣿⣻⣿⣿⣿⣿⣯⣿⡿⣿⣿\n" +
                            "⠟⠛⠋⠋⠉⣉⣈⣌⣤⣴⣶⣿⡿⣿⣿⣿⣿⣿⣿⣻⣿⣻⣿⣿⣿⠿⣫⡷⣟⣿⣿⣿⣿⣿⣿⣿⣟⣿⣽⣿⣻⣿⣿⣿⣿⣿⣻⣽⣿⣻⣿⣿⣿⣿⣿⣻⣽⣽⣝⣛⡛⡟⢟⢟⢯⢿⢿⣷\n" +
                            "⣦⣶⣶⣿⣿⣿⢿⣿⣿⣿⣿⣷⠿⣟⣟⣿⡿⣟⣿⣿⣿⡿⠟⢋⣥⣾⣿⣿⣿⣿⣷⣟⣿⢿⣿⣻⣿⣿⣿⣿⣿⢿⣿⣿⡿⣿⣟⢿⣿⣿⢿⣟⣿⣟⣿⣿⣿⣯⣿⣿⣿⣾⣾⣼⣴⣅⣣⢢\n" +
                            "⣿⣿⣿⣿⣿⠿⡟⢟⣪⣫⣮⣾⣿⣿⡿⣟⣿⣿⡿⠟⠃⣡⣾⣿⣻⣿⣽⣿⣿⣿⡿⢸⣾⣿⣿⣻⣿⣿⣎⢿⣿⣿⢿⣾⣿⣿⣿⣷⣦⣍⠛⠿⣟⣿⡻⠿⡿⣿⣿⣿⣾⣿⣽⣿⣿⣿⣿⣿\n" +
                            "⢟⢟⢝⣱⣡⣧⣷⣿⣟⣿⣿⡿⣟⣯⣿⠿⠛⢁⢀⣦⣿⣿⣿⣯⣿⣯⣿⣿⣿⣿⠁⣿⣿⣻⣾⣿⣿⣿⣿⡌⢻⣿⣿⣿⣾⣿⣿⣿⣿⣿⣷⣦⣀⠈⠛⠻⢦⣌⡈⠙⠚⠟⡷⣿⣿⣿⣿⣿\n" +
                            "⣖⣷⣿⣽⣿⣿⣿⠿⠛⣋⣥⣾⠯⠋⠅⢈⣤⣾⣿⢿⣟⣯⣿⣿⣿⣿⣿⣿⣾⠃⢨⣿⣿⣿⣿⣗⣿⣾⡿⣷⡀⠹⣿⣿⣿⣿⡾⣿⣽⣿⣿⣿⣿⣷⣦⡐⠀⠈⠙⠲⢅⡄⠠⠈⠉⠚⠿⣽\n" +
                            "⣿⣿⡽⠿⠙⢉⢠⣦⣿⠟⠋⠐⢀⢡⣴⣿⣿⣿⢿⣿⢿⣿⣻⣿⣿⣿⡟⣾⠗⠈⣺⣿⣿⣿⣿⡧⣻⣷⣿⣿⣗⡀⠘⢿⣮⢻⣿⡿⣯⣷⣿⣿⣿⣿⣿⣟⢷⣬⡀⠂⢀⠈⠑⠪⠤⣁⢀⠀\n" +
                            "⠛⠁⡈⣤⣶⡿⠟⠋⠀⠄⣁⣬⣾⢿⣫⣿⣯⣿⣿⣿⢿⣵⣿⣿⣻⠏⣼⡟⠀⢌⣿⣿⣿⣻⡿⣏⢺⣿⣿⣿⡿⣆⠐⠈⢻⣧⠙⣿⣿⣿⣿⣟⣿⣟⣿⣿⣷⣍⡛⠮⣤⡀⢈⠀⠄⢈⠑⠷\n" +
                            "⣴⣾⡿⠟⠍⠀⠂⢁⡴⣼⡿⢫⣱⣿⣟⣯⣿⣯⡿⣫⣾⣿⣿⣿⠋⣸⡿⠀⠂⣼⣿⣿⣟⢞⣿⡿⡐⣿⣿⣿⣗⢻⡆⠁⡀⠻⣷⡀⠻⣿⣿⣽⣿⣮⡻⣿⣿⣿⣷⣦⡀⠙⠳⢤⣐⠀⠠⠐\n" +
                            "⡟⠋⢀⠁⠠⣨⣶⣿⠟⢉⣴⡿⣿⡻⣵⣿⣿⢣⣳⣿⢿⣿⢿⠃⢠⣿⠃⢀⢡⣿⡿⣿⡿⣸⣿⣿⢨⢺⢿⣻⣿⡄⢻⡄⠠⠀⠙⣷⡀⠈⢻⣿⣾⣿⣿⣶⣙⠿⣿⣿⣿⣶⣀⠄⠉⠓⢶⣄\n" +
                            "⠀⢐⢠⣶⣿⠿⠋⢀⣴⣿⣿⢻⣱⣿⣿⢟⢌⣾⣯⣿⡿⣿⠡⠠⣿⠗⠀⠄⣺⣿⡣⣿⡏⢮⣿⣿⢰⢑⣿⣿⢿⣧⠈⢻⡀⠄⠁⠘⢿⡄⠠⠘⢿⣿⣿⣟⣷⣧⡣⢻⢿⣿⣿⣾⣄⡈⢀⠨\n" +
                            "⣴⣿⡿⡛⠈⡠⣼⣿⣿⢻⢨⣾⣯⡿⡑⣥⣿⣿⣿⣯⡿⢁⢀⣾⡟⡀⢁⢰⣿⡿⢸⣿⢝⢸⣿⣿⢸⠰⣹⣿⣿⣿⡂⠈⢷⠀⡈⠠⠈⢿⣆⠠⠀⠹⢿⣿⣿⣯⣿⣦⢃⡛⢿⣿⣿⣿⣦⣄\n" +
                            "⡿⠋⠂⣠⣾⡿⣿⢫⢢⣷⣿⣿⠫⣂⣷⡿⣿⣽⣿⡿⠁⠄⣺⡿⠁⡀⠠⣺⣿⡏⢸⣿⢸⠰⣿⣿⢸⢘⢜⣿⣿⣟⣧⠐⠈⢧⢀⠐⠀⡈⢻⣆⠐⠀⠌⠻⣿⣿⣿⣿⣷⣕⠕⡜⠽⣿⣿⣿\n" +
                            "⢀⣴⢿⣿⣿⢫⢱⢼⣾⣿⠟⡜⣸⣾⣻⣿⣟⣿⡿⠁⢂⣼⣿⡏⠀⠄⣸⣿⡿⠀⣺⣿⢘⢜⣿⣻⡅⡇⢆⢿⣿⣟⣿⡄⠐⠈⣧⠀⠂⡀⠈⢻⣧⠐⠀⠄⠘⢿⣿⣷⣿⣿⣷⣕⠕⡜⡹⢿\n" +
                            "⣿⣾⣿⠻⣐⣵⣿⣿⡿⢣⢃⣷⢿⣻⣿⣿⣿⣿⠃⢁⣴⣿⣟⠀⡀⢢⣿⣿⡫⠀⢾⣗⢕⢱⣿⣿⡇⡎⡪⣹⣿⣿⣿⣿⠀⠐⠘⣧⡁⢀⠈⠈⢿⣷⡁⡀⠂⡀⠻⣿⣿⣿⣿⣿⢷⣕⠜⡌\n" +
                            "⣿⢟⠜⣜⣾⣿⣿⠟⡜⣸⣾⣿⣿⣿⣿⣿⣿⡗⢀⣾⣟⣯⠇⢀⠀⣾⣿⣿⠂⠠⣿⣗⢅⢳⣿⣿⡧⡣⡱⡸⣿⣿⣿⣿⣧⠈⠀⢽⣷⡀⢀⠁⡈⣿⣿⣄⠄⠠⠀⠚⣿⣿⣿⣿⢿⣿⣷⣕\n");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }else {
                System.out.println("몬스터의 이름을 정해주세요");
            }

        }

        while (true){

            // 몬스터 정보 출력 메소드로 닉네임, 진화단계, 게이지 불러오기
            MonsterDto monsterDto1=MonsterController.getInstance().monsterPrint(mno);
            // 찾은 진화단계로 진화 이미지 불러오기
            int level=monsterDto1.getLino(); // 진화 단계 저장
            String monIng=MonsterController.getInstance().monsterImg(level);// 진화 이미지 출력 메소드

            // 체력, 스트레스 게이지
            int hp=monsterDto1.getHp();
            int stress=monsterDto1.getStress();
            System.out.printf("\n%6s ","체력:");
            gauge(hp,"\uD83D\uDFE5");
            System.out.printf("\n%5s ","스트레스:");
            gauge(stress,"\uD83D\uDFEA");
            System.out.println("\n지능:"+monsterDto1.getIq()+" 힘:"+monsterDto1.getStrong());
            System.out.println(monIng);                     // 몬스터 이미지
            System.out.println("<<"+monsterDto1.getNickname()+">>");  // 몬스터 이름

            // 지능, 힘 숫자

            System.out.println("0. 로그아웃");

            //이벤트 선택지 출력할 메소드
            ArrayList<EventDto>eventDtos=MonsterController.getInstance().eventPrint(new EventDto());
            for(int i=0; i< eventDtos.size();i++){
                System.out.print(eventDtos.get(i).getEno()+"."+eventDtos.get(i).getEname()+"\t");
            }

            System.out.print("\n선택>");
            int ch=scanner.nextInt();

            if(ch==0){
                MemberController.getInstance().logOut(); //로그아웃
                MainView.getInstance().mainView(); // 메인으로 보내기
            } else if (ch<= eventDtos.size()) {
                String eImg=MonsterController.getInstance().eventExecution(ch,mno); // 이벤트 이미지
                System.out.println(eImg);
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    System.out.println(e);
                }

                // 기능 메소드
            }
        }
    }

}
