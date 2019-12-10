package yinhang;

import java.util.HashMap;

public class DBUtil {
	private static DBUtil instance = null;
	private HashMap<String,User> users = new HashMap<String,User>();
	
	private DBUtil(){
		
		User u1 = new User();
		u1.setCardId("12345601");
		u1.setCardPwd("111111");
		u1.setUserName("蓝薇薇");
		u1.setCall("12345678901");
		u1.setAccount(10000);
		users.put(u1.getCardId(), u1);
		
		User u2 = new User();
		u2.setCardId("12345602");
		u2.setCardPwd("222222");
		u2.setUserName("米暖");
		u2.setCall("12345678902");
		u2.setAccount(20000);
		users.put(u2.getCardId(), u2);
		
		User u3 = new User();
		u3.setCardId("12345603");
		u3.setCardPwd("333333");
		u3.setUserName("席天");
		u3.setCall("12345678903");
		u3.setAccount(30000);
		users.put(u3.getCardId(), u3);
	}
	//懒汉式单例模式
	public static DBUtil getInstance(){
		if(instance == null){
			synchronized(DBUtil.class){
				if(instance == null){
					instance = new DBUtil();
				}
			}
		}
		return instance;
	}
	//根据银行卡号获取对应单个账户的信息
	public User getUser(String cardId){
		User user = (User) users.get(cardId);
		return user;
	}
	//获取所有账户的信息
	public HashMap<String, User> getUsers(){
		return users;
	}

}
