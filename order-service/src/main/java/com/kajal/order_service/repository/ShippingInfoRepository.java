package com.kajal.order_service.repository;

import com.kajal.order_service.entity.ShippingInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingInfoRepository extends MongoRepository<ShippingInfo, String> {
}
