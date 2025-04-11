package com.kajal.order_service.service;

import com.kajal.order_service.dto.ShippingInfoRequest;
import com.kajal.order_service.dto.ShippingInfoResponse;
import com.kajal.order_service.entity.ShippingInfo;
import com.kajal.order_service.repository.ShippingInfoRepository;
import com.kajal.order_service.utils.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingInfoService {

    @Autowired
    private ShippingInfoRepository shippingRepository;
    @Autowired
    private Mappers mappers;

    public List<ShippingInfoResponse> getAllShippingInfos(){
        List<ShippingInfo> shippingInfos = shippingRepository.findAll();
        return shippingInfos.stream().map(shippingInfo -> mappers.mapToShippingInfo(shippingInfo)).toList();
    }

    public ShippingInfoResponse getShippingInfo(String shippingInfoId){
        ShippingInfo shippingInfo = fetchShippingInfoById(shippingInfoId);
        return mappers.mapToShippingInfo(shippingInfo);
    }

    public ShippingInfoResponse addShippingAddress(ShippingInfoRequest shippingRequest, String userId){
        ShippingInfo shippingInfo = new ShippingInfo(
                userId,
                shippingRequest.getAddress(),
                shippingRequest.getCity(),
                shippingRequest.getState(),
                shippingRequest.getCountry(),
                shippingRequest.getPinCode(),
                shippingRequest.getPhoneNumber()
        );
        shippingInfo = shippingRepository.save(shippingInfo);
        return mappers.mapToShippingInfo(shippingInfo);
    }

    public ShippingInfoResponse updateShippingAddress(String shippingInfoId, ShippingInfoRequest shippingRequest, String userId){
        ShippingInfo shippingInfo = fetchShippingInfoById(shippingInfoId);
        if(!shippingInfo.getUserId().equals(userId)){
            throw new RuntimeException("Not allowed for user " + userId);
        }

        if(shippingRequest.getAddress() != null){
            shippingInfo.setAddress(shippingRequest.getAddress());
        }
        if(shippingRequest.getCity() != null){
            shippingInfo.setCity(shippingRequest.getCity());
        }
        if(shippingRequest.getState() != null){
            shippingInfo.setState(shippingRequest.getState());
        }
        if(shippingRequest.getCountry() != null){
            shippingInfo.setCountry(shippingRequest.getCountry());
        }
        if(shippingRequest.getPinCode() >= 0){
            shippingInfo.setPinCode(shippingRequest.getPinCode());
        }
        if(shippingRequest.getPhoneNumber() > 0){
            shippingInfo.setPhoneNumber(shippingRequest.getPhoneNumber());
        }

        shippingInfo = shippingRepository.save(shippingInfo);
        return mappers.mapToShippingInfo(shippingInfo);
    }

    public ShippingInfo fetchShippingInfoById(String shippingInfoId) {
        return shippingRepository
                .findById(shippingInfoId)
                .orElseThrow(() -> new RuntimeException("Shipping Info not found with id " + shippingInfoId));
    }
}
