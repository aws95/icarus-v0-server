package com.icarus.v0.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import ClickSend.ApiClient;
import ClickSend.ApiException;
import ClickSend.Api.SmsApi;
import ClickSend.Model.SmsMessage;
import ClickSend.Model.SmsMessageCollection;

@Service
public class ClickSendServiceImpl implements ClickSendService {

	@Value("${clickSend.username}")
	private String username;
	@Value("${clickSend.password}")
	private String password;

	@Override
	public void sendSms(String email, String use, String consumption, String gain, String phone, String lang) {
		ApiClient defaultClient = new ApiClient();
		defaultClient.setUsername(username);
		defaultClient.setPassword(password);
		SmsApi apiInstance = new SmsApi(defaultClient);

		SmsMessage smsMessage = new SmsMessage();
		if (lang.equals("fr")) {
			smsMessage.body("Le taux de votre consommation énergétique quotidienne : " + consumption + " DT/Jour "
					+ "\nVous consommez une journée moyenne d'électricité de : " + use + " Kw/Jour "
					+ "\nSi vous adpotez une solution d'énergie solaire à 100% aujourd'hui, vous gagnerez environ : "
					+ gain + " DT/Jour");
		} else if (lang.equals("en")) {
			smsMessage.body("The rate of your daily energy consumption : " + consumption + " TND/Day "
					+ "\nYou consume daily an average of electricity of : " + use + " TND/Day "
					+ "\nIf you were using a 100% solar power solution, you would have earned today approximately : "
					+ gain + " TND/Day");
		} else {
			smsMessage.body("معدل استهلاكك اليومي للطاقة : " + consumption + " دينار / يوم "
					+ "\r\nتستهلك يوميًا متوسط ​​كمية كهرباء : " + use + " كيلووات / يوم "
					+ "\r\nإذا كنت تستخدم الطاقة الشمسية بنسبة 100 في المائة ، فستكتسب اليوم : " + gain
					+ " دينار / يوم");
		}
		smsMessage.to(phone);

		List<SmsMessage> smsMessageList = Arrays.asList(smsMessage);
		SmsMessageCollection smsMessages = new SmsMessageCollection();
		smsMessages.messages(smsMessageList);
		try {
			String result = apiInstance.smsSendPost(smsMessages);
			System.out.println(result);
		} catch (ApiException e) {
			System.err.println("Exception when calling SmsApi#smsSendPost");
			e.printStackTrace();
		}
	}

}
