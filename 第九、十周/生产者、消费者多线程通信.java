/**
 * 案例：期望生产一个商品就被消费掉，再生产下一个商品。
 */ 
//1、描述资源
class Resource{
    private String name;
    private int count=1;
    //定义标记
    private boolean flag=false;
    public synchronized void set(String name) {
        if(flag) {
            try {wait();} catch (InterruptedException e) {}
        }
        //给成员变量赋值并加上编号
        this.name = name+count;
        //编号自增
        count++;
        //打印生产了哪个商品
        System.out.println(Thread.currentThread().getName()+"...生产者.."+this.name);
        flag=true;
        //唤醒消费者
        notify();
    }
    
    public synchronized void out() {
        if(!flag) {
            try {wait();} catch (InterruptedException e) {}
        }
        System.out.println(Thread.currentThread().getName()+"...消费者.."+this.name);
        flag=false;
        //唤醒生产者
        notify();
    }
}

//2、描述生产者
class Producer implements Runnable{
    private Resource r;
    public Producer(Resource r){
        this.r=r;
    }
    @Override
    public void run() {
        while(true) {
                r.set("面包");        
        }
    }    
}
//3、描述消费者
class Consumer implements Runnable{
    private Resource r;
    public Consumer(Resource r){
        this.r=r;
    }
    @Override
    public void run() {
        while(true) {
                r.out();
        }
    }    
}

public class ThreadMain2 {
    public static void main(String[] args) {
        //1、创建资源对象
        Resource r=new Resource();
        //2、创建线程任务
        Producer p=new Producer(r);
        Consumer c=new Consumer(r);
        //3、创建线程对象
        Thread t1=new Thread(p);
        Thread t2=new Thread(c);
        
        t1.start();
        t2.start();
    }
}