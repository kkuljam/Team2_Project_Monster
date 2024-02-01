package Monster.View;

import Monster.Controller.AdminController;

import java.util.Scanner;

public class AdminView {
    //싱글톤
    private AdminView(){}
    private static AdminView adminView= new AdminView();

    public static  AdminView getInstance(){return adminView;}

    Scanner scanner =new Scanner(System.in);


    // 0. 관리자 로그인 성공시 출력
    public void AdminRun(){
        while (true){
            System.out.println("==============관리자 모드=============");
            System.out.println("1. 회원관리 2. 육성관리 3. 로그아웃");
            System.out.println("선택>"); int ch= scanner.nextInt();

            if(ch==1){
                System.out.println("회원관리메소드");
                MemberManagement(); //회원관리 메소드
            }
            else if (ch==2) {
                System.out.println("육성관리메소드");
            }
            else if (ch==3) {
                System.out.println("로그아웃 로그인화면으로이동");
                return;
            }

        }


    }
    //회원관리 화면
    public void MemberManagement(){
        System.out.println("===========회원 관리==========");
        //for (int i=0;i< AdminController.)
    }
}
