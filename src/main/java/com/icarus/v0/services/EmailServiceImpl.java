package com.icarus.v0.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendEmail(String email, String use, String consumption, String gain, String lang) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(email);
		msg.setSubject("Vos statistiques solaires");
		if (lang.equals("fr")) {
			msg.setSubject("Vos statistiques d'énergie solaires");
			msg.setText("Le taux de votre consommation énergétique quotidienne : " + consumption + " DT/Jour "
					+ "\nVous consommez une journée moyenne d'électricité de : " + use + " Kw/Jour "
					+ "\nSi vous adpotez une solution d'énergie solaire à 100% aujourd'hui, vous gagnerez environ : "
					+ gain + " DT/Jour");
		} else if (lang.equals("en")) {
			msg.setSubject("Your solar energy statistics");
			msg.setText("The rate of your daily energy consumption : " + consumption + " TND/Day "
					+ "\nYou consume daily an average of electricity of : " + use + " TND/Day "
					+ "\nIf you were using a 100% solar power solution, you would have earned today approximately : "
					+ gain + " TND/Day");
		} else {
			msg.setSubject("إحصاءات الطاقة الشمسية الخاصة بك");
			msg.setText("معدل استهلاكك اليومي للطاقة : " + consumption + " دينار / يوم "
					+ "\r\nتستهلك يوميًا متوسط ​​كمية كهرباء : " + use + " كيلووات / يوم "
					+ "\r\nإذا كنت تستخدم الطاقة الشمسية بنسبة 100 في المائة ، فستكتسب : " + gain
					+ " دينار / يوم");
		}
		javaMailSender.send(msg);
	}

}
