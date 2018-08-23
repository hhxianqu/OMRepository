package cn.edu.nju.omrepository.repository;

import cn.edu.nju.omrepository.entity.ProductInOrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInOrderRepository extends JpaRepository<ProductInOrderInfo, Integer> {
}
