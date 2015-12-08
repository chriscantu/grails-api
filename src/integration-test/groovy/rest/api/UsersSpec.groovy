package rest.api

import grails.test.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*
import geb.spock.*
import grails.plugins.rest.client.RestBuilder

@Integration
@Rollback
class UsersSpec extends GebSpec {
    @Shared
    private def client = new RestBuilder()

    @Shared
    def uri

    def setup() {
      uri = "${baseUrl}/users"
    }

    def cleanup() {
    }

    void "GET: Users"() {
        when:
            def resp = client.get(uri)
        then:
            resp.status == 200
            resp.json.total == 0
            resp.json.list == []

    }
}
