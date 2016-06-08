package timestamp.test

class TestC {
	String name
	Date dateCreated
	Date lastUpdated

    static mapping = {
    	version true
    	dynamicUpdate false
    }
    static constraints = {
    }
}
