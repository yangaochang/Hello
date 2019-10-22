public class ExampleTaxi{

	public static void main(String[] args) {
		Taxi t=new Taxi();
		new Thread(t,"出租车1").start();
		new Thread(t,"出租车2").start();
		new Thread(t,"出租车3").start();
		new Thread(t,"出租车4").start();
		new Thread(t,"出租车5").start();
		// TODO Auto-generated method stub

	}

}
class Taxi implements Runnable{
	private int passenger=100;
	public void run(){
		while(true){
			if(passenger>0){
				Thread t=Thread.currentThread();
				String t_name=t.getName();
				System.out.println(t_name+"正在接送第"+passenger--+"位乘客");
			}
		}
	}
}
