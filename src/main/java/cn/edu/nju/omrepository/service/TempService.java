package cn.edu.nju.omrepository.service;

import cn.edu.nju.omrepository.vo.ProductVO;

import java.util.List;

public interface TempService {

    void addProduct(ProductVO productVO);

    List<ProductVO> checkProductByBarcode(String barCode);

    List<ProductVO> checkProductByName(String name);

    List<ProductVO> checkAllProduct();

    ProductVO checkProductByID(int Id);


}
