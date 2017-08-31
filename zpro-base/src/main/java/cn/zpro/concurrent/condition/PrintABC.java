package cn.zpro.concurrent.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABC {
    private int status =1;
    private ReentrantLock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();
    
    public void printA(){
    	lock.lock();
    	try{
    		if(status!=1){
    			conditionA.await();
    		}
    		System.out.print("A");
        	status=2;
        	conditionB.signal();
    	}catch(InterruptedException e){
    		e.printStackTrace();
    	}finally{
    		lock.unlock();
    	}
    }
    public void printB(){
    	lock.lock();
    	try{
    		if(status!=2){
    			conditionB.await();
    		}
    		System.out.print("B");
        	status=3;
        	conditionC.signal();
    	}catch(InterruptedException e){
    		e.printStackTrace();
    	}finally{
    		lock.unlock();
    	}
    }
    public void printC(){
    	lock.lock();
    	try{
    		if(status!=3){
    			conditionC.await();
    		}
    		System.out.println("C");
        	status=1;
        	conditionA.signal();
    	}catch(InterruptedException e){
    		e.printStackTrace();
    	}finally{
    		lock.unlock();
    	}
    }
    
    public static void main(String[] args){
    	PrintABC print = new PrintABC();
    	Thread threadA = new Thread(new RunnableA(print));
    	Thread threadB = new Thread(new RunnableB(print));
    	Thread threadC = new Thread(new RunnableC(print));
    	threadA.start();
    	threadB.start();
    	threadC.start();
    }
}

class RunnableA implements Runnable{
    private PrintABC print;
    
	public RunnableA(PrintABC print) {
		super();
		this.print = print;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++){
			print.printA();
		}
	}
	
}
class RunnableB implements Runnable{
    private PrintABC print;
    
	public RunnableB(PrintABC print) {
		super();
		this.print = print;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++){
			print.printB();
		}
		
	}
	
}
class RunnableC implements Runnable{
    private PrintABC print;
    
	public RunnableC(PrintABC print) {
		super();
		this.print = print;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++){
			print.printC();
		}
	}
	
}
