package net.yorksolutions.optumfsjavadukesofyork2.repositories;
import net.yorksolutions.optumfsjavadukesofyork2.models.Coupon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends CrudRepository<Coupon, Long> {

}
