package kr.or.ddit.basic;

import javax.swing.JOptionPane;

/**
 * 2020년 9월 22일 수업
 * 멀티 스레드를 활용한 카운트다운 처리
 */

public class T06_ThreadTest {
   // 입력 여부를 확인하기 위한 변수 선언
   // 모든 스레드에서 공통으로 사용할 변수
   public static boolean inputCheck = false;
   
   public static void main(String[] args) {
      Thread th1 = new DataInput();
      Thread th2 = new CountDown();
      
      th1.start();
      th2.start();
   }
}

/**
 * 데이터를 입력받는 스레드
 */
class DataInput extends Thread{
   @Override
   public void run() {
      String str = JOptionPane.showInputDialog("아무거나 입력하세요.");
      System.out.println("입력한 값은 " + str + "입니다.");
      
      // 입력이 완료되면 inputCheck 변수를 true로 변경한다.
      T06_ThreadTest.inputCheck = true;
   }
}

/**
 * 카운트다운 처리를 위한 스레드
 */
class CountDown extends Thread{
   @Override
   public void run() {
      // 카운트다운하는 for문
      for (int i = 10; i >=1; i--) {
         // 입력이 완료되었는지 여부를 검사하고 입력이 완료되면 run() 메서드를 종료시킨다. 즉 현재 스레드가 종료
         if(T06_ThreadTest.inputCheck == true) {
            return; // run() 메서드가 종료되면 스레드도 같이 종료된다.
         }
         System.out.println(i);
         try {
            Thread.sleep(1000); // 1초동안 멈춤
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
      // 10초가 경과되었음에도 입력이 없으면 프로그램을 종료한다.
      System.out.println("10초가 지났습니다. 프로그램을 종료합니다.");
      System.exit(0);
   }
}