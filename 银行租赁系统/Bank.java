package cn.itcast.application;
import java.util.Scanner;
//银行账户类
public class Bank {
	int account;
	private static User user;
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Bank b=new Bank();
		b.login();
		b.operate();
	}
	//账户金额存入，取出和查询操作
	public void operate() {
		Bank b=new Bank();
		while(true) {
			System.out.println("请输入您要进行的操作，按回车键结束");
			System.out.println("1.存款  "+"\t"+"2.取款  "+"\t"+"3.余额查询"+"\t"+"0.退出");
			Scanner in=new Scanner(System.in);
			String s=in.nextLine();//输入操作的类型
			if("1".equals(s)||"2".equals(s)) {
				int num=0;
				try {
					System.out.println("输入存取的金额：");
					num=Integer.parseInt(in.nextLine());
				}catch(Exception e) {
					System.out.println("金额输入错误！");
					continue;
				}
				switch(s) {
				case "1"://存款
					b.income(num);
					break;
				case "2"://取款
					b.takeout(num);
					break;
				}
			}else if("3".equals(s)) {
				b.show();
			}else if("0".equals(s)) {
				System.out.println("退出系统！");
				return;
			}else {
				System.out.println("请输入0~3之间的数字选择相关操作！");
			}
		}
	}
	//用户登录网上银行
	public void login() {
		DBUtil dbutil=DBUtil.getInstance();
		Bank b=new Bank();
		System.out.println("欢迎进入网上银行系统！");
		System.out.println("请选择是否要注册用户");
		System.out.println("开户请按4  退出请按0");
		Scanner in=new Scanner(System.in);
		String s=in.nextLine();
		if("4".equals(s)) {
			b.register();
			b.save();
			System.out.println("注册成功！");		
		}
		while(true) {
			System.out.println("请输入银行卡号：");
			String cardId=in.nextLine();
			System.out.println("请输入银行卡密码：");
			String cardPwd=in.nextLine();
			user=dbutil.getUser(cardId);
			//登录
			if(dbutil.getUsers().containsKey(cardId)&&
					user.getCardPwd().equals(cardPwd)) {
				System.out.println("登陆成功！欢迎"+user.getUserName()+"女士/先生");
				break;
			}else {
				System.out.println("银行卡号或密码错误！");
				continue;
			}
		}
	}
	//存款
	public void income(int num) {
		account=user.getAccount()+num;
		user.setAccount(account);
		System.out.println("存入金额"+num+"元成功！");
	}
	//取款
	public void takeout(int num) {
		if(user.getAccount() >=num){
			account=user.getAccount()-num;
			user.setAccount(account);
			System.out.println("取出金额"+num+"元成功！");
		}
		else {
			System.out.println("账户余额不足！");
		}
	}
	//显示余额
	public void show() {
		account=user.getAccount();
		System.out.println("该账户余额为："+account+"元！");
	}
	private void save() {
		DBUtil dbUtil=DBUtil.getInstance();
		dbUtil.update();
	}
	//创建用户
	private void register() {
		User u=new User();
		Scanner scanner=new Scanner(System.in);
		System.out.println("输入卡号：");
		u.setCardId(scanner.nextLine());
		System.out.println("输入用户名：");
		u.setUserName(scanner.nextLine());
		System.out.println("输入密码：");
		u.setCardPwd(scanner.nextLine());
		System.out.println("输入手机号：");
		u.setCall(scanner.nextLine());
		System.out.println("输入余额：");
		u.setAccount(scanner.nextInt());
		DBUtil dbUtil=DBUtil.getInstance();	
		dbUtil.addUser(u);
	}
}
