package cn.edu.nju.omrepository.service;

import cn.edu.nju.omrepository.vo.ProductVO;

import java.util.List;

public interface StoreService {

    Boolean addToStore(List<ProductVO> addToStoreList);
}
