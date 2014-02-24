import static org.junit.Assert.*;

import org.junit.Test;
public class palindromo {
	int n;
	public int  dadovuelta(int n){
		int reves=0;
		while(n>0){
			reves=reves*10+n%10;
			n=n/10;
		}
		return reves;
	}
	public boolean espal(int n){
		if(n<10)return true;
		else{
			if(dadovuelta(n)==n)return true;
			else return (n==dadovuelta(n));
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Test
	public void test1(){
		n=2;
		assertEquals(n,2);
	}
	@Test
	public void test2(){
		for(int i=0;i<10;i++){
			assertEquals((espal(i)),true);
		}
	}
	@Test
	public void test3(){
		n=123;
		assertEquals(dadovuelta(n),321);
	}
	@Test
	public void test4(){
		n=234;
		assertEquals(espal(n),false);
		n=123454321;
		assertEquals(espal(n),true);
	}
}
