package Monster.View;

import Monster.Controller.AdminController;
import Monster.Controller.MemberController;
import Monster.Model.Dto.MemberDto;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminView {
    //싱글톤
    private AdminView(){}
    private static AdminView adminView= new AdminView();

    public static  AdminView getInstance(){return adminView;}

     static Scanner scanner =new Scanner(System.in);


    // 0. 관리자 로그인 성공시 출력
    public static void main(String[] args) {
        AdminRun();
    }
    public static void AdminRun(){
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
                MemberController.getInstance().logOut();
                return;
            }

        }


    }
    //회원관리 화면
    public static void MemberManagement(){
        System.out.println("===========회원 관리==========");
        ArrayList<MemberDto> memberDtos = AdminController.getInstance().memberPrint(new MemberDto());
        for (int i=0;i<memberDtos.size();i++){
            System.out.print(memberDtos.get(i).getMno()+"\t");
            System.out.print(memberDtos.get(i).getMid()+"\t");
            System.out.print(memberDtos.get(i).getMpw()+"\t");
            System.out.print(memberDtos.get(i).getMphone()+"\t");
            System.out.println(memberDtos.get(i).getMname());
        }
        System.out.println("회원번호입력:"); int mno=scanner.nextInt();
        for(int i=0; i<memberDtos.size();i++){
            if(mno==memberDtos.get(i).getMno()) {
                System.out.print(memberDtos.get(i).getMno()+"\t");
                System.out.print(memberDtos.get(i).getMid()+"\t");
                System.out.print(memberDtos.get(i).getMpw()+"\t");
                System.out.print(memberDtos.get(i).getMphone()+"\t");
                System.out.println(memberDtos.get(i).getMname());

            }
        // 회원 정보 수정/삭제 선택
            System.out.println("===========회원 관리==========");
            System.out.println("1. 회원 정보 수정 2. 회원 정보 삭제 ");
            System.out.println("선택>"); int ch= scanner.nextInt();
            if(ch==1){// 정보 수정
                System.out.print("아이디:"); String id= scanner.nextLine();
                System.out.print("비밀번호:"); String pw= scanner.nextLine();
                System.out.print("전화번호:"); String phone= scanner.nextLine();
                System.out.print("이름:"); String name= scanner.nextLine();
                MemberDto memberDto=new MemberDto(mno,id,pw,phone,name);


                boolean result = AdminController.getInstance().memberChange(memberDto);

            }
            else if (ch==2) {// 정보 삭제
                System.out.println("삭제");
            }
        }
   }
}
