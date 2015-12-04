class UrlMappings {

    static mappings = {
        "/$controller/$id?" {
            action = [GET:"show", PUT: "update", DELETE:"delete", POST:"save"]
        }

        "500"(controller: 'InternalServerError')
        "404"(controller: 'NotFound')
    }
}
