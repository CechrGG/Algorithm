package acmr.algorithm;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Arrays.asList("a","b","C").forEach(System.out::println);
    	new Thread(()->{
    		for(int i=0; i < 10; i++) {
    			System.out.println(i);
    			try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    		}
    	}).start();
        System.out.println( "Hello World!" );
    }
}
