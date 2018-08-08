package cn.edu.nju.omrepository.service.impl;

import cn.edu.nju.omrepository.entity.ShopInfo;
import cn.edu.nju.omrepository.repository.ShopRepository;
import cn.edu.nju.omrepository.service.ShopService;
import cn.edu.nju.omrepository.vo.ShopVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ShopServiceImpl implements ShopService {

    @Resource
    private ShopRepository shopRepository;

    private void convertVOtoPO (ShopVO vo, ShopInfo po) {
        po.setShopAddress(vo.getShopAddress());
        po.setShopName(vo.getShopName());
        po.setShopPrice(vo.getShopPrice());
        po.setBeginTime(vo.getBeginTime());
        po.setEndTime(vo.getEndTime());
    }


    @Override
    public void addShop(ShopVO shopVO) {
        ShopInfo info = new ShopInfo();
        convertVOtoPO(shopVO, info);

        shopRepository.save(info);
    }
}
