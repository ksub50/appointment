package com.kuttan.client;

import java.util.Date;

import sun.rmi.runtime.NewThreadAction;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sun.corba.se.impl.ior.NewObjectKeyTemplateBase;

public class Appointment implements EntryPoint {
	public void onModuleLoad() {
		Label nameLabel = new Label();
		nameLabel.setText("Enter Name");
		final TextBox nameTextbox = new TextBox();

		Label dateLabel = new Label();
		dateLabel.setText("Enter Date of Joining");
		final TextBox dateTextbox = new TextBox();

		Label datehelp = new Label("dd/mm/yyyy");

		Label basicLabel = new Label();
		basicLabel.setText("Enter Basic Salary in Rs/pp ");
		final TextBox basicTextbox = new TextBox();

		Label basichelp = new Label("rs/pp");

		Label daLabel = new Label("Enter Dearness Allowance in Rs/pp");
		final TextBox daTextbox = new TextBox();

		Label hraLabel = new Label();
		hraLabel.setText("House Rent Allowance 30% Basic");
		final TextBox hraTextbox = new TextBox();

		Label totalLabel = new Label("Total Salary in Rs/pp");
		final TextBox totalsalaryTextbox = new TextBox();

		basicTextbox.addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				// Get the value from basic text
				// hra value = 03 * basic Text
				String basicValue = basicTextbox.getText();
				Double basicDoubleValue = Double.parseDouble(basicValue);
				Double hraDoubleValue = 0.3 * basicDoubleValue;
				String hraValue = String.valueOf(hraDoubleValue);
				hraTextbox.setText(hraValue);
			}
		});

		daTextbox.addBlurHandler(new BlurHandler() {
			@Override
			public void onBlur(BlurEvent event) {
				String basicValue = basicTextbox.getText();
				Double basicDoubleValue = Double.parseDouble(basicValue);
				Double hraDoubleValue = 0.3 * basicDoubleValue;
				String daValue = daTextbox.getText();
				Double daDoubleValue = Double.parseDouble(daValue);

				Double totalsalaryDoubleValue = basicDoubleValue
						+ daDoubleValue + hraDoubleValue;
				String totalsalaryValue = String
						.valueOf(totalsalaryDoubleValue);
				totalsalaryTextbox.setText(totalsalaryValue);
			}

		});
		final Label replyLabel = new Label("reply");

		Button saveButton = new Button("Save");
		// /========================
		saveButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (nameTextbox.getText().length() >0 &&
						dateTextbox.getText().length() > 0 &&
						totalsalaryTextbox.getText().length() > 0) {
					replyLabel.setText("Saved");
				} else {
					replyLabel.setText("Enter Details");
				}
			}
		});
		
		Label WorkingDaysLabel = new Label("No.of Workingdays in the month");
		final TextBox WorkingDaysTextbox = new TextBox();
		
		Label WorkedDaysLabel = new Label("No of Days Worked in the month");
		final TextBox WorkedDaysTextbox = new TextBox();
		
		Label SalaryforthemonthLabel = new Label("Salary Earned for the month");
		final TextBox SalaryforthemonthTextbox = new TextBox();
		
		WorkedDaysTextbox.addBlurHandler(new BlurHandler() {
			
			@Override
			public void onBlur(BlurEvent event) {
				String WorkingdaysValue = WorkingDaysTextbox.getText();
				Double WorkingdaysDoubleValue = Double.parseDouble(WorkingdaysValue);
				String WorkeddaysValue = WorkedDaysTextbox.getText();
				Double WorkeddaysDoubleValue = Double.parseDouble(WorkeddaysValue);
				
				String totalsalaryValue = totalsalaryTextbox.getText();
				Double totalsalaryDoubleValue = Double.parseDouble(totalsalaryValue);
				Double SalaryforthemonthDoubleValue = (totalsalaryDoubleValue/WorkingdaysDoubleValue)*WorkeddaysDoubleValue;
				String SalaryforthemonthValue = String
						.valueOf(SalaryforthemonthDoubleValue);
				SalaryforthemonthTextbox.setText(SalaryforthemonthValue);
				
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
				
		
		// /========================
		VerticalPanel vp1 = new VerticalPanel();
		vp1.add(nameLabel);
		vp1.add(dateLabel);
		vp1.add(basicLabel);
		vp1.add(daLabel);
		vp1.add(hraLabel);
		vp1.add(totalLabel);
		vp1.setSpacing(20);
		vp1.add(WorkingDaysLabel);
		vp1.add(WorkedDaysLabel);
		vp1.add(SalaryforthemonthLabel);
		vp1.add(saveButton);
		vp1.add(replyLabel);

		VerticalPanel vp2 = new VerticalPanel();
		HorizontalPanel dateHelpPanel = new HorizontalPanel();
		dateHelpPanel.add(dateTextbox);
		dateHelpPanel.add(datehelp);

		vp2.add(nameTextbox);
		vp2.add(dateHelpPanel);
		vp2.add(basicTextbox);
		vp2.add(daTextbox);
		vp2.add(hraTextbox);
		vp2.add(totalsalaryTextbox);
		vp2.setSpacing(10);
		vp2.add(WorkingDaysTextbox);
		vp2.add(WorkedDaysTextbox);
		vp2.add(SalaryforthemonthTextbox);

		VerticalPanel vp3 = new VerticalPanel();
		vp3.add(basichelp);
		vp3.setSpacing(80);

		HorizontalPanel hp1 = new HorizontalPanel();
		hp1.add(vp1);
		hp1.add(vp2);
		hp1.add(vp3);

		/*
		 * VerticalPanel vp1 = new VerticalPanel(); vp1.add(nameLabel);
		 * vp1.add(ageLabel); vp1.add(dateLabel); vp1.add(timeLabel);
		 * vp1.setSpacing(15);
		 * 
		 * VerticalPanel vp2 = new VerticalPanel(); vp2.add(nameTextbox);
		 * vp2.add(ageTextbox); vp2.add(dateHelpPanel); vp2.add(timeTextbox);
		 * vp2.setSpacing(5); HorizontalPanel hp1 = new HorizontalPanel();
		 * hp1.add(vp1); hp1.add(vp2);
		 * 
		 * HorizontalPanel hp2 = new HorizontalPanel(); hp2.add(answerButton);
		 * hp2.add(replyLabel);
		 * 
		 * VerticalPanel vp3 = new VerticalPanel(); vp3.add(hp1); vp3.add(hp2);
		 */
		RootPanel.get().add(hp1);
	}
}
