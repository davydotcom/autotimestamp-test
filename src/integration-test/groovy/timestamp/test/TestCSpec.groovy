package timestamp.test


import grails.test.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

@Integration
@Rollback
class TestCSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "lastUpdated should work for dynamic update false and versioning on TestC"() {
        given:
        	def a = new TestC(name: 'David Estes')
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


    void "autoTimestamp should work with updateAll for dynamic update false and versioning on TestC"() {
        given:
            def a = new TestC(name: 'David Estes')
            a.save(flush:true)
            a.refresh()
            def lastUpdated = a.lastUpdated
            sleep(5000)
        when:
            TestC.where{id == a.id}.updateAll(name: 'David R. Estes')
            a.refresh()
        then: 
            a.lastUpdated > lastUpdated
    }
}
