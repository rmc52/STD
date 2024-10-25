package jhctpj.view;

import static jhctpj.common.jdbctemplate.close;
import static jhctpj.common.jdbctemplate.commit;
import static jhctpj.common.jdbctemplate.getConnection;
import static jhctpj.common.jdbctemplate.rollback;

import java.sql.Connection;
import java.util.InputMismatchException;
import java.util.Scanner;

import jhctpj.dto.stdnt;
import jhctpj.service.stdservice;




public class stdntview {
	
	
	
	
	
	
	
/*	System.out.println("\n모든학생목록\n");
	
	System.out.println("학생조회");
	-> 정보출력후 1.목록,2.수정,3.삭제
	
	System.out.println("학생추가");
	이름나이성별성적 - 완료후 메인
	*/
	
	private Scanner sc = new Scanner(System.in);
	private stdservice service = new stdservice();
	
	
	
public void mainMenu() {
		
		int input = 0;
		
		do {
			try {
				
				System.out.println("\n모든학생목록\n");
				System.out.println("1.학생조회");
				System.out.println("2.학생추가");
				
				System.out.println("0. 프로그램 종료");
				
				System.out.print("메뉴 선택 : ");
			
				input = sc.nextInt();
				sc.nextLine(); // 버퍼에 남은 개행문자 제거
				
				switch(input) {
				
				case 1: selectstdnt(); break;
				
				case 2: insertstdnt(); break;
				case 3: deleteStdnt(); break;
				
				
				case 0 : System.out.println("\n[프로그램 종료]\n"); break;
				default: System.out.println("\n[메뉴 번호만 입력하세요]\n");
				}
				
				System.out.println("\n-------------------------------------\n");
				
			} catch (InputMismatchException e) {
				
				System.out.println("\n***잘못 입력 하셨습니다***\n");
				
				input = -1; 
				sc.nextLine(); 
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}while(input != 0);
		
	} 
	
	
	


// 등록

private void insertstdnt() throws Exception{
	
	System.out.println("\n=== 1. 학생 등록 ===\n");
	
	System.out.print("이름 : ");
	String stdName = sc.next();
	
	System.out.print("나이 : ");
	String stdAge = sc.next();
	
	System.out.print("성별 : ");
	String stdGender = sc.next();
	
	System.out.print("성적 : ");
	String score = sc.next();
	

	stdnt stdnt = new stdnt();
	
	
	stdnt.setStdName(stdName);
	stdnt.setStdAge(stdAge);
	stdnt.setStdGender(stdGender);
	stdnt.setScore(score);
	
	
	int result = service.insertstdnt(stdnt);
	
	
	if(result > 0) {
		System.out.println("\n" + stdName + " 학생이 등록되었습니다.\n");
	} else {
		System.out.println(" \n 등록 실패 \n ");}
		}





// 조회


private void selectstdnt() throws Exception{
	System.out.println("\n 검색 회원 조회 \n");
	
	
	
	System.out.print("입력 : ");
	String input = sc.nextLine();
	
	stdnt stdnt = service.selectstdnt(input);
	
	if(stdnt == null) {
		System.out.println("검색 결과 없음");
		return;
	}
	
	
		System.out.println(stdnt);
	
	

}

	
	

/// 삭제

private void deleteStdnt() throws Exception{
	System.out.println("\n 삭제 \n");
	
	System.out.print("삭제할 사용자 이름 : ");
	
	
	String input = sc.nextLine();
	
	// 서비스 호출(DELETE) 후 
	// 결과 반환 (삭제된 행의 개수, int) 받기
	int result = service.deleteStdnt(input);
	
	
	
	if(result >0 ) System.out.println("삭제 성공");
	else 		  System.out.println(" 존재하지 않음");

	
}


	
	
	
	
	
	
}
