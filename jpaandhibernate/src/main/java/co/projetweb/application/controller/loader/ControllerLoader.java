package co.projetweb.application.controller.loader;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import co.projetweb.application.controller.AppController;
import co.projetweb.application.controller.annotation.ComparatorControllerMethodAnnotation;
import co.projetweb.application.controller.annotation.ControllerMethodAnnotation;

/**
 * Loader of the controller
 * 
 * @author Xavier TAGLIARINO <xavier.tagliarino@gmail.com>
 * @name ControllerLoader
 *
 */


public class ControllerLoader {
	
	
	private static AppController controller = new AppController();
	
	/**
	  *
	  * Lister les m�thodes disponibles
	  * 
	  * @access public
	  * @return List<String>
	  * @name listAvailableMethods
	  *
	  */
	
	public static List<ControllerMethodAnnotation> listAvailableMethods() {
		
		Class<?> c = controller.getClass();
		Method[] methods = c.getDeclaredMethods();
			
		List<ControllerMethodAnnotation> listOfAnnotation = new ArrayList<ControllerMethodAnnotation>();
		
		for(Method m : methods) {
			Annotation myannonation = m.getAnnotation(ControllerMethodAnnotation.class);
			if (myannonation instanceof ControllerMethodAnnotation) {
				listOfAnnotation.add((ControllerMethodAnnotation) myannonation);
			}
			
		}
		listOfAnnotation.sort(new ComparatorControllerMethodAnnotation());
		return listOfAnnotation;				
	}
	
	
	/**
	  * Tente de lancer une m�thode dynamiquement via l'API r�flexivit�
	  * 
	  * @name lancerMethode
	  * @param String : nom de la m�thode
	  * @return boolean : indique si la m�thode a pu �tre lanc�e
	  * 
	  */
	
	public static  boolean lancerMethode(String methode)
	{		
		
		Class<?> classeAInstancier = controller.getClass();
		Class<?>[] types = new Class[] {String.class};				
		try {
			Method methodePresenter = classeAInstancier.getMethod("execute",types);
			methodePresenter.invoke(controller, methode);
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			return false;
		} catch (SecurityException e) {
			e.printStackTrace();
			return false;
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
			return false;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			return false;
		}
		
		
		return true;
	}
}
