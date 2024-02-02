package Monster.View;

import Monster.Controller.MonsterController;
import Monster.Model.Dto.EventDto;

import java.util.ArrayList;
import java.util.Scanner;

public class MonsterView {
    private MonsterView(){};
    private static MonsterView monsterView=new MonsterView();
    public static MonsterView getInstance(){return monsterView;}
    Scanner scanner=new Scanner(System.in);

    public static void run(){
        int mno=4;// 회원번호 불러와야함
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
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }

        }

        while (true){
            Scanner scanner=new Scanner(System.in);

            //캐릭터+닉네임+게이지 화면 띄워야함

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

                // 기능 메소드
            }
        }
    }

    public static void main(String[] args) {
        run();
    }



}
