package tw.com.rayalala.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tw.com.rayalala.www.entity.Banner;

/**
 * 橫幅
 *
 * @author P-C Lin (a.k.a 高科技黑手)
 */
@Repository
public interface BannerRepository extends JpaRepository<Banner, Short> {
}
