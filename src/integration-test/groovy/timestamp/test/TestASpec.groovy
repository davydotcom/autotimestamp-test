package timestamp.test


import grails.test.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
@Rollback
class TestASpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "lastUpdated should work for dynamic update and no versioning on TestA"() {
        given:
        	def a = new TestA(name: 'David Estes')
        	a.save(flush:true)
        	a.refresh()
        	def lastUpdated = a.lastUpdated
        	sleep(5000)
        when:
        	a.name = "David R. Estes"
        	a.save(flush:true)
        	a.refresh()
        then: 
        	a.lastUpdated > lastUpdated
    }
}
