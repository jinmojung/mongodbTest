package test



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class HibernateMenuController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond HibernateMenu.list(params), model:[hibernateMenuInstanceCount: HibernateMenu.count()]
    }

    def show(HibernateMenu hibernateMenuInstance) {
        respond hibernateMenuInstance
    }

    def create() {
        respond new HibernateMenu(params)
    }

    @Transactional
    def save(HibernateMenu hibernateMenuInstance) {
        if (hibernateMenuInstance == null) {
            notFound()
            return
        }

        if (hibernateMenuInstance.hasErrors()) {
            respond hibernateMenuInstance.errors, view:'create'
            return
        }

        hibernateMenuInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'hibernateMenu.label', default: 'HibernateMenu'), hibernateMenuInstance.id])
                redirect hibernateMenuInstance
            }
            '*' { respond hibernateMenuInstance, [status: CREATED] }
        }
    }

    def edit(HibernateMenu hibernateMenuInstance) {
        respond hibernateMenuInstance
    }

    @Transactional
    def update(HibernateMenu hibernateMenuInstance) {
        if (hibernateMenuInstance == null) {
            notFound()
            return
        }

        if (hibernateMenuInstance.hasErrors()) {
            respond hibernateMenuInstance.errors, view:'edit'
            return
        }

        hibernateMenuInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'HibernateMenu.label', default: 'HibernateMenu'), hibernateMenuInstance.id])
                redirect hibernateMenuInstance
            }
            '*'{ respond hibernateMenuInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(HibernateMenu hibernateMenuInstance) {

        if (hibernateMenuInstance == null) {
            notFound()
            return
        }

        hibernateMenuInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'HibernateMenu.label', default: 'HibernateMenu'), hibernateMenuInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'hibernateMenu.label', default: 'HibernateMenu'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
