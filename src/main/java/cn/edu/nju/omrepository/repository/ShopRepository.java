package cn.edu.nju.omrepository.repository;

import cn.edu.nju.omrepository.entity.ShopInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<ShopInfo, Integer> {

}
