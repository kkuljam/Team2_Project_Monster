package Monster.View;

import Monster.Controller.MonsterController;

import java.util.Scanner;

public class MonsterView {
    private MonsterView(){};
    private static MonsterView monsterView=new MonsterView();
    public static MonsterView getInstance(){return monsterView;}
    Scanner scanner=new Scanner(System.in);

    public void monsterRandom(String nM){// 몬스터 랜덤 메소드+닉네임 넣어주기


    }

    public void run(){
        //몬스터 보유 여부
        int mno=1;// 회원번호 불러와야함
        boolean result= MonsterController.getInstance().monsterExistence(mno);
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

        }

        while (true){
            System.out.println("");
            //게이지 띄워줄 메소드

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
