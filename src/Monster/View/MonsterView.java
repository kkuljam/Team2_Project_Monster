package Monster.View;

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

    public static void run(){
        int mno=1;// 회원번호 불러와야함
        boolean result= MonsterController.getInstance().monsterExistence(mno); //몬스터 보유 여부 메소드
       /* if(result){
            result=false;
        }*/
        if(result){
            Scanner scanner=new Scanner(System.in);
            System.out.println("\n" +
                    "\t⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠠⠄⠤⠠⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "\t⠀⠀⠀⠀⠀⠀⠀⠠⠊⠀⠀⠀⠀⠀⠈⠒⠄⠀⠀⠀⠀⠀⠀⠀\n" +
                    "\t⠀⠀⠀⠀⠀⠀⡐⠁⠀⠄⠁⠈⠀⠂⠠⠀⠈⠢⡀⠀⠀⠀⠀⠀\n" +
                    "\t⠀⠀⠀⠀⢀⠊⠀⠀⠂⢀⠈⢀⠁⠐⠀⠄⠁⡀⠰⡀⠀⠀⠀⠀\n" +
                    "\t⠀⠀⠀⢀⠂⠀⠄⠈⠀⠄⠠⠀⠀⠂⠐⠀⠄⢀⠀⠐⡄⠀⠀⠀\n" +
                    "\t⠀⠀⢀⠃⠀⡠⠀⡈⡠⡴⡳⡦⣅⠐⠀⠂⠠⠀⠠⠀⠘⡀⠀⠀\n" +
                    "\t⠀⠀⢼⢔⠯⠙⣠⢞⡕⡯⡺⣎⢞⡽⣲⢤⡂⠀⠂⠐⢀⣣⠀⠀\n" +
                    "\t⠀⢠⠏⣃⡴⣫⢳⠕⠝⠊⠑⠙⢮⣪⢳⡕⣝⢗⢖⡟⣝⢵⡄⠀\n" +
                    "\t⠀⡔⠘⠕⠉⠀⣄⣠⡤⣄⡠⠀⠀⠈⠃⢯⣪⡫⡳⣝⢼⡱⣇⠀\n" +
                    "\t⠀⡟⡦⣲⢺⡫⡳⣕⠞⢼⢍⡟⣖⠀⢀⢀⡀⡙⠪⠊⠈⠀⢰⠀\n" +
                    "\t⠀⣟⢮⢳⠝⠜⠃⠁⠀⢀⠀⠀⠀⡀⠀⠨⢏⣝⢳⢝⢖⢧⡺⠀\n" +
                    "\t⠀⢡⠉⠀⠄⢀⠀⡀⠂⢀⠀⠁⠠⠀⠂⠀⠀⠀⠉⠓⠝⡮⡓⠀\n" +
                    "\t⠀⠐⡂⠀⠂⢀⠀⠠⠀⠄⠀⡁⠀⠂⠈⠀⠁⠐⠀⡀⠀⡰⠁⠀\n" +
                    "\t⠀⠀⠈⠢⡁⠀⠀⠂⢀⠐⠀⡀⠈⢀⠈⣠⣡⡐⡀⢀⠜⠁⠀⠀\n" +
                    "\t⠀⠀⠀⠀⠈⠢⣁⠐⠀⠠⠀⠄⢐⡠⡞⣖⢵⠝⠝⠁⠀⠀⠀⠀\n" +
                    "\t⠀⠀⠀⠀⠀⠀⠀⠉⠑⠒⠂⠒⠋⠚⠙⠈⠁⠀⠀⠀⠀⠀⠀⠀\n");
            System.out.print("몬스터 이름을 생성해주세요.\n->");
            String nickName = scanner.nextLine();
            System.out.println("\t\t"+nickName);
            System.out.println("알을 깨워주세요. \n*enter 5번을 눌러주세요*");
            scanner.nextLine();     System.out.print("1");
            scanner.nextLine();     System.out.print("2");
            scanner.nextLine();     System.out.print("3");
            scanner.nextLine();     System.out.print("4");
            scanner.nextLine();     System.out.print("5");

            // 이름 보내면서 난수 생성하고 그걸로 몬스터 정해주기
            boolean go=MonsterController.getInstance().monsterRandom(nickName,mno);
            if(go){
                System.out.println(nickName+"이(가) 깨어나고 있습니다.");
                try {
                    System.out.println("\n" +
                            "⣿⣦⡫⢿⣻⣆⠱⡀⠱⢘⣧⢺⡗⣽⣿⢰⠃⢠⢡⣾⡟⣧⣿⣿⢯\n" +
                            "⡈⠛⢿⣮⢻⣻⣆⠱⡀⢃⢿⡸⡇⣿⡿⡎⢠⢣⣾⢏⣷⣿⡗⣯⠾\n" +
                            "⢮⡑⢄⠙⢷⣝⢿⣷⣥⠈⣿⡧⣇⣿⣿⢡⣳⣿⢭⣿⢿⡺⢞⡩⠞\n" +
                            "⢦⣍⡳⢌⡢⢝⣷⡿⣿⣧⢸⣿⣳⣿⡧⣿⣿⣽⢿⣟⡫⢕⣩⣴⠿\n" +
                            "⢷⣮⣝⣳⢻⢶⣌⡻⣿⣟⣷⣿⣻⣿⣿⣟⣿⡾⣟⣪⢶⣻⢭⣶⣾\n" +
                            "⡷⣶⣮⣯⣟⣷⣿⣻⣷⣽⣟⣿⣿⣾⣟⣿⣿⢾⣿⣾⣿⣻⣿⣿⣻\n" +
                            "⠖⠞⠞⢟⢟⣯⣿⣿⣿⣽⣿⣿⣽⣾⣿⣯⣿⣿⡿⣷⣿⣷⢷⣶⣶\n" +
                            "⣋⣫⣭⣽⣽⢿⣷⣿⡽⣯⣷⡿⣿⣯⣿⢿⣯⣷⣿⣿⣷⣽⣛⡻⡝\n" +
                            "⢟⣫⣗⡷⣟⡟⢋⣵⣾⣷⣿⢹⣿⣽⡞⣿⣻⣷⣮⡑⠫⢛⠫⢿⣿\n" +
                            "⠟⣩⠵⠊⣡⢶⣿⣟⣾⢟⠆⣿⢿⣸⣷⡈⢏⢷⣿⢿⣷⠤⡈⠀⢄\n" +
                            "⠋⣡⠴⣫⣞⡯⢯⣾⠏⡎⢰⢿⢽⢜⣿⠲⠈⢢⠻⣿⣝⢿⣬⡑⠤\n" +
                            "⠞⣡⡞⣧⢟⣵⣿⠇⡼⠀⡿⣸⢸⡕⣽⣇⢡⠀⢣⠈⢻⣷⣜⠻⣶\n" +
                            "⡾⣣⡿⣋⣾⣿⡎⣼⡃⣸⠇⣇⣻⡇⣺⣿⡀⢣⠀⢳⡀⠹⣿⣷⣜\n");
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }

        }

        while (true){
            Scanner scanner=new Scanner(System.in);
            // 몬스터 정보 출력 메소드로 닉네임, 진화단계, 게이지 불러오기
            MonsterDto monsterDto1=MonsterController.getInstance().monsterPrint(mno);
            // 찾은 진화단계로 진화 이미지 불러오기
            int level=monsterDto1.getLino(); // 진화 단계 저장
            String monIng=MonsterController.getInstance().monsterImg(level);// 진화 이미지 출력 메소드

            // 체력, 스트레스 게이지
            System.out.println(monIng);                     // 몬스터 이미지
            System.out.println(monsterDto1.getNickname());  // 몬스터 이름
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
                // 로그아웃 메소드
            } else if (ch<= eventDtos.size()) {
                String eImg=MonsterController.getInstance().eventExecution(ch,mno);
                System.out.println(eImg);

                // 기능 메소드
            }
        }
    }

    public static void main(String[] args) {
        run();
    }



}
