package Monster.View;

import java.util.Scanner;

public class MonsterView {
    private MonsterView(){};
    private static MonsterView monsterView=new MonsterView();
    public static MonsterView getInstance(){return monsterView;}

    Scanner scanner=new Scanner(System.in);
    public void run(){
        //몬스터 보유 여부
        while (true){
            System.out.println("========ezen 게시판============");
            //게이지 띄워줄 메소드
            //알 그림 띄울 메소드
            //기능 선택지 메소드
            System.out.print("선택>");
            int ch=scanner.nextInt();

            if(ch==1){

            } else if (ch==2) {

            } else if (ch==3) {

            }
        }
    }
}
