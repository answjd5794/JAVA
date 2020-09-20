package kr.or.ddit.basic;

/*문제) 태양계 행성을 나타내는 enum Planet을 이용하여 구하시오.
(단, enum 객체 생성시 반지름을 이용하도록 정의하시오.) 
	예) 행성의 반지름(KM):
	수성(2439), 
	금성(6052), 
	지구(6371), 
	성(3390), 
	목성(69911), 
	토성(58232), 
	천왕성(25362), 
	해왕성(24622)
	*/

public class T09_EnumPlanetTest {
	enum Planet {
		수성(2439), 
		금성(6052), 
		지구(6371), 
		화성(3390), 
		목성(69911), 
		토성(58232), 
		천왕성(25362), 
		해왕성(24622);

		// 면적을 구하는 변수 선언
		private double radius;
		private double area;

		// planet 생성자 만들기 (묵시적으로 private)
		Planet(double radius) {
			this.radius = radius;
			// 행성의 면적 => 반지름의 2제곱*파이
			area = Math.pow(radius, 2)*Math.PI;
			// 지름만 구할 때
//			area = 2 * radius;
		}

		// 값을 반환하는 메서드
		public double getArea() {
			return area;
		}
	}

	public static void main(String[] args) {
		// 열거형 데이터를 배열로 가져온다
		Planet[] enumArr = Planet.values();
		for (int i = 0; i < enumArr.length; i++) {
			System.out.println(enumArr[i].name() + " : " + enumArr[i].getArea());
		}
		System.out.println();
		
	}
}
