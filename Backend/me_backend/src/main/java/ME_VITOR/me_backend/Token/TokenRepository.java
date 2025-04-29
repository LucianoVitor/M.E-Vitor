package ME_VITOR.me_backend.Token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<TokenModel, Long> {
    Optional<TokenModel> findByUuid(String uuid);
    void deleteByexpiracaoBefore(Instant expiracao);
    Optional<TokenModel> findByUsuario_id(Integer id);
}
