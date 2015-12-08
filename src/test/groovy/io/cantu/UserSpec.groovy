package io.cantu

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserSpec extends Specification {

    def setup() {
      new User(firstName: 'Chris', lastName: 'Cantu').save()
    }

    def cleanup() {
    }

    void "Users should exist"() {
        expect:"Some users to exist"
            User.list().size() == 1
    }

    void "Users should have properties"() {
        when: "User exists"
           def user = User.first()
        then: "User should have first & lastName"
           user.firstName != null
           user.lastName != null
    }
}
