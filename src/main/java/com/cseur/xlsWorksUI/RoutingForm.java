package com.cseur.xlsWorksUI;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.event.ShortcutAction;
import com.cseur.xlsService.Routing;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.*;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.themes.ValoTheme;

/* Create custom UI Components.
 *
 * Create your own Vaadin components by inheritance and composition.
 * This is a form component inherited from VerticalLayout. Use
 * Use BeanFieldGroup to bind data fields from DTO to UI fields.
 * Similarly named field by naming convention or customized
 * with @PropertyId annotation.
 */
public class RoutingForm extends FormLayout {

    Button save = new Button("Save", this::save);
    Button cancel = new Button("Cancel", this::cancel);
    TextField POL = new TextField("POL:");
    TextField POD = new TextField("POD:");
    TextField VIA01 = new TextField("VIA01:");
    TextField VIA02 = new TextField("VIA02:");
    TextField VIA03 = new TextField("VIA03:");
    TextField VIA04 = new TextField("VIA04:");
    TextField routeCode = new TextField("RouteCode:");
    DateField lastUpdateDate = new DateField("LastUpdateDate:");

    Routing routing;

    // Easily bind forms to beans and manage validation and buffering
    BeanFieldGroup<Routing> formFieldBindings;

    public RoutingForm() {
        configureComponents();
        addEditPannel();
    }

    private void configureComponents() {
        /* Highlight primary actions.
         *
         * With Vaadin built-in styles you can highlight the primary save button
         * and give it a keyboard shortcut for a better UX.
         */
        save.setStyleName(ValoTheme.BUTTON_PRIMARY);
        save.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        setVisible(false);
    }

    private void addEditPannel() {
        setSizeUndefined();
        setMargin(true);

        HorizontalLayout actions = new HorizontalLayout(save, cancel);
        actions.setSpacing(true);
//        routeCode.setReadOnly(true);
        lastUpdateDate.setResolution(Resolution.SECOND);
        addComponents(actions, POL, POD, VIA01, VIA02, VIA03, VIA04, routeCode, lastUpdateDate);
    }

    /* Use any JVM language.
     *
     * Vaadin supports all languages supported by Java Virtual Machine 1.6+.
     * This allows you to program user interface in Java 8, Scala, Groovy or any other
     * language you choose.
     * The new languages give you very powerful tools for organizing your code
     * as you choose. For example, you can implement the listener methods in your
     * compositions or in separate controller classes and receive
     * to various Vaadin component events, like button clicks. Or keep it simple
     * and compact with Lambda expressions.
     */
    public void save(Button.ClickEvent event) {
        try {
            // Commit the fields from UI to DAO
            formFieldBindings.commit();

            // Save DAO to backend with direct synchronous service API
            getUI().service.save(routing);

            String msg = String.format("Saved '%s %s'.",
                    routing.getPOL(),
                    routing.getPOD());
            Notification.show(msg, Type.TRAY_NOTIFICATION);
            getUI().refreshRoutings();
        } catch (FieldGroup.CommitException e) {
            // Validation exceptions could be shown here
        }
    }

    public void cancel(Button.ClickEvent event) {
        // Place to call business logic.
        Notification.show("Cancelled", Type.TRAY_NOTIFICATION);
        getUI().routingList.select(null);
    }

    void edit(Routing newRouting) {
        this.routing = newRouting;
        if (newRouting != null) {
            // Bind the properties of the routing POJO to fiels in this form
            formFieldBindings = BeanFieldGroup.bindFieldsBuffered(newRouting, this);
            routeCode.setReadOnly(true);
            POL.focus();
        }
        setVisible(newRouting != null);
    }

    @Override
    public CreateRoutingUI getUI() {
        return (CreateRoutingUI) super.getUI();
    }

}
