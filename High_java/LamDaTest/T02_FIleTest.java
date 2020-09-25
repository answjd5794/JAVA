package kr.or.ddit.basic;

import java.awt.DisplayMode;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class T02_FIleTest {
	public static void main(String[] args) {
		File f1 = new File("d:/D_other/sample.txt");
		File f2 = new File("d:/D_other/sample.txt");

		if (f1.exists()) {
			System.out.println(f1.getAbsolutePath() + "은 존재합니다.");
		} else {
			System.out.println(f1.getAbsolutePath() + " 은 없는 파일입니다.");
		}

		try {
			if (f1.createNewFile()) {
				System.out.println(f1.getAbsolutePath() + "파일을 새로 만들었습니다.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (f2.exists()) {
			System.out.println(f2.getAbsolutePath() + "는 존재합니다.");
		} else {
			System.out.println(f2.getAbsolutePath() + "는 없는 파일입니다.");
		}
		System.out.println("==============================================");

		File f3 = new File("d:/D_other");
		File[] files = f3.listFiles();
		for (File file : files) {
			System.out.println(file.getName() + " =>");

			if (file.isFile()) {
				System.out.println("파일!");
			} else if (file.isDirectory()) {
				System.out.println("디렉토리");
			}
		}
		System.out.println("==================================================");
		String[] strFiles = f3.list();
		for (String file : strFiles) {
			System.out.println(file);
		}
		System.out.println("==================================================");
		System.out.println();

		// =================================================

		// 출력할 디렉토리 정보를 갖는 file 객체 생성
		File f4 = new File("D:/");

		displayFileList(f4); // 메서드 호출
	}

	private static void displayFileList(File dir) {
		System.out.println("["+dir.getAbsolutePath() + "] 디렉토리 내용 ");
		
		// 디렉토리 안의 모든 파일 목로을 가져온다.
		File[] files = dir.listFiles();
		
		// 하위 디렉토리 정보를 저장할 ArrayList 생성
		List<Integer> subDirList = new ArrayList<Integer>();
		
		// 날짜를 출력하기 위한 형식 살장
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
		
		for (int i = 0; i < files.length; i++) {
			String attr ="";
			String size ="";
		
			if (files[i].isDirectory()) {
				attr = "<DIR>";
				subDirList.add(i); // 인덱스를 List에 추가
			} else {
				size = files[i].length() + "";
				attr += files[i].canRead()? "R" : " ";
				attr += files[i].canWrite()? "W" : " ";
				attr += files[i].isHidden()? "H" : " ";
				
			}
			System.out.printf("%s %5s %12s %s\n", sdf.format(new Date(files[i].lastModified())),attr, size, files[i].getName());
		}
		int dirCount = subDirList.size(); // 폴더 안의 하위 폴더 개수 구하기
		int fileCount = files.length - dirCount;
		
		System.out.println(fileCount + "개 의 파일 ," + dirCount + "개의 디렉토리");
		System.out.println();
		
		for (int i = 0; i < subDirList.size(); i++) {
	         // 하위 폴더의 내용들도 출력하기 위해 현재 메서드를 재귀호출하여 처리한다.
	         displayFileList(files[subDirList.get(i)]);
	      }
	
	}

}
