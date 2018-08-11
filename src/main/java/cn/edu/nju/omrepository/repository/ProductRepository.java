package cn.edu.nju.omrepository.repository;

import cn.edu.nju.omrepository.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductInfo, Integer> {

    List<ProductInfo> findAll();

    List<ProductInfo> findAllByBarCodeLike(String barCode);

    List<ProductInfo> findAllByProductNameLike(String name);

    ProductInfo getById(Integer id);
}
