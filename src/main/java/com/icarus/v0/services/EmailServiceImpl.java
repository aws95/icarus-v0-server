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
	public void sendEmail(String email, String use, String consumption, String gain) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(email);
		msg.setSubject("Vos statistiques solaires");
		msg.setText(
		"Le taux de votre consommation énergétique quotidienne : " + consumption + " DT "+
		"\nVous consommez une journée moyenne d'électricité de : " + use + " Kw "+
		"\nSi vous utilisiez l'énergie solaire, vous auriez gagné la journée : " + gain + " DT");
		javaMailSender.send(msg);

	}

}
