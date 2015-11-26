package com.cseur.xlsWorksUI;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.cseur.xlsService.Routing;
import com.cseur.xlsService.RoutingService;
import com.vaadin.ui.*;

import javax.servlet.annotation.WebServlet;

/* User Interface written in Java.
 *
 * Define the user interface shown on the Vaadin generated web page by extending the UI class.
 * By default, a new UI instance is automatically created when the page is loaded. To reuse
 * the same instance, add @PreserveOnRefresh.
 */
@Title("Create Routing")
@Theme("valo")
public class CreateRoutingUI extends UI {







	/* Hundreds of widgets.
	 * Vaadin's user interface components are just Java objects that encapsulate
	 * and handle cross-browser support and client-server communication. The
	 * default Vaadin components are in the com.vaadin.ui package and there
	 * are over 500 more in vaadin.com/directory.
     */
    TextField filter = new TextField();
    Grid routingList = new Grid();
    Button newRouting = new Button("New Routing");

    // RoutingForm is an example of a custom component class
    RoutingForm contactForm = new RoutingForm();

    // RoutingService is a in-memory mock DAO that mimics
    // a real-world datasource. Typically implemented for
    // example as EJB or Spring Data based service.
    RoutingService service = RoutingService.createDemoService();


    /* The "Main method".
     *
     * This is the entry point method executed to initialize and configure
     * the visible user interface. Executed on every browser reload because
     * a new instance is created for each web page loaded.
     */
    @Override
    protected void init(VaadinRequest request) {
        configureComponents();
        buildLayout();
    }


    private void configureComponents() {
         /* Synchronous event handling.
         *
         * Receive user interaction events on the server-side. This allows you
         * to synchronously handle those events. Vaadin automatically sends
         * only the needed changes to the web page without loading a new page.
         */
        newRouting.addClickListener(e -> contactForm.edit(new Routing()));

        filter.setInputPrompt("Filter Routings ...");
        filter.addTextChangeListener(e -> refreshRoutings(e.getText()));

        routingList.setContainerDataSource(new BeanItemContainer<>(Routing.class));
        routingList.setColumnOrder("POL", "POD");
        routingList.removeColumn("id");
        routingList.setSelectionMode(Grid.SelectionMode.SINGLE);
        routingList.addSelectionListener(e
                -> contactForm.edit((Routing) routingList.getSelectedRow()));
        refreshRoutings();
    }

    /* Robust layouts.
     *
     * Layouts are components that contain other components.
     * HorizontalLayout contains TextField and Button. It is wrapped
     * with a Grid into VerticalLayout for the left side of the screen.
     * Allow user to resize the components with a SplitPanel.
     *
     * In addition to programmatically building layout in Java,
     * you may also choose to setup layout declaratively
     * with Vaadin Designer, CSS and HTML.
     */
    private void buildLayout() {
        HorizontalLayout topbar = new HorizontalLayout(filter, newRouting);
        topbar.setWidth("100%");
        filter.setWidth("100%");
        topbar.setExpandRatio(filter, 1);

        VerticalLayout tableContent = new VerticalLayout(topbar, routingList);
        tableContent.setSizeFull();
        routingList.setSizeFull();
        tableContent.setExpandRatio(routingList, 1);
        
        VerticalLayout fileTree =new VerticalLayout();
        fileTree.setWidth(5,Unit.CM);
        fileTree.setSizeFull();
        
        HorizontalLayout mainLayout = new HorizontalLayout(fileTree,tableContent, contactForm);
        mainLayout.setSizeFull();
        mainLayout.setExpandRatio(tableContent, 1);

        // Split and allow resizing
        setContent(mainLayout);
    }

    /* Choose the design patterns you like.
     *
     * It is good practice to have separate data access methods that
     * handle the back-end access and/or the user interface updates.
     * You can further split your code into classes to easier maintenance.
     * With Vaadin you can follow MVC, MVP or any other design pattern
     * you choose.
     */
    void refreshRoutings() {
        refreshRoutings(filter.getValue());
    }

    private void refreshRoutings(String stringFilter) {
        routingList.setContainerDataSource(new BeanItemContainer<>(
                Routing.class, service.findAll(stringFilter)));
        contactForm.setVisible(false);
    }




    /*  Deployed as a Servlet or Portlet.
     *
     *  You can specify additional servlet parameters like the URI and UI
     *  class name and turn on production mode when you have finished developing the application.
     */
    @WebServlet(urlPatterns = "/*")
    @VaadinServletConfiguration(ui = CreateRoutingUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }


}
