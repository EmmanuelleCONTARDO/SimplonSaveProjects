import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Reflexivite {

	public static void main(String[] args) {	
		
		//D�tail de ma classe
		String nameClass = "Personne";
		try {		
			
			
			//r�cup�ration de la class "Class"
			Class<?> classPersonne = Class.forName(nameClass);
			System.out.println(" **** Je suis la classe : "+classPersonne.getClass()+" qui contient toutes les infos utiles de :"+classPersonne.getName()+" **** ");
			//Nom
			System.out.println("Classe �tudi�e: "+classPersonne.getName());
			//Attributs
			Field[] fields = classPersonne.getDeclaredFields();
			System.out.println("*** Je poss�des : "+fields.length+" champs d�clar�s ***");
			for(int i = 0 ; i < fields.length ; i++) {
				Field field = fields[i];				
				System.out.println("  - Attribut	: '"+field.getName()+"'	- type : "+field.getType()+" Ma visibilit� est : "+Modifier.toString(field.getModifiers()));
			}
			//M�thodes
			Method[] methods = classPersonne.getDeclaredMethods();
			System.out.println("*** Je poss�des : "+methods.length+" m�thodes d�clar�s que chez moi ***");
			for(int i = 0 ; i < methods.length ; i++) {
				Method method = methods[i];
				Class<?>[] params = method.getParameterTypes();
				System.out.println(" - La m�thode '"+method.getName()+"' qui attend "+params.length+" param�tres");
				
				for(int j = 0 ; j < params.length ; j++) {
					System.out.println("-- Param�tre N�= "+(j+1)+" : '"+params[j].getSimpleName()+"'");
				}
			}			
			
			
			
			
			//H�ritage
			Class<?> superClass = classPersonne;
			int 
			i = 0;
			System.out.println("** voici ma hi�rarchie **");
			
			while(superClass != null) {
				System.out.print("|");
				for(int j = 0 ; j <= i*2 ; j++) {
					System.out.print("__");
				}
				System.out.println(" "+superClass.getSimpleName());
				superClass = superClass.getSuperclass();				
				i++;
			}
			
			//Modifier un champ priv�
			Personne pers = new Personne("", "", 2);
			Class<?> persClass = pers.getClass();
			
			try {
				Field field;
				field = persClass.getDeclaredField("age");
				field.setAccessible(true);
				field.set(pers,14);
				System.out.println(pers.getAge());
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			//Intanciation habituelle
			System.out.println(" **** Essais d'instanciation : **** ");
			Personne d = new Personne("Checa","David",38);
			Personne d2 = new Personne("Checa","David",38);
			d.presenter("Yeah ! ");
			System.out.println(d.equals(d2));
			//Instanciation via reflexivit�
			Constructor<?> constructeurPersonne = classPersonne.getConstructor(String.class,String.class,int.class);
			Object david = constructeurPersonne.newInstance(new String("Checa"), new String("David"), new Integer(38));
			Class<?>[] types = new Class[]{String.class};
			Method methodePresenter = classPersonne.getMethod("presenter",types);
			methodePresenter.invoke(david, new String("Yeah ! "));
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("La Classe "+nameClass+" n'existe pas !");			
			e.printStackTrace();
		} catch (NoSuchMethodException e) {			
			System.out.println("Ce n'est pas la bonne m�thode qui est appel�e (mauvais constructeur ou mauvais nom de m�thode");
			e.printStackTrace();
		} catch (SecurityException e) {			
			e.printStackTrace();
		} catch (InstantiationException e) {			
			e.printStackTrace();
		} catch (IllegalAccessException e) {			
			e.printStackTrace();
		} catch (IllegalArgumentException e) {			
			System.out.println("Un mauvais type d'argument est pass� : "+e.getMessage());
			e.printStackTrace();
		} catch (InvocationTargetException e) {			
			e.printStackTrace();
		}		
	}

}
