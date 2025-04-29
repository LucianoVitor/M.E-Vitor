package ME_VITOR.me_backend.Token;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
@Service
public class TokenService {
    @Autowired
    TokenRepository tokenRepository;


    public void validateToken(String uuid){
        Optional<TokenModel> optionalToken = tokenRepository.findByUuid(uuid);
        if (optionalToken.isEmpty())
        {
            throw new IllegalArgumentException("Token inválido");
        }
        TokenModel token =optionalToken.get();
        if(token.getExpiracao().isBefore(Instant.now())){
            throw new IllegalArgumentException("Token Expirado!");
        }

    }

    @Scheduled(fixedRate = 600000)
    @Transactional
    public void limparTokensExpirados() {
        Instant agora = Instant.now();
        tokenRepository.deleteByexpiracaoBefore(agora);
        System.out.println("Tokens expirados limpos em: " + agora);
    }
}
