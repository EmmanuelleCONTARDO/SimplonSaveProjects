/*******************************************************************************
 * 2018, All rights reserved.
 *******************************************************************************/


// Start of user code (user defined imports)

// End of user code

/**
 * Description of Cat.
 * 
 * @author Utilisateur
 */
public class Cat {
	/**
	 * Description of the property idCat.
	 */
	public int idCat = 0;
	
	/**
	 * Description of the property articles.
	 */
	public HashSet<Article> articles = new HashSet<Article>();
	
	// Start of user code (user defined attributes for Cat)
	
	// End of user code
	
	/**
	 * The constructor.
	 */
	public Cat() {
		// Start of user code constructor for Cat)
		super();
		// End of user code
	}
	
	// Start of user code (user defined methods for Cat)
	
	// End of user code
	/**
	 * Returns idCat.
	 * @return idCat 
	 */
	public int getIdCat() {
		return this.idCat;
	}
	
	/**
	 * Sets a value to attribute idCat. 
	 * @param newIdCat 
	 */
	public void setIdCat(int newIdCat) {
	    this.idCat = newIdCat;
	}

	/**
	 * Returns articles.
	 * @return articles 
	 */
	public HashSet<Article> getArticles() {
		return this.articles;
	}



}
