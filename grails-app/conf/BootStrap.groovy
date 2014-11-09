import com.app.User

class BootStrap {

    def init = { servletContext ->
        User user = new User(username: 'example')
        user.save(failOnError: true)
    }

    def destroy = {
    }
}
