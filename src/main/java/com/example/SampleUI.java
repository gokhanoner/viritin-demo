package com.example;

import org.vaadin.viritin.MBeanFieldGroup;

import com.vaadin.annotations.Theme;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

@SpringUI
@Theme("valo")
public class SampleUI extends UI{

	private static final long serialVersionUID = -503524031921140905L;

	@Override
	protected void init(VaadinRequest request) {
		HorizontalLayout searchFormLayout = new HorizontalLayout();
		searchFormLayout.addStyleName("wrapping");
		searchFormLayout.setSpacing(true);

		BeanFieldGroup<FilterBean> filterGroup = new MBeanFieldGroup<>(FilterBean.class);
		filterGroup.setItemDataSource(new FilterBean());
		
		ComboBox name = filterGroup.buildAndBind("Type", "type", ComboBox.class);
		searchFormLayout.addComponent(name);

		DateField date = filterGroup.buildAndBind("Date", "date", DateField.class);
		searchFormLayout.addComponent(date);
		
		Button checkVal = new Button("Check Value");
		searchFormLayout.addComponent(checkVal);
		checkVal.addClickListener(event -> Notification.show(filterGroup.getItemDataSource().getBean().toString()));
		
		setContent(searchFormLayout);
	}

}
