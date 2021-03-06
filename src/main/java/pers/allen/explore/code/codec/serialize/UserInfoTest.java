package pers.allen.explore.code.codec.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import pers.allen.explore.code.codec.UserInfo;

/**
 * POJO对象序列化测试
 * @author lengyul
 * Java序列化的主要两个目的：
 * 1.网络传输
 * 2.对象持久化
 * --------------------------------
 * Java序列化存在的问题：
 * 1.无法跨语言
 * 2.编码后的字节太大,在网络传输中时更占用宽带
 * 3.编解码性能以及类库和api使用方便
 */
public class UserInfoTest {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		UserInfo userInfo = new UserInfo("Allen",10001); //5 + 4 + 4
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream os = new ObjectOutputStream(bos);
		os.writeObject(userInfo);
		os.flush();
		os.close();
		
		System.out.println("The jdk serializable length is: "+bos.toByteArray().length);
		System.out.println("The byte array serializable length is: "+userInfo.codeC().length);
		
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		Object object = ois.readObject();
		System.out.println(object);
		
	}
	
}
