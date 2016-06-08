package timestamp.test

class TestB {
	String name
	Date dateCreated
	Date lastUpdated

    static mapping = {
    	version true
    	dynamicUpdate true
    }
    static constraints = {
    }
}
