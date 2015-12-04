package rest.api

import grails.test.mixin.integration.Integration
import grails.transaction.*

import spock.lang.*
import geb.spock.*
import grails.plugins.rest.client.RestBuilder

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@Integration
@Rollback
class UsersSpec extends GebSpec {
    @Shared
    private def uri = "http://localhost:8080/users"

    @Shared
    private def client = new RestBuilder()

    def setup() {
    }

    def cleanup() {
    }

    void "GET: Users"() {
        when:
            def resp = client.get(uri)
        then:
            resp.status == 200

    }
}
