import org.junit.Test;
import static org.junit.Assert.*;

public class matrices{
	public int pasoparametros(){
		char[][] matriz = new char[26][26];
		char[] vector=new char[26];
		int aux=0;
		for (char i= 'A';i<='Z';i++){
			vector[aux]=i;
			aux++;
		}
		for (int i=0;i<matriz.length;i++){
			for (int j=0;j<matriz[i].length;j++){
				matriz[i][j]=vector[i];				
			}
		}
		aux=aux(matriz[12]);
		return aux;
	}
	public boolean contenida(int[][] mat1, int[][] mat2){
		boolean aux=false;
		int k=0,l=0;
		for(int i=0;i<mat2.length;i++){
			for(int j=0;j<mat2[i].length;j++){
				if((mat1[0][0]==mat2[i][j])&&(mat2.length-i>=mat1.length)&&(mat2[i].length-j>=mat1[i].length)){
					for(k=0;k<mat1.length;k++){
						for(l=0;l<mat1[i].length;l++){
							if(mat1[k][l]==mat2[i+k][j+l]){
								aux=true;
							}
							else{
								aux=false;
								break;
							}
						}
						if(l!=mat1[i].length){
							break;
						}
					}
					if((aux)&&(k==mat1.length)&&(l==mat1[i].length)){
						return aux;
					}
				}
			}
		}
		return aux;
	}
	public int numRomano(char[][] mat){
		int[] sumas = new int[mat.length];
		int indice=0;
		for(int i=0;i<mat.length;i++){
			sumas[i]=aux(mat[i]);
		}
		for(int j=1;j<sumas.length;j++){
			if(sumas[j]>=sumas[indice]){
				indice=j;
			}
		}
		return indice;
	}
	public int aux(char[] vaux){
		int suma=0;
		for(int i=0;i<vaux.length;i++){
			switch(vaux[i]){
			case 'I': suma+=1;
				break;
			case 'V': suma+=5;
				break;
			case 'X': suma+=10;
				break;
			case 'L': suma+=50;
				break;
			case 'C': suma+=100;
				break;
			case 'D': suma+=500;
				break;
			case 'M': suma+=1000;
				break;
			default: suma+=0;
			}
		}
		return suma;
	}
	public int sumarecursiva(int a,int b){
		if(b==0)return a;
		return (sumarecursiva(a+1,b-1));
	}
	public int multrecur(int a, int b){
		if(b==1){
			return a;
		}
		else{
			return a+(multrecur(a,b-1));
		}
	}
	public static void main(String[] args){
	}
	@Test
	public void pruebacontenido(){
		int[][] m1={{1,2,3},{1,2,3},{1,2,3}};
		int[][] m2={{1,2,3},{1,2,3},{1,2,3}};
		int[][] m3=new int[9][9];
		for(int i=0;i<m3.length;i++){
			for(int j=0;j<m3[0].length;j++){
				m3[i][j]=j;
			}
		}
		assertEquals(contenida(m1,m2),true);
		assertEquals(contenida(m1,m3),true);
	}
	@Test
	public void pruebanumRomano(){
		char[][] mat = {{'M','V','D'},{'L','M','X'},{'X','D','V'}};
		assertEquals(numRomano(mat),0);
	}
	@Test
	public void pruebasuma(){
		int a=6;
		int b=3;
		assertEquals(sumarecursiva(a,b),9);
	}
	@Test
	public void pruebamult(){
		assertEquals(multrecur(15,15),225);
	}
	@Test
	public void pruebapaso(){
		assertEquals(pasoparametros(),26*1000);
	}
}