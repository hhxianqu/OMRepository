package cn.edu.nju.omrepository.service;

import cn.edu.nju.omrepository.vo.ProductVO;

import java.util.List;

public interface TempService {

    void addProduct(ProductVO productVO);

    List<ProductVO> checkProduct(String barCode);

    List<ProductVO> checkAllProduct();
}
