/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecno_comfenalco.easywashproject.services;

import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.CreateEmailOptions;
import com.resend.services.emails.model.CreateEmailResponse;

/**
 *
 * @author danil
 */
public class EmailNotificationService {

    public void sendEmail(String email, String subject, String message) {
        Resend resend = new Resend("re_5H6o8y8B_7xsHTRtSCJmHDFqxCo2ap6Br");

        CreateEmailOptions params = CreateEmailOptions.builder()
                .from("EeasyWash <onboarding@resend.dev>")
                .to(email)
                .subject(subject)
                .html("<strong>" + message + "</strong>")
                .build();

        try {
            CreateEmailResponse data = resend.emails().send(params);
            System.out.println(data.getId());
        } catch (ResendException e) {
            e.printStackTrace();
        }
    }
}
