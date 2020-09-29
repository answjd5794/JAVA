package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *  부모 클래스가 Serializable 인터페이스를 구현하고 있지 않을 경우
 * 
 *  부모 객체의 필드값 처리방법
 * 1. 부모 클래스가 Serialazable 인터페이스를 구현하도록 해야한다.
 * 2. 자식 클래스의 writeObject()와 readObject() 메서드를 이용하여 부모 객체의 필드값을 처리할 수 있도록 직접 구현한다. 
 */
public class T16_NonSerializableParentTest {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("d:/D_Other/nonSerializableTest.bin");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		Child child = new Child();
		child.setParentName("부모");
		child.setChildName("자식");
	
		oos.writeObject(child); // 직렬화
		oos.flush(); // 생략 가능
		oos.close();
		
		// =============================== 
		
		FileInputStream fis = new FileInputStream("d:/D_Other/nonSerializableTest.bin");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Child child2 = (Child)ois.readObject(); // 역직렬화
		
		// 부모는 직렬화 대상이 아니기 때문에 null뜸
		// => implements Serializable를 부모한테 붙여주면 자식도 자동으로 직렬화가 된다
		System.out.println("parentName : " + child2.getParentName());
		System.out.println("parentName : " + child2.getChildName());
		
	}
}

class Parent{
	private String parentName;

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
}

class Child extends Parent implements Serializable{
	private String ChildName;

	public String getChildName() {
		return ChildName;
	}

	public void setChildName(String childName) {
		ChildName = childName;
	}
	
	/**
	 * 직렬화 될 때 자동으로 호출
	 * 접근제어자가 private이 아니면 자동호출 되지 않는다. -> 즉, 반드시 private로 써야한다.
	 * @method writeObject
	 * @param out
	 * @throws IOException
	 * @return void
	 * @author 강문정
	 */
	private void writeObject(ObjectOutputStream out) throws IOException {
		out.writeUTF(getParentName()); // ObjectOutPutStream을 이용하여 부모객체의 필드값 처리
		out.defaultWriteObject();
	}
	
	/**
	 * 역직렬화 될 때 자동으로 호출된다.
	 * (private가 아니면 호출되지 않는다.)
	 * @throws ClassNotFoundException 
	 */
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
		setParentName(in.readUTF()); // 부모 객체 필드값 처리
									// 마치  Serializable한 것 처럼 보여줄 수 있다.
		in.defaultReadObject();
	}
	
}