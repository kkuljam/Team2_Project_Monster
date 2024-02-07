package Monster.View;

import Monster.Controller.MonsterController;
import Monster.Model.Dto.MonsterDto;

import java.util.Scanner;


public class MonsterView {

    private MonsterView(){};
    private static MonsterView monsterView=new MonsterView();
    public static MonsterView getInstance(){return monsterView;}

    public void gauge(int state,String m ){// 게이지 찍는 메소드
        int lenght=state % 10 > 4 ? state / 10 + 1 : state / 10; // 반올림 확인
        // 남아있는 게이지
        for (int i = 0; i < lenght; i++) {
            System.out.print(m);
        }
        //없는 칸
        for (int i = 0; i < 10 -lenght; i++) {
            System.out.print("⬛");
        }
    }

    public void monsterCreate(int mno) {
        Scanner scanner=new Scanner(System.in);
        boolean run=true;
        String nickName = "";
        while (run) {
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
            run = MonsterController.getInstance().monstername(nickName); // 컨트롤러에 몬스터 이름 유효성 검사 / 공백 X
            if (run) {
                System.out.println("<안내>몬스터의 이름을 정해주세요");
            }
        }
        System.out.println("\t" + nickName);
        System.out.println("알을 깨워주세요. \n*enter 5번을 눌러주세요*");
        scanner.nextLine();
        System.out.print("1");
        scanner.nextLine();
        System.out.print("2");
        scanner.nextLine();
        System.out.print("3");
        scanner.nextLine();
        System.out.print("4");
        scanner.nextLine();
        System.out.print("5");

        // 이름 보내면서 난수 생성하고 그번호로 몬스터 정해주기
        boolean go = MonsterController.getInstance().monsterRandom(nickName, mno);
        //System.out.println("몬스터 이름"+nickName);
        if (go) {
            System.out.println(nickName + "이(가) 깨어나고 있습니다.");
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
        }
    }

    public void monsterGameImg (int mno) { //선택지를 뺀 몬스터 창
        // 몬스터 정보 출력 메소드로 닉네임, 진화단계, 게이지 불러오기
        MonsterDto monsterDto1 = MonsterController.getInstance().monsterPrint(mno);
        String monster = MonsterController.getInstance().monsterImg(monsterDto1.getLino());
        int hp = monsterDto1.getHp();           // 체력 수치
        int stress = monsterDto1.getStress();   // 스트레스 수치

        System.out.printf("\n%6s ", "체력:");
        gauge(hp, "\uD83D\uDFE5"); // 게이지 찍는 메소드에 정보 보냄

        System.out.printf("\n%5s ", "스트레스:");
        gauge(stress, "\uD83D\uDFEA");

        System.out.println("\n지능:" + monsterDto1.getIq() + " 힘:" + monsterDto1.getStrong()); // 지능 수치, 힘 수치 출력
        System.out.println(monster);                     // 몬스터 이미지
        System.out.println("<<" + monsterDto1.getNickname() + ">>");  // 몬스터 이름
    }

}
