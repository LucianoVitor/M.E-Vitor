    package ME_VITOR.me_backend.Email;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.beans.factory.annotation.Value;
    import org.springframework.mail.SimpleMailMessage;
    import org.springframework.mail.javamail.JavaMailSender;
    import org.springframework.stereotype.Service;

    @Service
    public class EmailService {

        @Autowired
        private JavaMailSender javaMailSender;

        @Value("$spring.mail.username")
        private String remetente;

        public String enviarEmail(String email, String assunto, String corpo) {
            try {
                SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
                simpleMailMessage.setFrom(remetente);
                simpleMailMessage.setTo(email);
                simpleMailMessage.setSubject(assunto);
                simpleMailMessage.setText(corpo);
                javaMailSender.send(simpleMailMessage);
                return "email enviado";
            } catch (Exception e) {
                throw new RuntimeException(" Erro ao Enviar email" + e.getMessage());
            }
        }
    }
