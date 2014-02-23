import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Assert.*;
import java.util.*;


public class arbolbin{
	class nodobin{
		int clave;
		nodobin[] enlaces;
		public nodobin(int info){
			clave = info;
			enlaces=new nodobin[2];
			enlaces[0]=null;
			enlaces[1]=null;
		}
	}
	protected int numElem;
	private nodobin raiz;
	public arbolbin(){
		raiz=null;
		numElem=0;
	}
	public int tamano(){
		return numElem;
	}
	public boolean esta(nodobin raiz,int valor){
		if(raiz==null){
			return false;
		}
		else{
			if(raiz.clave==valor){
				return true;
			}
			else{
				if(valor<raiz.clave){
					return esta(raiz.enlaces[0],valor);
				}
				else return esta(raiz.enlaces[1],valor);
			}
		}
	}
	public void insertar(int n){
		nodobin aux;
		boolean flag=true;
		if(raiz!=null){
			if(!esta(n)){
				aux=raiz;
				while(flag){
					if(n<aux.clave){
						if(aux.enlaces[0]!=null){
							aux=aux.enlaces[0];
						}
						else{
							aux.enlaces[0]=new nodobin(n);
							numElem++;
							flag=false;
						}
					}
					else{
						if(aux.enlaces[1]!=null){
							aux=aux.enlaces[1];
						}
						else{
							aux.enlaces[1]=new nodobin(n);
							numElem++;
							flag=false;
						}
					}
				}
			}
		}
		else{
			raiz=new nodobin(n);
			numElem++;
		}
	}
	public boolean esVacio(){
		return tamano()==0;
	}
	public boolean esta(int valor){
		return esta(raiz,valor);
	}
	public void componentes(ArrayList<Integer> vector){
		componentes(raiz, vector);
	}
	public void componentes(nodobin nodo, ArrayList<Integer> vector){
		if(nodo!=null){
			vector.add(nodo.clave);
			componentes(nodo.enlaces[0], vector);
			componentes(nodo.enlaces[1], vector);
		}
	}
	public void copia(arbolbin arbol){
		if (raiz==null)return;
		ArrayList<Integer> vector=new ArrayList<Integer>();
		componentes(vector);
		for(int i=0;i<vector.size();i++){
			arbol.insertar(vector.get(i));
		}
	}
	public int maximo(){
		int aux=0;
		if(raiz!=null){
			nodobin auxi=raiz;
			while(auxi!=null){
				aux=auxi.clave;
				auxi=auxi.enlaces[1];
			}
		}
		return aux;
	}
	public static void main(String[] args){
		arbolbin prueba=new arbolbin();
		arbolbin copiado=new arbolbin();
		int maximo;
		prueba.insertar(57);
		prueba.insertar(70);
		prueba.insertar(25);
		prueba.insertar(96);
		prueba.insertar(42);
		prueba.insertar(23);
		prueba.insertar(32);
		prueba.insertar(86);
		prueba.insertar(10);
		prueba.insertar(100);
		ArrayList<Integer> vector =new ArrayList<Integer>();
		ArrayList<Integer> vector2 =new ArrayList<Integer>();
		prueba.componentes(vector);
		prueba.copia(copiado);
		copiado.componentes(vector2);
		maximo=prueba.maximo();
	}
	@Test
	public void testesta(){
		arbolbin arbolprueba = new arbolbin();
		for(int i=0;i<15;i++){
			arbolprueba.insertar(i);
		}
		arbolprueba.insertar(18);
		arbolprueba.insertar(21);
		arbolprueba.insertar(10);
		arbolprueba.insertar(20);
		assertEquals(arbolprueba.esta(20),true);
		assertEquals(arbolprueba.tamano(),18);
	}
	@Test
	public void testmax(){
		arbolbin prueba=new arbolbin();
		prueba.insertar(57);
		prueba.insertar(70);
		prueba.insertar(25);
		prueba.insertar(96);
		prueba.insertar(42);
		prueba.insertar(23);
		prueba.insertar(32);
		prueba.insertar(86);
		prueba.insertar(10);
		prueba.insertar(100);
		assertEquals(prueba.maximo(),100);
		
	}
}