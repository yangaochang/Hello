public class Student {
	public static void main (String[] args) {
		System.out.println("1、添加学生信息------------");
		add();
		System.out.println("2、删除学生信息------------");
		remove();
		System.out.println("3、修改学生信息------------");
		alter();
	}
 public static void add() {
	 StringBuffer ming=new StringBuffer();
	 ming.append("邵天天");
	 System.out.println("append添加结果:"+ming);
	 ming.insert(0, 184805023);
	 System.out.println("insert添加结果："+ming);
 }
 public static void remove() {
	 StringBuffer ming=new StringBuffer("邵天天");
	 ming.delete(0, 5);
	 System.out.println("删除指定位置结果:"+ming);
     ming.delete(0, ming.length());
	 System.out.println("清空缓冲区结果:"+ming);
 }
 public static void alter() {
	 StringBuffer ming=new StringBuffer("邵天天");
	 ming.replace(0,5,"袁志博");
	 System.out.println("替换指定位置字符（串）结果:"+ming);
	 System.out.println("字符串翻转结果:"+ming.reverse());
 }
}
