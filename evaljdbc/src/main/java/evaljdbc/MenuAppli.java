package evaljdbc;

import java.util.ArrayList;

public class MenuAppli {

	/**
	  * 
	  * @author Xavier Tagliarino <xavier.tagliarino@gmail.com>
	  * @access private
	  * @name itemMenus
	  * @var ArrayList<Menu> 
	  * 
	  */
	
	private ArrayList<ItemMenu> itemMenus = new ArrayList<ItemMenu>();
	
	/**	 
	  *
	  * Permet l'affcichage du menu
	  * 
	  * @access public
	  * @name toString
	  * @return String
	  * 
	  */
	
	public String toString() {
		
		String str= "";
		
		for(int i = 0 ; i < this.getItemMenus().size() ; i++) {
			str += i+") "+this.getItemMenus().get(i)+"\n";
		}
		return str;
	}

	public ArrayList<ItemMenu> getItemMenus() {
		return itemMenus;
	}

		
	public void add(ItemMenu item) {
		this.getItemMenus().add(item);
	}
		
}
