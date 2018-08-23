package cn.edu.nju.omrepository.repository;

import cn.edu.nju.omrepository.entity.ProductPreAddInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPreAddRepository extends JpaRepository<ProductPreAddInfo, Integer> {
}
