import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Random;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kike
 */
public class mainvectores {
    public int productoescalar(int[] vector, int[] vector2){
        int res=0;
        if(vector.length==vector2.length){
            for(int i=0;i<vector.length;i++){
                res+=(vector[i]*vector2[i]);
            }
        }
        return res;
    }
    public static boolean ordenavector(int[] vector){
    	int cambio=0;
    	for(int i=0;i<vector.length-1;i++){
    		for(int j=i+1;j<vector.length;j++){
    			if(vector[i]>vector[j]){
    				cambio=vector[i];
    				vector[i]=vector[j];
    				vector[j]=cambio;
    			}
    		}
    	}
    	return true;
    }
    public boolean palindromo(int[] vector){
        for(int i=0;i<vector.length;i++){
        	if(vector[i]==vector[vector.length-i-1]){
        		if((i==vector.length-i-1)||(i+1==vector.length-i-1)){
        			return true;
        		}
        	}
        	else break;
        }
        return false;
    }
    public boolean palinrecur(int[] vec, int indice){
    	if(indice==vec.length-1-indice){
    		return true;
    	}
    	if(indice+1==vec.length-1-indice){
    		if(vec[indice]==vec[vec.length-1-indice]){
    			return true;
    		}
    	}
    	if(vec[indice]==vec[vec.length-1-indice]){
    		return palinrecur(vec,++indice);
    	}
    	else return false;
    }
    public boolean filasiguales(int[][] matriz){
        boolean res=false;
        int k=0;
        boolean[] vector= new boolean [matriz[0].length];
        for(k=0;k<vector.length;k++)vector[k]=false;
        for(int i=0;i<matriz[0].length-1;i++){
            for(int j=1;j<matriz[i].length-i;j++){
                for(k=0;k<matriz[i].length;k++){
                    if (matriz[i][k]==matriz[i+j][k]){
                        vector[k]=true;
                    }
                    else{
                        break;
                    }
                }
                for(k=0;k<matriz[0].length;k++){
                    if (vector[k]==false){
                        res=false;
                        break;
                    }
                }
                if((k==vector.length)&&(vector[k-1]==true)){
                    return true;
                }
            }
        }
        return res;
    }
    public boolean contenido(int[] vector, int[] vector2){
    	boolean aux=false;
    	int i=0,j=0;
    	for (i=0;i<vector2.length;i++){
    		if(vector[0]==vector2[i]){
    			for(j=0;j<vector.length;j++){
    				if(vector[j]==vector2[i+j]){
    					aux=true;
    				}
    				else{
    					aux=false;
    					break;
    				}
    			}
    			if((aux)&&(j==vector.length)){
    				return aux;
    			}
    		}
    	}
        return aux;
    }
    public boolean repetidos(int[] vector){
    	for(int i=0;i<vector.length-1;i++){
    		for (int j=i+1;j<vector.length;j++){
    			if(vector[i]==vector[j]){
    				return true;
    			}
    		}
    	}
    	return false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] vector = new int [10];
        boolean aux2;
        for(int i=0;i<vector.length;i++){
            Random aux = new Random();
            vector[i]=(aux.nextInt()%10);
        }
        aux2=ordenavector(vector);
    }
    @Test
    public void test1(){
        int[] vector = new int [300];
        int[] vector2= {4,3,2,1};
        int[] vector3={1,2,3,4};
        for(int i=0;i<300;i++){
            Random aux = new Random();
            vector[i]=aux.nextInt();
        }
        assertEquals(ordenavector(vector),true);
        ordenavector(vector2);
        //assertEquals(vector2,vector3);
    }
    @Test
    public void test2(){
        int[] vector = new int[10];
        int[] vector2 = {1,2,3,4,3,2,1};
        for(int i=0;i<vector.length;i++){
            vector[i] = i;
        }
        //assertEquals(palindromo(vector),false);
        //assertEquals(palindromo(vector2),true);
    }
    @Test
    public void test3(){
        int[] vector = {1,2,3,4};
        int[] vector2 = {3,2,5,1};
        assertEquals(productoescalar(vector,vector2),26);
    }
    @Test
    public void test4(){
        int[][] matriz = new int[10][10];
        int[][] matriz2 = new int[10][10];
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz.length;j++){
                matriz[i][j]=j;
                matriz2[i][j]=i;
            }
        }
        assertEquals (filasiguales(matriz),true);
        assertEquals (filasiguales(matriz2),false);
    }
    @Test
    public void test5(){
        int[] vector = {1,3,5,7};
        int[] vector2= {1,3,5,2,4,5,1,3,5,7,2,3,4,5,6,1,3,5,6,1,3,5,7,1,1,1,3,5,7};
        assertEquals(contenido(vector,vector2),true);
    }
    @Test
    public void test6(){
    	int[] vector = {1,2,3,4};
    	int[] vector2 = {1,2,3,1};
    	assertEquals(repetidos(vector),false);
    	assertEquals(repetidos(vector2),true);
    }
    @Test
    public void testpalindromo(){
    	int[] vectorunitario = {0};
    	int[] vector2 = {2,3,3,3,2};
    	assertEquals(palindromo(vectorunitario),true);
    	assertEquals(palindromo(vector2),true);
    }
    @Test
    public void testrecursivo(){
    	int[] vectorunitario = {0};
    	int[] vector2 = {2,3,564,3,2};
    	assertEquals(palinrecur(vectorunitario,0),true);
    	assertEquals(palinrecur(vector2,0),true);
    }
    @Test
    public void testrepetidos(){
    	int[] v={9};
    	//assertEquals(repetidos(v),false);
    }
}
