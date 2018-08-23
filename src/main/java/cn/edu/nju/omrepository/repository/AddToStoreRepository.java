package cn.edu.nju.omrepository.repository;

import cn.edu.nju.omrepository.entity.AddToStoreInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddToStoreRepository extends JpaRepository<AddToStoreInfo, Integer> {

}
