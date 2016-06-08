package timestamp.test

class TestA {

	String name
	Date dateCreated
	Date lastUpdated
    static constraints = {
    }

    static mapping = {
    	version false
    	dynamicUpdate true
    }
}
