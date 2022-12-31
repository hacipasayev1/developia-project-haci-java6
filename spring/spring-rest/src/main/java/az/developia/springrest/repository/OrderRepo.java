package az.developia.springrest.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import az.developia.springrest.model.Order;
@Transactional
public interface OrderRepo extends JpaRepository<Order, Integer>{
@Query(value = "delete from orders where customer_id=?1",nativeQuery = true)
@Modifying
public void deleteAllByCustomerId(Integer id);
}
