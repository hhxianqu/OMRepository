package cn.edu.nju.omrepository.service.impl;

import cn.edu.nju.omrepository.entity.ShopInfo;
import cn.edu.nju.omrepository.repository.ShopRepository;
import cn.edu.nju.omrepository.service.ShopService;
import cn.edu.nju.omrepository.vo.ShopVO;

public class ShopServiceImpl implements ShopService {

    private ShopRepository shopRepository;

    private void convertVOtoPO (ShopVO vo, ShopInfo po) {
        po.setShopAddress(vo.getShopAddress());
        po.setShopName(vo.getShopName());
        po.setShopPrice(vo.getShopPrice());
    }


    @Override
    public void addShop(ShopVO shopVO) {
        ShopInfo info = new ShopInfo();
        convertVOtoPO(shopVO, info);

        shopRepository.save(info);
    }
}
