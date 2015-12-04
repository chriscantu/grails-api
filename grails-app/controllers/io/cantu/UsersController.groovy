package io.cantu


import grails.rest.*
import grails.converters.*

class UsersController {
    static allowedMethods = [show: "GET", update: "PUT", delete: "DELETE", save: "POST"]

    def show() {
        if(params.id) {
            def user = User.get(params.id)
            user ? render(user) as JSON : render(
              status: 404,
              text: "Not Found",
              contentType: "application/json"
            )
        } else {
            params.max = Math.min(params.max ? params.int('max') : 10, 100)
            render(contentType:"application/json", builder:"json") {
              [
                total: User.count(),
                list: User.list(params)
              ]
            }
        }
    }
}
