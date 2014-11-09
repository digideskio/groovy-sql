package app

import com.vaadin.ui.UI
import com.vaadin.ui.VerticalLayout
import com.vaadin.server.VaadinRequest
import com.vaadin.ui.Label
import com.vaadin.grails.Grails
import groovy.sql.GroovyResultSet
import groovy.sql.Sql

class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout layout = new VerticalLayout()

        Sql sql = Grails.get(Sql)
        sql.eachRow("SELECT * FROM User") { GroovyResultSet result ->
            String firstName = result.getString('username')
            layout.addComponent(new Label(firstName))
        }

        setContent(layout)

        // Sql sql = new Sql(dataSource: Grails.applicationContext.getBean('dataSource'))
        // execute your queries
        // sql.close()
    }
}
