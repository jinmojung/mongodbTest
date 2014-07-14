package test

class Menu {

    static constraints = {
    }
	
	static mapping = {
		version false
	}
	
	String name
	long price
	
	static mapWith = "mongo"
}
