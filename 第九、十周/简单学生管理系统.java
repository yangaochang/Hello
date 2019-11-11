public class Student 
{
//	String major;
//	String sex;
//	int grade;
	int number;//学号
	String name;
	public Student()
	{}
	public Student(int number,String name)
	{
		this.number=number;
		this.name=name;
	}
	Student add(Student s,int count)
	{
		Student s1=s;
		System.out.println("请入学号：");
		Scanner sc=new Scanner(System.in);
		s.number=sc.nextInt();
		System.out.println("请输入姓名：");
		s.name=sc.next();
		return s;
	}
	void show(int count,Student stu[])
	{
		if(count>0)
		{
			for(int i=0;i<count;i++)
				System.out.println("学号为："+stu[i].number+"\t姓名为："+stu[i].name);
		}
		else
			System.out.println("为空");
	}
	int search(int count,Student stu[])
	{
		System.out.println("请输入你要查找的学号：");
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt();
		for(int i=0;i<count;i++)
			if(x==stu[i].number)
				return i;
		return 999;
	}
	void modify(int count,Student stu[])
	{
		int i=search(count,stu);
		if(i==999)
		{
			System.out.println("没有查找到这个学号");
			return;
		}
		System.out.println("请输入修改后的学号：");
		Scanner sc=new Scanner(System.in);
		stu[i].number=sc.nextInt();
		System.out.println("请输入修改后的姓名：");
		stu[i].name=sc.next();
		new Student().show(count,stu);
	}
	Integer delete(int count,Student stu[])
	{
		int i=search(count,stu);
		if(i==999)
		{
			System.out.println("没有查找到这个学号");
			return null;
		}
		for(int j=i;j<count;j++)
			stu[j]=stu[j+1];
		return count--;
	}
}
class StudentManageStudent 
{
	public  static void main(String[] args) 
	{	
		Scanner sc =new Scanner(System.in);
		int x=1;//开关
		int count = 3;//计数
		Student stu[]=new Student[10];
		stu[0]=new Student(1,"a");
		stu[1]=new Student(2,"b");
		stu[2]=new Student(3,"c");
		while(x!=0)
		{
			System.out.println("1.增\t2.删\t3.查\t4.改\t5.浏览\t0.退出");
			x =sc.nextInt();
			switch(x)
			{
			case 1:
				stu[count]=new Student().add(new Student(),count);
				count++;
				break;
			case 2:
				Student s=new Student();
				if(s.delete(count, stu)!=null)
				{
					count--;
					break;
				}
				break;
			case 3:
				int i=new Student().search(count,stu);
				if(i==999)
					System.out.println("没有查询到这个学号");
				else
					System.out.println("number="+stu[i].number+"\tname="+stu[i].name);
				break;
			case 4:
				new Student().modify(count,stu);
				break;
			case 5:
				new Student().show(count,stu);
				break;
			}
		}
	}
}

